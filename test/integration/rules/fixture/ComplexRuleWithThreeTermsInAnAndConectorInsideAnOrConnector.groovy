package rules.fixture

/**
 * Created by dmachado on 7/2/17.
 */
class ComplexRuleWithThreeTermsInAnAndConectorInsideAnOrConnector {

    public static final Map rule = [
        type: "or",
        expressions: [[
            type: "and",
            expressions: [[
                type: "neq",
                expressions:[[
                    type: "input_value",
                    value: "this"
                ], [
                    type: "constant",
                    value: "03200"
                ]]
            ], [
                type: "neq",
                expressions:[[
                    type: "input_value",
                    value: "this"
                ], [
                    type: "constant",
                    value: "91820"
                ]]
            ], [
                type: "neq",
                expressions:[[
                    type: "input_value",
                    value: "this"
                ], [
                    type: "constant",
                    value: "05500"
                ]]
            ]]
        ], [
            type: "eq",
            expressions:[[
                type: "input_value",
                value: "this"
            ], [
                type: "constant",
                value: "06600"
            ]]
        ]
    ]]

}
