package vegas.DSL

import vegas.spec.Spec
import vegas.spec.Spec.{RangeStep, Scale, ScaleType}

object ScaleDSL {

  def apply(scaleType: OptArg[ScaleType] = NoArg,
            domainValues: OptArg[List[Double]] = NoArg,
            domainNominals: OptArg[List[String]] = NoArg,
            rangeValues: OptArg[List[Double]] = NoArg,
            rangeNominals: OptArg[List[String]] = NoArg,
            rangePreset: OptArg[String] = NoArg,
            round: OptArg[Boolean] = NoArg,
            rangeStep: OptArg[Double] = NoArg,
            rangeStepPreset: OptArg[RangeStep] = NoArg,
            padding: OptArg[Double] = NoArg,
            clamp: OptArg[Boolean] = NoArg,
            nice: OptArg[Spec.NiceTime] = NoArg,
            niceEnable: OptArg[Boolean] = NoArg,
            exponent: OptArg[Double] = NoArg,
            zero: OptArg[Boolean] = NoArg,
            useRawDomain: OptArg[Boolean] = NoArg,
            scheme: OptArg[String] = NoArg) = {

    val domainU = (domainValues.map(Scale.DomainListDouble(_)) orElse domainNominals.map(Scale.DomainListString(_)))

    val rangeU = (rangeValues.map(Scale.RangeListDouble(_)) orElse rangeNominals.map(Scale.RangeListString(_))
      orElse rangePreset.map(Scale.RangeString(_)))

    val niceU = (nice.map(Scale.NiceNiceTime(_)) orElse niceEnable.map(Scale.NiceBoolean(_)))

    val rangeStepU = (rangeStep.map(Scale.RangeStepDouble(_)) orElse rangeStepPreset.map(Scale.RangeStepRangeStep(_)))

    Spec.Scale(`type`=scaleType, domain=domainU, range=rangeU, round=round, rangeStep=rangeStepU, padding=padding,
      clamp=clamp, nice=niceU, exponent=exponent, zero=zero, useRawDomain=useRawDomain, scheme=scheme)
  }

}
