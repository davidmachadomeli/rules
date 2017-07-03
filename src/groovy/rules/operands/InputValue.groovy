package rules.operands

import rules.constants.OperandType
/**
 * Created by dmachado on 7/1/17.
 */
class InputValue extends AbstractOperand {

    InputValue(String value) {
        this.type = OperandType.INPUT_VALUE
        this.value = value
    }

}
