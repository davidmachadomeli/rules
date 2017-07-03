package rules.fixture

/**
 * Created by dmachado on 7/2/17.
 */
class SimpleEqualRule {

    public static final Map rule = [
        "type": "eq",
        "expressions": [[
            "type": "input_value",
            "value": "this"
        ], [
            "type": "constant",
            "value": "03200"
        ]]
    ]

}
