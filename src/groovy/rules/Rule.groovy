package rules

import rules.operators.IOperator

/**
 * Created by dmachado on 7/1/17.
 */
class Rule {

    private IOperator operator

    Rule(IOperator operator) {
        this.operator = operator
    }

    public Map asMap() {
        return this.operator.asMap()
    }

}
