package rules.operands

import rules.constants.OperandType
/**
 * Created by dmachado on 7/1/17.
 */
abstract class AbstractOperand implements IOperand {

    protected OperandType type
    protected String value

    Map asMap() {
        return [
            type: this.type.getName(),
            value: this.value
        ]
    }

}
