package rules.constants

/**
 * Created by dmachado on 7/1/17.
 */
enum OperatorType {
    EQUALS('eq'),
    NOT_EQUALS('neq')

    String name

    OperatorType(String name){
        this.name = name
    }

    String getName(){
        return name
    }

}
