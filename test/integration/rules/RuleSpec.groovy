package rules

import grails.test.spock.IntegrationSpec
import rules.fixture.ComplexRuleWithAnidatedConnectors
import rules.fixture.ComplexRuleWithThreeTermsInAnAndConectorInsideAnOrConnector
import rules.fixture.ComplexRuleWithThreeTermsInAnOrConector
import rules.fixture.ComplexRuleWithThreeTermsInAnOrConectorInsideAnAndConnector
import rules.fixture.ComplexRuleWithTwoTermsInAnOrConector
import rules.fixture.SimpleEqualRule
import rules.operands.ConstantValue
import rules.operands.InputValue
import rules.operators.And
import rules.operators.Equals
import rules.operators.NotEquals
import rules.operators.Or

/**
 * Created by dmachado on 7/2/17.
 */
class RuleSpec extends IntegrationSpec {

    void "test rule should reflect this: [ this.inputValue == \"03200\" ]"() {
        setup:
        Rule rule = new Rule(
            new Equals(
                new InputValue("this"),
                new ConstantValue("03200")
            )
        )

        when:
        Map ruleAsMap = rule.asMap()

        then:
        ruleAsMap == SimpleEqualRule.rule
    }

    void "test rule should reflect this: [ this.inputValue == \"03200\" || this.inputValue == \"91820\" ]"() {
        setup:
        Rule rule = new Rule(
            new Or(
                new Equals(
                    new InputValue("this"),
                    new ConstantValue("03200")
                ),
                    new Equals(
                        new InputValue("this"),
                        new ConstantValue("91820")
                )
            )
        )

        when:
        Map ruleAsMap = rule.asMap()

        then:
        ruleAsMap == ComplexRuleWithTwoTermsInAnOrConector.rule
    }

    void "test rule should reflect this: [ this.inputValue == \"03200\" || this.inputValue == \"91820\" || this.inputValue == \"05500\" ]"() {
        setup:
        Rule rule = new Rule(
            new Or(
                new Equals(
                    new InputValue("this"),
                    new ConstantValue("03200")
                ),
                new Equals(
                    new InputValue("this"),
                    new ConstantValue("91820")
                ),
                new Equals(
                    new InputValue("this"),
                    new ConstantValue("05500")
                )
            )
        )

        when:
        Map ruleAsMap = rule.asMap()

        then:
        ruleAsMap == ComplexRuleWithThreeTermsInAnOrConector.rule
    }

    void "test rule should reflect this: [ (this.inputValue == \"03200\" || this.inputValue == \"91820\" || this.inputValue == \"05500\") && this.inputValue != \"00000\" ]"() {
        setup:
        Rule rule = new Rule(
            new And(
                new Or(
                    new Equals(
                        new InputValue("this"),
                        new ConstantValue("03200")
                    ),
                    new Equals(
                        new InputValue("this"),
                        new ConstantValue("91820")
                    ),
                    new Equals(
                        new InputValue("this"),
                        new ConstantValue("05500")
                    )
                ),
                new NotEquals(
                    new InputValue("this"),
                    new ConstantValue("00000")
                )
            )
        )

        when:
        Map ruleAsMap = rule.asMap()

        then:
        ruleAsMap == ComplexRuleWithThreeTermsInAnOrConectorInsideAnAndConnector.rule
    }

    void "test rule should reflect this: [ (this.inputValue != \"03200\" && this.inputValue != \"91820\" && this.inputValue != \"05500\") || this.inputValue == \"06600\" ]"() {
        setup:
        Rule rule = new Rule(
            new Or(
                new And(
                    new NotEquals(
                        new InputValue("this"),
                        new ConstantValue("03200")
                    ),
                    new NotEquals(
                        new InputValue("this"),
                        new ConstantValue("91820")
                    ),
                    new NotEquals(
                        new InputValue("this"),
                        new ConstantValue("05500")
                    )
                ),
                new Equals(
                    new InputValue("this"),
                    new ConstantValue("06600")
                )
            )
        )

        when:
        Map ruleAsMap = rule.asMap()

        then:
        ruleAsMap == ComplexRuleWithThreeTermsInAnAndConectorInsideAnOrConnector.rule
    }

    void "test rule should reflect this: [ this.inputValue == \"03200\" || ( this.inputValue != \"00000\" && this.inputValue != \"91820\"  ) || this.inputValue == \"05500\" ]"() {
        setup:
        Rule rule = new Rule(
            new Or(
                new Equals(
                    new InputValue("this"),
                    new ConstantValue("03200")
                ),
                new And(
                    new NotEquals(
                        new InputValue("this"),
                        new ConstantValue("00000")
                    ),
                    new NotEquals(
                        new InputValue("this"),
                        new ConstantValue("91820")
                    )
                ),
                new Equals(
                    new InputValue("this"),
                    new ConstantValue("05500")
                )
            )
        )

        when:
        Map ruleAsMap = rule.asMap()

        then:
        ruleAsMap == ComplexRuleWithAnidatedConnectors.rule
    }

}
