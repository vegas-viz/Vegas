package vegas.DSL

import monocle.Lens
import monocle.macros.GenLens
import vegas.spec.Spec
import vegas.spec.Spec._

/**
  * @author Aish Fenton.
  */
trait ConfigDSL[T] extends FieldExtractor {
  self: T =>

  protected[this] def _config: Lens[T, Option[Config]]
  private val _viewport = GenLens[Config](_.viewport)
  private val _background = GenLens[Config](_.background)
  private val _numberFormat = GenLens[Config](_.numberFormat)
  private val _timeFormat = GenLens[Config](_.timeFormat)
  private val _countTitle = GenLens[Config](_.countTitle)

  private val _cell = GenLens[Config](_.cell)
  private val _mark = GenLens[Config](_.mark)
  private val _overlay = GenLens[Config](_.overlay)
  private val _scale = GenLens[Config](_.scale)
  private val _axis = GenLens[Config](_.axis)
  private val _legend = GenLens[Config](_.legend)
  private val _facet = GenLens[Config](_.facet)

  def config(viewport: OptArg[Double] = NoArg, background: OptArg[String] = NoArg, numberFormat: OptArg[String] = NoArg,
             timeFormat: OptArg[String] = NoArg, countTitle: OptArg[String] = NoArg) = {

    (_config composePrism _orElse(Config())).modify { c: Config =>
      c.copy(viewport=viewport, background=background, numberFormat=numberFormat, timeFormat=timeFormat,
        countTitle=countTitle)
    }
  }

  def configCell(width: OptArg[Double] = NoArg, height: OptArg[Double] = NoArg, clip: OptArg[Boolean] = NoArg, fill: OptArg[String] = NoArg,
                 fillOpacity: OptArg[Double] = NoArg, stroke: OptArg[String] = NoArg, strokeOpacity: OptArg[Double] = NoArg,
                 strokeWidth: OptArg[Double] = NoArg, strokeDash: OptArg[List[Double]] = NoArg, strokeDashOffset: OptArg[Double] = NoArg) = {

    val cell = CellConfig(
      width=width, height=height, clip=clip, fill=fill, fillOpacity=fillOpacity, stroke=stroke, strokeOpacity=strokeOpacity,
      strokeWidth=strokeWidth, strokeDash=strokeDash, strokeDashOffset=strokeDashOffset
    )

    (_config composePrism _orElse(Config()) composeLens _cell).set(Some(cell))(this)
  }

  def configMark(filled: OptArg[Boolean] = NoArg, color: OptArg[String] = NoArg, fill: OptArg[String] = NoArg,
                 stroke: OptArg[String] = NoArg, opacity: OptArg[Double] = NoArg, fillOpacity: OptArg[Double] = NoArg,
                 strokeOpacity: OptArg[Double] = NoArg, strokeWidth: OptArg[Double] = NoArg, strokeDash: OptArg[List[Double]] = NoArg,
                 strokeDashOffset: OptArg[Double] = NoArg, stacked: OptArg[StackOffset] = NoArg, orient: OptArg[Orient] = NoArg,
                 interpolate: OptArg[Interpolate] = NoArg, tension: OptArg[Double] = NoArg, lineSize: OptArg[Double] = NoArg,
                 ruleSize: OptArg[Double] = NoArg, barSize: OptArg[Double] = NoArg, barThinSize: OptArg[Double] = NoArg,
                 shape: OptArg[Shape] = NoArg, size: OptArg[Double] = NoArg, tickSize: OptArg[Double] = NoArg,
                 tickThickness: OptArg[Double] = NoArg, align: OptArg[HorizontalAlign] = NoArg, angle: OptArg[Double] = NoArg,
                 baseline: OptArg[VerticalAlign] = NoArg, dx: OptArg[Double] = NoArg, dy: OptArg[Double] = NoArg,
                 radius: OptArg[Double] = NoArg, theta: OptArg[Double] = NoArg, font: OptArg[String] = NoArg,
                 fontSize: OptArg[Double] = NoArg, fontStyle: OptArg[FontStyle] = NoArg, fontWeight: OptArg[FontWeight] = NoArg,
                 format: OptArg[String] = NoArg, shortTimeLabels: OptArg[Boolean] = NoArg, text: OptArg[String] = NoArg,
                 applyColorToBackground: OptArg[Boolean] = NoArg) = {

    val mark = MarkConfig(filled=filled, color=color, fill=fill, stroke=stroke, opacity=opacity, fillOpacity=fillOpacity,
      strokeOpacity=strokeOpacity, strokeWidth=strokeWidth, strokeDash=strokeDash, strokeDashOffset=strokeDashOffset, stacked=stacked,
      orient=orient, interpolate=interpolate, tension=tension, lineSize=lineSize, ruleSize=ruleSize, barSize=barSize, barThinSize=barThinSize,
      shape=shape, size=size, tickSize=tickSize, tickThickness=tickThickness, align=align, angle=angle, baseline=baseline,
      dx=dx, dy=dy, radius=radius, theta=theta, font=font, fontSize=fontSize, fontStyle=fontStyle, fontWeight=fontWeight, format=format,
      shortTimeLabels=shortTimeLabels, text=text, applyColorToBackground=applyColorToBackground)

    (_config composePrism _orElse(Config()) composeLens _mark).set(Some(mark))(this)
  }


