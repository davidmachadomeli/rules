package rules.operators

import rules.constants.OperatorType
import rules.operands.IOperand

/**
 * Created by dmachado on 7/1/17.
 */
class NotEquals extends AbstractOperator {

    NotEquals(IOperand... operands) {
        this.type = OperatorType.NOT_EQUALS
        this.operands = operands
    }

}
