package vegas.DSL

import vegas.spec.Spec
import vegas.spec.Spec.{AggregateOp, SortOrder}

object SortDSL {

 def apply(field: String,
           op: AggregateOp,
           order: OptArg[SortOrder] = NoArg) = {
   Spec.SortField(field, op, order)
 }

}

