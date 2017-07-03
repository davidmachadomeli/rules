package rules

import rules.operands.ConstantValue
import rules.operands.InputValue
import rules.operators.EqualsOperator
import rules.operators.NotEqualsOperator

/**
 * Created by dmachado on 7/1/17.
 */
class RuleBuilder {

    private Rule rule = new Rule()

    RuleBuilder valueOfInput(String value) {
        this.rule.insertOperand(new InputValue(value))
        return this
    }

    RuleBuilder constantValueOf(String value) {
        this.rule.insertOperand(new ConstantValue(value))
        return this
    }

    RuleBuilder equals() {
        this.rule.assignOperator(new EqualsOperator())
        return this
    }

    RuleBuilder notEquals() {
        this.rule.assignOperator(new NotEqualsOperator())
        return this
    }

    RuleBuilder or() {
        this.rule.addOrTerm()
        return this
    }

    RuleBuilder and() {
        this.rule.addAndTerm()
        return this
    }

    Rule build() {
        return this.rule
    }

}
