package vegas.DSL

import vegas.spec.Spec

object BinDSL {

 def apply(min: OptArg[Double] = NoArg,
           max: OptArg[Double] = NoArg,
           base: OptArg[Double] = NoArg,
           step: OptArg[Double] = NoArg,
           steps: OptArg[List[Double]] = NoArg,
           minstep: OptArg[Double] = NoArg,
           div: OptArg[List[Double]] = NoArg,
           maxbins: OptArg[Double] = NoArg) = {

   Spec.Bin(min=min,
     max=max,
     base=base,
     step=step,
     steps=steps,
     minstep=minstep,
     div=div,
     maxbins=maxbins
   )
 }

}