  def configOverlay(line: OptArg[Boolean] = NoArg, area: OptArg[AreaOverlay] = NoArg, pointStyle: OptArg[MarkConfig] = NoArg,
                           lineStyle: OptArg[MarkConfig] = NoArg) = {

    val overlay = Spec.OverlayConfig(line=line, area=area, pointStyle=pointStyle, lineStyle=lineStyle)

    (_config composePrism _orElse(Config()) composeLens _overlay).set(Some(overlay))(this)
  }


  def configScale(round: OptArg[Boolean] = NoArg, textBandWidth: OptArg[Double] = NoArg, bandSize: OptArg[Double] = NoArg,
                  opacity: OptArg[List[Double]] = NoArg, padding: OptArg[Double] = NoArg, useRawDomain: OptArg[Boolean] = NoArg,
                  nominalColorRange: OptArg[ScaleConfig.NominalColorRangeListString] = NoArg,
                  sequentialColorRange: OptArg[ScaleConfig.SequentialColorRangeListString] = NoArg,
                  shapeRange: OptArg[ScaleConfig.ShapeRangeListString] = NoArg,
                  barSizeRange: OptArg[List[Double]] = NoArg, fontSizeRange: OptArg[List[Double]] = NoArg,
                  ruleSizeRange: OptArg[List[Double]] = NoArg, tickSizeRange: OptArg[List[Double]] = NoArg,
                  pointSizeRange: OptArg[List[Double]] = NoArg) = {


    val scale = ScaleConfig(round=round, textBandWidth=textBandWidth, bandSize=bandSize, opacity=opacity, padding=padding,
      useRawDomain=useRawDomain, nominalColorRange=nominalColorRange, sequentialColorRange=sequentialColorRange, shapeRange=shapeRange,
      barSizeRange=barSizeRange, fontSizeRange=fontSizeRange, ruleSizeRange=ruleSizeRange, tickSizeRange=tickSizeRange,
      pointSizeRange=pointSizeRange)

    (_config composePrism _orElse(Config()) composeLens _scale).set(Some(scale))(this)

  }
  // 35
  def configAxis(axisWidth: OptArg[Double] = NoArg, layer: OptArg[String] = NoArg, offset: OptArg[Double] = NoArg,
                 axisColor: OptArg[String] = NoArg, grid: OptArg[Boolean] = NoArg, gridColor: OptArg[String] = NoArg,
                 gridDash: OptArg[List[Double]] = NoArg, gridOpacity: OptArg[Double] = NoArg, gridWidth: OptArg[Double] = NoArg,
                 labels: OptArg[Boolean] = NoArg, labelAngle: OptArg[Double] = NoArg, labelAlign: OptArg[String] = NoArg,
                 labelBaseline: OptArg[String] = NoArg, labelMaxLength: OptArg[Double] = NoArg, shortTimeLabels: OptArg[Boolean] = NoArg,
                 subdivide: OptArg[Double] = NoArg, ticks: OptArg[Double] = NoArg, tickColor: OptArg[String] = NoArg,
                 tickLabelColor: OptArg[String] = NoArg, tickLabelFont: OptArg[String] = NoArg, tickLabelFontSize: OptArg[Double] = NoArg,
                 tickPadding: OptArg[Double] = NoArg, tickSize: OptArg[Double] = NoArg, tickSizeMajor: OptArg[Double] = NoArg,
                 tickSizeMinor: OptArg[Double] = NoArg, tickSizeEnd: OptArg[Double] = NoArg, tickWidth: OptArg[Double] = NoArg,
                 titleColor: OptArg[String] = NoArg, titleFont: OptArg[String] = NoArg, titleFontSize: OptArg[Double] = NoArg,
                 titleFontWeight: OptArg[String] = NoArg, titleOffset: OptArg[Double] = NoArg, titleMaxLength: OptArg[Double] = NoArg,
                 characterWidth: OptArg[Double] = NoArg, properties: OptArg[AxisConfig.Properties] = NoArg) = {

    val axis = AxisConfig(axisWidth=axisWidth, layer=layer, offset=offset, axisColor=axisColor, grid=grid, gridColor=gridColor,
      gridDash=gridDash, gridOpacity=gridOpacity, gridWidth=gridWidth, labels=labels, labelAngle=labelAngle, labelAlign=labelAlign,
      labelBaseline=labelBaseline, labelMaxLength=labelMaxLength, shortTimeLabels=shortTimeLabels, subdivide=subdivide, ticks=ticks,
      tickColor=tickColor, tickLabelColor=tickLabelColor, tickLabelFont=tickLabelFont, tickLabelFontSize=tickLabelFontSize,
      tickPadding=tickPadding, tickSize=tickSize, tickSizeMajor=tickSizeMajor, tickSizeMinor=tickSizeMinor, tickSizeEnd=tickSizeEnd,
      tickWidth=tickWidth, titleColor=titleColor, titleFont=titleFont, titleFontSize=titleFontSize, titleFontWeight=titleFontWeight,
      titleOffset=titleOffset, titleMaxLength=titleMaxLength, characterWidth=characterWidth, properties=properties)

    (_config composePrism _orElse(Config()) composeLens _axis).set(Some(axis))(this)
  }

