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
import java.io.*;

public class Part2 {

    public static void main(String[] args) {
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n", "User info:",
                "This program is a very basic calculator that adds and subtracts.",
                "You will enter the two numbers you want to use and the operator",
                "that will operate on those numbers.",
                "The operator will be either plus (+) or minus (-).",
                "Enter an '=' without the quotes to end the program.");

        float total = 0;
        boolean flag = true;
        char operator = '.'; //this variable needs to be initialized
        boolean repeatMe = true; //this flag is used to limit how many times code can run

        Scanner input = new Scanner(System.in);

        while (flag == true) {
            if (repeatMe) {
                System.out.print("\nEnter an operand (number): ");
                total += input.nextFloat();
                repeatMe = false;
            }//end first run only statements

            System.out.print("\nEnter an operator (+ or -): ");

            //system.in.read() seems to require a try/catch by default
            try {
                operator = (char) System.in.read();
            } catch (IOException ex) {
                //System.out.println("Error: " + ex);
                //System.out.println("Operator = " + operator);
            }//end try/catch for read()

            if ((operator != '+') && (operator != '-')) {
                System.out.printf("%s\n%s\n", "Operator must be + or -",
                        "Starting over...");
                total = 0;
                continue;
            }//end input validate

            System.out.print("\nEnter another operand (number): ");
            float numStorage1 = input.nextFloat();

            //if user entered +, add to total
            //else user HAD to enter -, so subtract from total
            if (operator == '+') {
                total += numStorage1;
            } else {
                total -= numStorage1;
            }//end if/else to add/sub from total

            System.out.print("\nEnter another operator to continue, "
                    + "or enter an = to get the results: ");

            //system.in.read() seems to require a try/catch by default
            try {
                operator = (char) System.in.read();
            } catch (IOException ex) {
                //System.out.println("Error: " + ex);
                //System.out.println("Operator = " + operator);
            }//end try/catch for read()

            //check if user wants to continue or get total and validate
            if (operator == '=') {
                System.out.printf("%s%.2f\n",
                        "\nThe total of the numbers entered is ", total);
                flag = false;
            } else if (operator == '+') {
                System.out.print("\nEnter another operand (number): ");
                total += input.nextFloat();
            } else if (operator == '-') {
                System.out.print("\nEnter another operand (number): ");
                total -= input.nextFloat();
            } else {
                System.out.printf("%s\n%s\n%s\n", "Operator must be + or -",
                        "Starting over...", "Total = 0");
                total = 0;
            }//end If/else if
        }//end While
    }//end Main
}//end Class
