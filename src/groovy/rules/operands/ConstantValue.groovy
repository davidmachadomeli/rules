package rules.operands

import rules.constants.OperandType
/**
 * Created by dmachado on 7/1/17.
 */
class ConstantValue extends AbstractOperand {

    ConstantValue(String value) {
        this.type = OperandType.CONSTANT
        this.value = value
    }

}