  def configLegend(orient: OptArg[String] = NoArg, offset: OptArg[Double] = NoArg, padding: OptArg[Double] = NoArg,
                   margin: OptArg[Double] = NoArg, gradientStrokeColor: OptArg[String] = NoArg, gradientStrokeWidth: OptArg[Double] = NoArg,
                   gradientHeight: OptArg[Double] = NoArg, gradientWidth: OptArg[Double] = NoArg, labelAlign: OptArg[String] = NoArg,
                   labelBaseline: OptArg[String] = NoArg, labelColor: OptArg[String] = NoArg, labelFont: OptArg[String] = NoArg,
                   labelFontSize: OptArg[Double] = NoArg, labelOffset: OptArg[Double] = NoArg, shortTimeLabels: OptArg[Boolean] = NoArg,
                   symbolColor: OptArg[String] = NoArg, symbolShape: OptArg[String] = NoArg, symbolSize: OptArg[Double] = NoArg,
                   symbolStrokeWidth: OptArg[Double] = NoArg, titleColor: OptArg[String] = NoArg, titleFont: OptArg[String] = NoArg,
                   titleFontSize: OptArg[Double] = NoArg, titleFontWeight: OptArg[String] = NoArg,
                   properties: OptArg[LegendConfig.Properties] = NoArg) = {


    val legend = LegendConfig(orient=orient, offset=offset, padding=padding, margin=margin, gradientStrokeColor=gradientStrokeColor,
      gradientStrokeWidth=gradientStrokeWidth, gradientHeight=gradientHeight, gradientWidth=gradientWidth, labelAlign=labelAlign,
      labelBaseline=labelBaseline, labelColor=labelColor, labelFont=labelFont, labelFontSize=labelFontSize, labelOffset=labelOffset,
      shortTimeLabels=shortTimeLabels, symbolColor=symbolColor, symbolShape=symbolShape, symbolSize=symbolSize, symbolStrokeWidth=symbolStrokeWidth,
      titleColor=titleColor, titleFont=titleFont, titleFontSize=titleFontSize, titleFontWeight=titleFontWeight, properties=properties)

    (_config composePrism _orElse(Config()) composeLens _legend).set(Some(legend))(this)
  }


