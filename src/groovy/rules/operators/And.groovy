package rules.operators

import rules.constants.OperatorType
import rules.operands.IOperand

/**
 * Created by dmachado on 7/1/17.
 */
class And extends AbstractOperator {

    And(IOperand... operands) {
        this.type = OperatorType.AND
        this.operands = operands
    }

}
