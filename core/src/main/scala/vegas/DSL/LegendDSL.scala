package vegas.DSL

import vegas.spec.Spec

object LegendDSL {

 def apply(format: OptArg[String] = NoArg,
           title: OptArg[String] = NoArg,
           values: OptArg[List[Spec.Legend.Values]] = NoArg,
           orient: OptArg[String] = NoArg,
           offset: OptArg[Double] = NoArg,
           padding: OptArg[Double] = NoArg,
           margin: OptArg[Double] = NoArg,
           gradientStrokeColor: OptArg[String] = NoArg,
           gradientStrokeWidth: OptArg[Double] = NoArg,
           gradientHeight: OptArg[Double] = NoArg,
           gradientWidth: OptArg[Double] = NoArg,
           labelAlign: OptArg[String] = NoArg,
           labelBaseline: OptArg[String] = NoArg,
           labelColor: OptArg[String] = NoArg,
           labelFont: OptArg[String] = NoArg,
           labelFontSize: OptArg[Double] = NoArg,
           labelOffset: OptArg[Double] = NoArg,
           shortTimeLabels: OptArg[Boolean] = NoArg,
           symbolColor: OptArg[String] = NoArg,
           symbolShape: OptArg[String] = NoArg,
           symbolSize: OptArg[Double] = NoArg,
           symbolStrokeWidth: OptArg[Double] = NoArg,
           titleColor: OptArg[String] = NoArg,
           titleFont: OptArg[String] = NoArg,
           titleFontSize: OptArg[Double] = NoArg,
           titleFontWeight: OptArg[String] = NoArg,
           properties: OptArg[Spec.Legend.Properties] = NoArg) = {

   Spec.Legend(
     format = format,
     title = title,
     values = values,
     orient = orient,
     offset = offset,
     padding = padding,
     margin= margin,
     gradientStrokeColor = gradientStrokeColor,
     gradientStrokeWidth = gradientStrokeWidth,
     gradientHeight = gradientHeight,
     gradientWidth = gradientWidth,
     labelAlign = labelAlign,
     labelBaseline = labelBaseline,
     labelColor = labelColor,
     labelFont = labelFont,
     labelFontSize = labelFontSize,
     labelOffset = labelOffset,
     shortTimeLabels = shortTimeLabels,
     symbolColor = symbolColor,
     symbolShape = symbolShape,
     symbolSize = symbolSize,
     symbolStrokeWidth= symbolStrokeWidth,
     titleColor = titleColor,
     titleFont = titleFont,
     titleFontSize = titleFontSize,
     titleFontWeight = titleFontWeight,
     properties = properties
   )
 }
}

