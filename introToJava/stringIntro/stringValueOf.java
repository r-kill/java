/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class StringValueOf {

    public static void main(String[] args) {
        char[] chrArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        boolean boolVal = true;
        char charVal = 'Z';
        int intVal = 7;
        long longVal = 10000000000L;
        float floatVal = 2.5f;
        double dblVal = 33.333;
        Object objRef = "hello";

        System.out.printf("char array = %s\n", String.valueOf(chrArray));
        System.out.printf("part of char array = %s\n", String.valueOf(chrArray, 3, 3));
        System.out.printf("boolean = %s\n", String.valueOf(boolVal));
        System.out.printf("char = %s\n", String.valueOf(charVal));
        System.out.printf("int = %s\n", String.valueOf(intVal));
        System.out.printf("long = %s\n", String.valueOf(longVal));
        System.out.printf("float = %s\n", String.valueOf(floatVal));
        System.out.printf("double = %s\n", String.valueOf(dblVal));
        System.out.printf("Object = %s\n", String.valueOf(objRef));
    }//end Main
}//end Class
