package rules.constants

/**
 * Created by dmachado on 7/1/17.
 */
enum OperandType {
    INPUT_VALUE('input_value'),
    INPUT_READONLY('input_readonly'),
    CONSTANT('constant')

    String name

    OperandType(String name){
        this.name = name
    }

    String getName(){
        return name
    }

}
