package vegas.spec

import argus.macros.fromSchemaURL

@fromSchemaURL(
  url = "https://vega.github.io/schema/vega-lite/v1.2.0.json",
  name = "Vega",
  outPath = Some("spec/target/scala-2.12/Spec.scala")
)
object Spec
