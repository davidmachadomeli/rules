package rules.conectors

import rules.IOperator
import rules.constants.ConnectorType
import rules.operands.IOperand
import rules.operators.TruthinessOperator
import rules.terms.Term

/**
 * Created by dmachado on 7/1/17.
 */
class OrConnector implements IBooleanOperator {

    private ConnectorType type = ConnectorType.OR

    void updateOperands(Term term, IOperand newOperand) {
        Term lastTerm = term.getLastOperand()
        lastTerm.addOperand(newOperand)
    }

    void updateOperator(Term term, IOperator newOperator) {
        Term lastTerm = term.getLastOperand()
        lastTerm.setOperator(newOperator)
    }

    void addOrTerm(Term term) {
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
