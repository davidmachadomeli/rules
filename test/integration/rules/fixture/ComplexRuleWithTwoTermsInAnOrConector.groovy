package rules.fixture

/**
 * Created by dmachado on 7/2/17.
 */
class ComplexRuleWithTwoTermsInAnOrConector {

    public static final Map rule = [
        type: "or",
        expressions: [[
            type: "eq",
            expressions:[[
                type: "input_value",
                value: "this"
            ], [
                type: "constant",
                value: "03200"
            ]]
        ], [
            type: "eq",
            expressions:[[
                type: "input_value",
                value: "this"
            ], [
                type: "constant",
                value: "91820"
            ]]
        ]]
    ]

}
