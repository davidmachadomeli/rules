package rules.operands

import rules.constants.OperandType
/**
 * Created by dmachado on 7/1/17.
 */
class InputReadOnly extends AbstractOperand {

    InputReadOnly(String value) {
        this.type = OperandType.INPUT_READONLY
        this.value = value
    }

}
