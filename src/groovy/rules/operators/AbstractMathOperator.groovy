package rules.operators

import rules.IOperator
import rules.conectors.AndConnector
import rules.conectors.OrConnector
import rules.constants.OperatorType
import rules.operands.IOperand
import rules.terms.Term

/**
 * Created by dmachado on 7/1/17.
 */
abstract class AbstractMathOperator implements IMathOperator {

    protected OperatorType type

    void updateOperands(Term term, IOperand newOperand) {
        term.addOperand(newOperand)
    }

    void updateOperator(Term term, IOperator newOperator) {
        term.setOperator(newOperator)
    }

    void addOrTerm(Term term) {
        term.setOperands([term.clone()])
        term.setOperator(new OrConnector())
        term.addOperand(new Term(new TruthinessOperator()))
    }

    void addAndTerm(Term term) {
        term.setOperands([term.clone()])
        term.setOperator(new AndConnector())
        term.addOperand(new Term(new TruthinessOperator()))
    }

    Map asMap() {
        return [ type: this.type.name ]
    }

}
