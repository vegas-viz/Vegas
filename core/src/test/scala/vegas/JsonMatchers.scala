package vegas

import argus.json.JsonDiff
import org.scalactic.Equality
import io.circe._
import cats.syntax.either._
import org.scalatest.matchers.{ MatchResult, Matcher }

// TODO This is copy-and-pasted from argus. Really needs to be put somewhere shared.
trait JsonMatchers {

  def beSameJsonAs(jrStr: String): Matcher[Json] = new Matcher[Json] {
    def apply(jl: Json) = {
      val jr = parser.parse(jrStr).toOption.get
      beSameJsonAs(jr)(jl)
    }
  }

  def beSameJsonAs(jr: Json): Matcher[Json] = new Matcher[Json] {
    def apply(jl: Json) = {
      val diff = JsonDiff.diff(jl, jr)
      MatchResult(diff.isEmpty, "Differences found in json: " + diff.mkString(","), "No differences found!")
    }
  }

  implicit val jsonEq = new Equality[Json] {
    def areEqual(a: Json, b: Any): Boolean =
      b match {
        case c: Json => JsonDiff.diff(a, c) == Nil
        case c: String => JsonDiff.diff(a, parser.parse(c).toOption.get) == Nil
        case _ => false
      }
  }

}
