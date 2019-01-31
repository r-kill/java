/*
 * Author: Rowan Kill
 * Class: CSCI 310 - Fall 2018
 * Homework 2 - driver for Triangle class
 * Due: 10/3/2018
 */

// This program tests the methods from the Triangle class.
// It creates a Triangle object using the methods inherited
//    from Shape.java along with user input for the length
//    of one side of the triangle.
package homework2_e;

import java.util.Scanner;

public class Homework2_E
{
    // main - creates a Triangle object and initializes it with a side length.
    //    The methods in the Triangle class are invoked through the object.
    public static void main(String[] args)
    {
        // stores user input
        double userInput;
        
        // reads user input
        Scanner read = new Scanner(System.in);
        
        // allows user to continue using program for multiple inputs
        String newGame;
        
        // temp value used to verify proper input values
        String temp;
        
        // flag value is based on newGame value
        //    true if newGame == "y"
        //    false if newGame != "y"
        boolean flag = true;
        
        // loop so user can use the program more than once per execution
        while(flag)
        {
            // get user input for side length, ensure it's a double
            System.out.print("Enter the length of one side of the triangle: ");
            temp = read.nextLine();
        
            // ensure input value is numeric
            while(!isNumeric(temp))
            {
                // ask the user to input new values until the value is numeric
                System.out.println("\nThe side length of the triangle must "+
                                   "be numeric.");
                System.out.print("Enter the length of one side of the "+
                                 "triangle: ");
                temp = read.nextLine();
            } // end nested while

            // assign numeric value to userInput
            userInput = Double.parseDouble(temp);

            // create triangle object with the specified side length
            Triangle tri = new Triangle(userInput);

            // print output of methods
            System.out.println("\nThe area of the triangle is: " + tri.area());
            System.out.println(tri.circumference());
            
            // ask user if they want to input new values
            System.out.print("\nTry again (y or n)?: ");
            newGame = read.nextLine().toLowerCase();
            
            // determine value of the flag based on input value
            if(!newGame.equals("y"))
                flag = false;
        } // end outer while
        
        // close reader
        read.close();
    } // end main
    
    // function to determine whether the argument is a double value
    // returns true if the argument can be parsed as a double
    private static boolean isNumeric(String str)
    {
        // try to parse the argument as a double
        try
        {
            // cast string input into a double value
            Double.parseDouble(str);
        }
        catch (Exception e)
        {
            return false;
        } // end try catch
        
        // return true if the value can be parsed as a double
        // this statement will only be reached if the program 
        //    doesn't enter the catch clause
        return true;
    } // end isNumeric()
} // end class
