package rules.operators
import rules.constants.OperatorType
import rules.operands.IOperand

/**
 * Created by dmachado on 7/1/17.
 */
abstract class AbstractOperator implements IOperator {

    protected OperatorType type
    protected List<IOperand> operands

    Map asMap() {
        return [
            type: this.type.name,
            expressions: this.operands.collect { it.asMap() }
        ]
    }

}