  def configFacet(scale: OptArg[FacetScaleConfig] = NoArg, axis: OptArg[AxisConfig] = NoArg, grid: OptArg[FacetGridConfig] = NoArg,
                         cell: OptArg[CellConfig] = NoArg) = {

    val facet = FacetConfig(scale=scale, axis=axis, grid=grid, cell=cell)

    (_config composePrism _orElse(Config()) composeLens _facet).set(Some(facet))(this)
  }

}

object FacetScaleConfigDSL {
  def apply(round: OptArg[Boolean] = NoArg, padding: OptArg[Double] = NoArg) = FacetScaleConfig(round, padding)
}

object FacetGridConfigDSL {
  def apply(color: OptArg[String] = NoArg, opacity: OptArg[Double] = NoArg, offset: OptArg[Double] = NoArg) =
    FacetGridConfig(color, opacity, offset)
}

object AxisConfigDSL {

  def apply(axisWidth: OptArg[Double] = NoArg,
            layer: OptArg[String] = NoArg,
            offset: OptArg[Double] = NoArg,
            axisColor: OptArg[String] = NoArg,
            grid: OptArg[Boolean] = NoArg,
            gridColor: OptArg[String] = NoArg,
            gridDash: OptArg[List[Double]] = NoArg,
            gridOpacity: OptArg[Double] = NoArg,
            gridWidth: OptArg[Double] = NoArg,
            labels: OptArg[Boolean] = NoArg,
            labelAngle: OptArg[Double] = NoArg,
            labelAlign: OptArg[String] = NoArg,
            labelBaseline: OptArg[String] = NoArg,
            labelMaxLength: OptArg[Double] = NoArg,
            shortTimeLabels: OptArg[Boolean] = NoArg,
            subdivide: OptArg[Double] = NoArg,
            ticks: OptArg[Double] = NoArg,
            tickColor: OptArg[String] = NoArg,
            tickLabelColor: OptArg[String] = NoArg,
            tickLabelFont: OptArg[String] = NoArg,
            tickLabelFontSize: OptArg[Double] = NoArg,
            tickPadding: OptArg[Double] = NoArg,
            tickSize: OptArg[Double] = NoArg,
            tickSizeMajor: OptArg[Double] = NoArg,
            tickSizeMinor: OptArg[Double] = NoArg,
            tickSizeEnd: OptArg[Double] = NoArg,
            tickWidth: OptArg[Double] = NoArg,
            titleColor: OptArg[String] = NoArg,
            titleFont: OptArg[String] = NoArg,
            titleFontSize: OptArg[Double] = NoArg,
            titleFontWeight: OptArg[String] = NoArg,
            titleOffset: OptArg[Double] = NoArg,
            titleMaxLength: OptArg[Double] = NoArg,
            characterWidth: OptArg[Double] = NoArg,
            properties: OptArg[AxisConfig.Properties] = NoArg) =

    AxisConfig(
      axisWidth = axisWidth,
      layer = layer,
      offset = offset,
      axisColor = axisColor,
      grid = grid,
      gridColor = gridColor,
      gridDash = gridDash,
      gridOpacity = gridOpacity,
      gridWidth = gridWidth,
      labels = labels,
      labelAngle = labelAngle,
      labelAlign = labelAlign,
      labelBaseline = labelBaseline,
      labelMaxLength = labelMaxLength,
      shortTimeLabels = shortTimeLabels,
      subdivide = subdivide,
      ticks = ticks,
      tickColor = tickColor,
      tickLabelColor = tickLabelColor,
      tickLabelFont = tickLabelFont,
      tickLabelFontSize = tickLabelFontSize,
      tickPadding = tickPadding,
      tickSize = tickSize,
      tickSizeMajor = tickSizeMajor,
      tickSizeMinor = tickSizeMinor,
      tickSizeEnd = tickSizeEnd,
      tickWidth = tickWidth,
      titleColor = titleColor,
      titleFont = titleFont,
      titleFontSize = titleFontSize,
      titleFontWeight = titleFontWeight,
      titleOffset = titleOffset,
      titleMaxLength = titleMaxLength,
      characterWidth = characterWidth,
      properties = properties)

}

