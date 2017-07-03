package rules.fixture

/**
 * Created by dmachado on 7/2/17.
 */
class ComplexRuleWithThreeTermsInAnOrConectorInsideAnAndConnector {

    public static final Map rule = [
        type: "and",
        expressions: [[
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
            ], [
                type: "eq",
                expressions:[[
                    type: "input_value",
                    value: "this"
                ], [
                    type: "constant",
                    value: "05500"
                ]]
            ]]
        ], [
            type: "neq",
            expressions:[[
                type: "input_value",
                value: "this"
            ], [
                type: "constant",
                value: "00000"
            ]]
        ]]
    ]

}
