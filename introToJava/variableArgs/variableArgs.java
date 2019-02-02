/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class VariableArgumentsList {

    public static double average(double... numbers) {
        double total = 0.0;

        //calculate total of parameters
        for (double d : numbers) {
            total += d;
        }//end For

        return total / numbers.length;
    }//end average

    public static void main(String[] args) {
        double d1 = 10.0;
        double d2 = 20.0;
        double d3 = 30.0;
        double d4 = 40.0;
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);
        System.out.println("d4 = " + d4 + "\n");

        System.out.printf("Avg of d1 and d2 is %.1f\n", average(d1, d2));
        System.out.printf("Avg of d1, d2 and d3 is %.1f\n", average(d1, d2, d3));
        System.out.printf("Avg of d1, d2, d3 and d4 is %.1f\n", average(d1, d2, d3, d4));
    }//end Main
}//end Class
