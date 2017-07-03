package rules

import grails.test.spock.IntegrationSpec
import rules.fixture.ComplexRuleWithThreeTermsInAnAndConectorInsideAnOrConnector
import rules.fixture.ComplexRuleWithThreeTermsInAnOrConector
import rules.fixture.ComplexRuleWithThreeTermsInAnOrConectorInsideAnAndConnector
import rules.fixture.ComplexRuleWithTwoTermsInAnOrConector
import rules.fixture.SimpleEqualRule

/**
 * Created by dmachado on 7/2/17.
 */
class RuleSpec extends IntegrationSpec {

    void "test rule should reflect this: [ this.inputValue == \"03200\" ]"() {
        setup:
        Rule rule = new RuleBuilder()
                .valueOfInput("this")
                .equals()
                .constantValueOf("03200")
                .build()

        when:
        Map ruleAsMap = rule.asMap()

        then:
        ruleAsMap == SimpleEqualRule.rule
    }

    void "test rule should reflect this: [ this.inputValue == \"03200\" || this.inputValue == \"91820\" ]"() {
        setup:
        Rule rule = new RuleBuilder()
                .valueOfInput("this")
                .equals()
                .constantValueOf("03200")
                .or()
                .valueOfInput("this")
                .equals()
                .constantValueOf("91820")
                .build()

        when:
        Map ruleAsMap = rule.asMap()

        then:
        ruleAsMap == ComplexRuleWithTwoTermsInAnOrConector.rule
    }

    void "test rule should reflect this: [ this.inputValue == \"03200\" || this.inputValue == \"91820\" || this.inputValue == \"05500\" ]"() {
        setup:
        Rule rule = new RuleBuilder()
                .valueOfInput("this")
                .equals()
                .constantValueOf("03200")
                .or()
                .valueOfInput("this")
                .equals()
                .constantValueOf("91820")
                .or()
                .valueOfInput("this")
                .equals()
                .constantValueOf("05500")
                .build()

        when:
        Map ruleAsMap = rule.asMap()

        then:
        ruleAsMap == ComplexRuleWithThreeTermsInAnOrConector.rule
    }

    void "test rule should reflect this: [ (this.inputValue == \"03200\" || this.inputValue == \"91820\" || this.inputValue == \"05500\") && this.inputValue != \"00000\" ]"() {
        setup:
        Rule rule = new RuleBuilder()
                .valueOfInput("this")
                .equals()
                .constantValueOf("03200")
                .or()
                .valueOfInput("this")
                .equals()
                .constantValueOf("91820")
                .or()
                .valueOfInput("this")
                .equals()
                .constantValueOf("05500")
                .and()
                .valueOfInput("this")
                .notEquals()
                .constantValueOf("00000")
                .build()

        when:
        Map ruleAsMap = rule.asMap()

        then:
        ruleAsMap == ComplexRuleWithThreeTermsInAnOrConectorInsideAnAndConnector.rule
    }

    void "test rule should reflect this: [ (this.inputValue == \"03200\" && this.inputValue == \"91820\" && this.inputValue == \"05500\") || this.inputValue != \"06600\" ]"() {
        setup:
        Rule rule = new RuleBuilder()
                .valueOfInput("this")
                .notEquals()
                .constantValueOf("03200")
                .and()
                .valueOfInput("this")
                .notEquals()
                .constantValueOf("91820")
                .and()
                .valueOfInput("this")
                .notEquals()
                .constantValueOf("05500")
                .or()
                .valueOfInput("this")
                .equals()
                .constantValueOf("06600")
                .build()

        when:
        Map ruleAsMap = rule.asMap()

        then:
        ruleAsMap == ComplexRuleWithThreeTermsInAnAndConectorInsideAnOrConnector.rule
    }

}
