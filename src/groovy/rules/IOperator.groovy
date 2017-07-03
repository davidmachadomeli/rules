package rules

import rules.operands.IOperand
import rules.terms.Term

/**
 * Created by dmachado on 7/1/17.
 */
interface IOperator extends IMapper {

    void updateOperands(Term term, IOperand newOperand)

    void updateOperator(Term term, IOperator newOperator)

    void addOrTerm(Term term)

    void addAndTerm(Term term)

}
