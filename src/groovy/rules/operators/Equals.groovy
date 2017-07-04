package rules.operators
import rules.constants.OperatorType
import rules.operands.IOperand

/**
 * Created by dmachado on 7/1/17.
 */
class Equals extends AbstractOperator {

    Equals(IOperand... operands) {
        this.type = OperatorType.EQUALS
        this.operands = operands
    }

}
