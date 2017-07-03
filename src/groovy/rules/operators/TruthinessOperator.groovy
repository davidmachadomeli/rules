package rules.operators

import rules.IOperator
import rules.operands.IOperand
import rules.terms.Term

/**
 * Created by dmachado on 7/2/17.
 */
class TruthinessOperator implements IOperator {

    void updateOperands(Term term, IOperand newOperand) {
        term.addOperand(newOperand)
    }

    void updateOperator(Term term, IOperator newOperator) {
        Term lastTerm = term.getLastOperand()
        lastTerm.setOperator(newOperator)
    }

    void addOrTerm(Term term) {
        throw new Exception("No aplica")
    }

    void addAndTerm(Term term) {
        throw new Exception("No aplica")
    }

    Map asMap() {
        return [:]
    }

}
