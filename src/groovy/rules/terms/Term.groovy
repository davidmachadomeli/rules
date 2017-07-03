package rules.terms

import groovy.transform.AutoClone
import rules.IMapper
import rules.IOperator
import rules.operands.IOperand

/**
 * Created by dmachado on 7/2/17.
 */
@AutoClone
class Term implements IMapper, IOperand {

    private IOperator operator
    private List<IOperand> operands

    Term(IOperator operator, List<IOperand> operands = []) {
        this.operator = operator
        this.operands = operands
    }

    void setOperands(List<IOperand> operands) {
        this.operands = operands
    }

    void addOperand(IOperand operand) {
        this.operands.add(operand)
    }

    void insertOperand(IOperand operand) {
        this.operator.updateOperands(this, operand)
    }

    Term getLastOperand() {
        return this.operands.last()
    }

    void setOperator(IOperator operator) {
        this.operator = operator
    }

    void assignOperator(IOperator operator) {
        this.operator.updateOperator(this, operator)
    }

    void addOrTerm() {
        this.operator.addOrTerm(this)
    }

    void addAndTerm() {
        this.operator.addAndTerm(this)
    }

    Map asMap() {
        Map termMap = [:]
        termMap << operator.asMap()
        termMap << [ expressions: this.operands.collect { it.asMap() } ]
        return termMap
    }

}
