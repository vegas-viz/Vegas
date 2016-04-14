package vegas

//import org.everit.json.schema.Schema;
//import org.everit.json.schema.loader.SchemaLoader;
//import org.json.JSONObject;
//import org.json.JSONTokener;

/**
  * @author Aish Fenton.
  */
class SpecSpec extends BaseSpec {

  def fixture = {

    val data = Data(Option(Map("population" -> "318000000", "country" -> "USA")))
    val formula = Formula("f1", "f1 * 3")
    val transform = Transform(Option(Array(formula)))
    val xcd = ChannelDef(Option("f1"), Option(QUANTITATIVE))
    val ycd = ChannelDef(Option("f2"), Option(NOMINAL))
    val encoding = Encoding(Option(xcd), Option(ycd))
    val config = Config("t")
    val mySpec = Spec(Option("myChart"), Option(data), BAR, Option(transform), Option(encoding), Option(config))

    new { val spec = mySpec }

  }

  "A Spec" should "produce valid JSON" in {
    val spec = fixture.spec
    spec.mark.name should be ("barzz")


  }

  it should "" in {

  }

}

