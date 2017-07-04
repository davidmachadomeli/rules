package rules.operators

import rules.constants.OperatorType
import rules.operands.IOperand

/**
 * Created by dmachado on 7/1/17.
 */
class Or extends AbstractOperator {

    Or(IOperand... operands) {
        this.type = OperatorType.OR
        this.operands = operands
    }

}
