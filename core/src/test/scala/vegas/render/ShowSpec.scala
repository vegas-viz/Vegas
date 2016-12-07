package vegas.render

import org.scalatest.{FlatSpec, Matchers}
import vegas.DSL.SpecBuilder
import vegas.{Bar, Nominal, Quantitative, Vegas}

class ShowSpec extends FlatSpec with Matchers {
  val data = Seq( Map("population" -> 318000000, "country" -> "USA"), Map("population" -> 64000000, "country" -> "UK") )

  val specBuilder: SpecBuilder = Vegas("Country Pop")
    .withData(data)
    .addTransformCalculation("pop_millions", "datum.population / 1000000")
    .encodeX("pop_millions", Quantitative)
    .encodeY("country", Nominal)
    .mark(Bar)

  "show" should "use zeppelin when it's in scope" in {
    var called: String = null
    object org {
      object apache {
        object zeppelin {
          object spark {
            object utils {
              object DisplayUtils {
                def html(str: String) = {
                  called = str
                }
              }
            }
          }
        }
      }
    }
    specBuilder.show
    assert(called != null) // can't easily compare to an expected output due to random UUID
  }

  it should "use jupyter publish.html when it's in scope" in {
    var called: String = null
    object publish {
      def html(str: String) = {
        called = str
      }
    }
    specBuilder.show
    assert(called != null)
  }

  it should "use jupyter display.html when it's in scope" in {
    var called: String = null
    object display {
      def html(str: String) = {
        called = str
      }
    }
    specBuilder.show
    assert(called != null)
  }

  it should "use toree kernel.display.content when it's in scope" in {
    var calledStr: String = null
    var calledType: String = null
    object kernel {
      object display {
        def content(typ: String, str: String) = {
          calledStr = str
          calledType = typ
        }
      }
    }
    specBuilder.show
    assert(calledStr != null)
    assert(calledType == "text/html")
  }

  it should "use window when nothing else is in scope" in {
    var called: SpecBuilder = null
    object vegas {
      object render {
        object ShowRender {
          def using(fn: SpecBuilder => Unit) = {
            new ShowRender {
              def apply(sb: SpecBuilder) = {
                called = sb
              }
            }
          }
        }
      }
    }
    specBuilder.show
    assert(called == specBuilder)
  }
}
