package rules.constants

/**
 * Created by dmachado on 7/1/17.
 */
enum ConnectorType {
    OR('or'),
    AND('and')

    String name

    ConnectorType(String name){
        this.name = name
    }

    String getName(){
        return name
    }

}
