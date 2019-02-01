/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
import java.util.Scanner;

public class Max {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 3 doubles separated by spaces: ");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();

        double result = max(num1, num2, num3);

        System.out.println("Maximum is: " + result);
    }//end Main

    public static double max(double x, double y, double z) {
        //assume x is the largest at first
        double maxVal = x;

        if (y > maxVal) {
            maxVal = y;
        }

        if (z > maxVal) {
            maxVal = z;
        }

        return maxVal;
    }//end Max
}//end Class