object MarkConfigDSL {

  def apply(filled: OptArg[Boolean] = NoArg,
            color: OptArg[String] = NoArg,
            fill: OptArg[String] = NoArg,
            stroke: OptArg[String] = NoArg,
            opacity: OptArg[Double] = NoArg,
            fillOpacity: OptArg[Double] = NoArg,
            strokeOpacity: OptArg[Double] = NoArg,
            strokeWidth: OptArg[Double] = NoArg,
            strokeDash: OptArg[List[Double]] = NoArg,
            strokeDashOffset: OptArg[Double] = NoArg,
            stacked: OptArg[StackOffset] = NoArg,
            orient: OptArg[Orient] = NoArg,
            interpolate: OptArg[Interpolate] = NoArg,
            tension: OptArg[Double] = NoArg,
            lineSize: OptArg[Double] = NoArg,
            ruleSize: OptArg[Double] = NoArg,
            barSize: OptArg[Double] = NoArg,
            barThinSize: OptArg[Double] = NoArg,
            shape: OptArg[Shape] = NoArg,
            size: OptArg[Double] = NoArg,
            tickSize: OptArg[Double] = NoArg,
            tickThickness: OptArg[Double] = NoArg,
            align: OptArg[HorizontalAlign] = NoArg,
            angle: OptArg[Double] = NoArg,
            baseline: OptArg[VerticalAlign] = NoArg,
            dx: OptArg[Double] = NoArg,
            dy: OptArg[Double] = NoArg,
            radius: OptArg[Double] = NoArg,
            theta: OptArg[Double] = NoArg,
            font: OptArg[String] = NoArg,
            fontSize: OptArg[Double] = NoArg,
            fontStyle: OptArg[FontStyle] = NoArg,
            fontWeight: OptArg[FontWeight] = NoArg,
            format: OptArg[String] = NoArg,
            shortTimeLabels: OptArg[Boolean] = NoArg,
            text: OptArg[String] = NoArg,
            applyColorToBackground: OptArg[Boolean] = NoArg) =

    MarkConfig(
      filled = filled,
      color = color,
      fill = fill,
      stroke = stroke,
      opacity = opacity,
      fillOpacity = fillOpacity,
      strokeOpacity = strokeOpacity,
      strokeWidth = strokeWidth,
      strokeDash = strokeDash,
      strokeDashOffset = strokeDashOffset,
      stacked = stacked,
      orient = orient,
      interpolate = interpolate,
      tension = tension,
      lineSize = lineSize,
      ruleSize = ruleSize,
      barSize = barSize,
      barThinSize = barThinSize,
      shape = shape,
      size = size,
      tickSize = tickSize,
      tickThickness = tickThickness,
      align = align,
      angle = angle,
      baseline = baseline,
      dx = dx,
      dy = dy,
      radius = radius,
      theta = theta,
      font = font,
      fontSize = fontSize,
      fontStyle = fontStyle,
      fontWeight = fontWeight,
      format = format,
      shortTimeLabels = shortTimeLabels,
      text = text,
      applyColorToBackground = applyColorToBackground)

}

object CellConfigDSL {

  def apply(width: OptArg[Double] = NoArg,
            height: OptArg[Double] = NoArg,
            clip: OptArg[Boolean] = NoArg,
            fill: OptArg[String] = NoArg,
            fillOpacity: OptArg[Double] = NoArg,
            stroke: OptArg[String] = NoArg,
            strokeOpacity: OptArg[Double] = NoArg,
            strokeWidth: OptArg[Double] = NoArg,
            strokeDash: OptArg[List[Double]] = NoArg,
            strokeDashOffset: OptArg[Double] = NoArg) =

    CellConfig(
      width=width,
      height=height,
      clip=clip,
      fill=fill,
      fillOpacity=fillOpacity,
      stroke=stroke,
      strokeOpacity=strokeOpacity,
      strokeWidth=strokeWidth,
      strokeDash=strokeDash,
      strokeDashOffset=strokeDashOffset
    )
}

