package rules

import rules.operands.IOperand
import rules.operators.NullOperator
import rules.terms.Term

/**
 * Created by dmachado on 7/1/17.
 */
class Rule {

    private Term expression = new Term(new NullOperator())

    void insertOperand(IOperand operand) {
        this.expression.insertOperand(operand)
    }

    void assignOperator(IOperator operator) {
        this.expression.assignOperator(operator)
    }

    void addOrTerm() {
        this.expression.addOrTerm()
    }

    void addAndTerm() {
        this.expression.addAndTerm()
    }

    public Map asMap() {
        return expression.asMap()
    }

}
