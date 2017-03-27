package vegas.util

import java.io.File

import scala.io.Source

trait NotebookGenerator {

  val PlotBlock = """Vegas(.layered)?\((.+\n)+\n""".r
  val Indent = """\n(\s*)""".r
  val Title = """Vegas(.layered)?\("(.*)"\)""".r

  def preamble(version: String): List[(String,String)]

  private def extractPlotSources(files: List[File]): List[(String, String)] = files.flatMap(extractPlotSources)

  // Extract blocks of plot code. A plot starts with "Vegas" and ends with a blank line
  private def extractPlotSources(file: File): List[(String, String)] = {
    val code = Source.fromFile(file).getLines().mkString("\n")
    PlotBlock.findAllIn(code).toList.map { block =>
      val title = Title.findFirstMatchIn(block).map(_.group(2)).getOrElse("")
      val code = format(block) + ".\n  show"
      (title, code)
    }
  }

  protected def mkNotebook(plots: List[(String, String)]): String

  protected def format(s: String) = {
    // Base on indent level after first line break, since first line doesn't include
    // it's indent.
    val indent = Indent.findFirstMatchIn(s).map(_.group(1).length - 2).getOrElse(0)

    // Break into lines, and remove indent
    val parts = s.split("\n").toList
    (parts.head.trim :: parts.tail.map(_.drop(indent))).mkString("\n")
  }

  protected def escapeJson(s: String) = s.
    replace("\\", "\\\\").
    replace("\"", "\\\"").
    replace("\n", "\\n")


  def generate(version: String, files: List[File]) = {
    mkNotebook(preamble(version) ++ extractPlotSources(files))
  }
}

class JupyterGenerator extends NotebookGenerator {

  def toJsonStrings(s: String) = s.split("\n").
    map { line =>
      if (line.isEmpty) "" else "\"" + escapeJson(line) + "\\n\""
    }.
    filterNot(_.isEmpty)

  def preamble(version: String) =
    ("", "import $ivy.`org.vegas-viz::vegas:" + s"$version`") ::
    ("", """
      |import vegas._
      |import vegas.data.External._""".stripMargin
    ) ::
    Nil

  def mkNotebook(blocks: List[(String, String)]) = {
    s"""
      | {
      |   "cells": [ ${ blocks.map(mkCell).mkString(",") } ],
      |   "metadata": {
      |     "kernelspec": {
      |       "display_name": "Scala 2.11",
      |       "language": "scala211",
      |       "name": "scala211"
      |     },
      |     "language_info": {
      |       "codemirror_mode": "text/x-scala",
      |       "file_extension": ".scala",
      |       "mimetype": "text/x-scala",
      |       "name": "scala211",
      |       "pygments_lexer": "scala",
      |       "version": "2.11.6"
      |     }
      |   },
      |   "nbformat": 4,
      |   "nbformat_minor": 0
      | }
    """.stripMargin
  }

  def mkCell(block: (String, String)) = {
    val title =
      s"""
        | {
        |   "cell_type" : "markdown",
        |   "metadata": {},
        |   "source": [ "# ${ block._1 }" ]
        | },
      """.stripMargin

    val code = s"""
      | {
      |   "cell_type" : "code",
      |   "execution_count": null,
      |   "outputs": [],
      |   "metadata": {},
      |   "source": [ ${toJsonStrings(block._2).mkString(",") } ]
      | }
    """.stripMargin

    if (block._1.isEmpty) code else title + code
  }

}


class ZeppelinGenerator extends NotebookGenerator {

  def preamble(version: String) =
    ("", s"""
     |%dep
     |z.load("org.vegas-viz:vegas-spark_2.11:${version}")""".stripMargin) ::
    ("", """
     |import vegas._
     |import vegas.data.External._""".stripMargin) ::
    Nil

  def mkNotebook(plots: List[(String, String)]) = {
    s"""
       | {
       |   "name": "Vegas Examples",
       |   "angularObjects": {},
       |   "paragraphs": [ ${ plots.map(mkCell).mkString(",") } ]
       | }
    """.stripMargin
  }

  def mkCell(block: (String, String)) =
    s"""
       | {
       |   "config": { "title": ${ if (block._1.isEmpty) "false" else "true" } },
       |   "title": "${block._1}",
       |   "text": "${ escapeJson(block._2) }"
       | }
    """.stripMargin

}

object GenerateNotebooks extends App {
  val jupyterGenerator = new JupyterGenerator
  val zepGenerator = new ZeppelinGenerator

  def gen(name: String, generator: NotebookGenerator, version: String, sources: List[File], destDir: File) = {
    require(destDir.isDirectory)
    val json = generator.generate(version, sources)

    val dest = new File(destDir, name)
    val out = new java.io.PrintWriter(dest)
    out.write(json)
    out.close()
  }

  val version = args(0)
  val sources = args.toList.drop(1).take(args.length - 2).map(new File(_))
  val destDir = new File(args.last)

  gen("jupyter_example.ipynb", jupyterGenerator, version, sources, destDir)
  gen("zeppelin_example.json", zepGenerator, version, sources, destDir)
}
