/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class MethodOverload {

    public static void main(String[] args) {
        System.out.printf("Square of int 7 is %d\n", square(7));
        System.out.printf("Square of dbl 7.5 is %f\n", square(7.5));
    }//end Main

    public static int square(int intVal) {
        System.out.printf("\nCalled square with int argument: %d\n", intVal);
        return intVal * intVal;
    }//end Method

    public static double square(double dblVal) {
        System.out.printf("\nCalled square with dbl argument: %f\n", dblVal);
        return dblVal * dblVal;
    }//end Method
}//end Class
