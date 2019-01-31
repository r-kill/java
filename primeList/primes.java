/*
 * Author: Rowan Kill
 * Class: CSCI 310 - Fall 2018
 * Homework 2 - driver for Triangle class
 * Due: 10/3/2018
 */

// This program asks the user to input a number, then the 
//    program will output all prime numbers less than or equal 
//    to the input value. The output is handled by a separate thread.
package homework2_416;

import java.util.Scanner;

// this class implements Runnable and overwrites the run() method 
//    to specify what the custom thread (called in main()) will do
class Primes implements Runnable
{
    // find all primes less than or eqaul to this value
    private int max;
    
    // constructor
    public Primes(int value)
    {
        // assign value to local variable
        max = value;
    } // end constructor for Primes
    
    // overwrite run() method inhereted from Runnable
    // finds all prime values less than or equal to max
    public void run()
    {
        // array to hold all primes
        String[] primeNums;
        
        // String to hold all primes - will be converted into an array
        String temp = "";
        
        // flag used to determine if a value is prime
        boolean isPrime = true;
        
        // find all primes less than or equal to max
        for(int i = 2; i <= max; ++i)
        {
            // 2 is a special prime so it needs special consideration
            // this is why iterators in this for loop and the one
            //    nested within are initialized to 2
            if(i == 2)
            {
                // append 2 to the String containing prime numbers
                temp += i + ".";
                
                // move on to the next i value
                continue;
            } // end nested if
            
            // find out if i is prime
            // loop is only entered if i > 2
            // only loop up to sqrt(i) because primes have two
            //    factrors that, when multiplied together, equal
            //    i. Those values must be less than or equal to
            //    the square root of i, otherwise the product
            //    would be greater than i.
            for(int j = 2; j <= Math.sqrt(i); ++j)
            {
                // if any number less than i divides evenly into i,
                //    then i is not prime
                if(i % j == 0)
                {
                    // set the flag so the value of i is not considered
                    // break out of the loop to start next i value
                    isPrime = false;
                    break;
                } // end nested if
            } // end nested for
            
            // if the value was determined prime by the nested loop,
            //    then append it to the String that contains the prime
            //    numbers.
            if(isPrime)
                // append prime number
                temp += i + ".";
            
            // reset value for next value of i
            isPrime = true;
        } // end outer for
        
        // separate the prime numbers in an array so they're
        //    easier to output
        // split the String at each period - use regex to
        //    specify what character causes a split
        primeNums = temp.split("\\.");
        
        // output the prime numbers
        if(primeNums[0] == "")
            // if the user inputs a value less than 2, tell them that
            //    there are no prime numbers less than that value.
            System.out.println("There are no prime numbers that are "+
                               "less than or equal to the value " + max +
                               ".");
        else
        {
            System.out.print("The prime numbers are: ");
            for(int i = 0; i < primeNums.length; ++i)
            {
                // make sure last digit isn't followed by a comma
                if(i == primeNums.length - 1)
                    System.out.print(primeNums[i] + "\n");
                else
                    System.out.print(primeNums[i] + ", ");
            } // end for
        }
    } // end run()
} // end class Primes

public class Homework2_416
{
    // main function
    public static void main(String[] args)
    {
        // get user input - value of ceiling
        int userInput;   // stores user input
        
        // reads user input from console
        Scanner read = new Scanner(System.in);
        
        // temp value used to verify proper input values
        String temp;
        
        // flag value allows user to input multiple values
        boolean flag = true;
        
        // user info
        System.out.println("This program finds all prime numbers "+
                           "less than or equal to the value you enter.");
        
        // get user input outside of loop first
        System.out.print("Enter the maximum value: ");
        temp = read.nextLine();
        
        // loop allows user to input multiple values
        while(flag)
        {
            // ensure input value is numeric
            while(!isNumeric(temp))
            {
                // ask the user to input new values until the value
                //    is numeric
                System.out.println("\nThe value must be numeric.");
                System.out.print("Enter a value: ");
                temp = read.nextLine();
            } // end nested while
            
            // assign numeric value to userInput
            userInput = Integer.parseInt(temp);
            
            // create output thread
            Thread output = new Thread(new Primes(userInput));
            
            // start thread
            output.start();
            
            // wait for thread to execute
            try
            {
                // join the thread
                output.join();
            }
            catch(Exception e)
            {
                // inform the user that there was an issue with
                //    the thread
                System.out.println("Something went wrong during "+
                                   "calculation...\n" + e);
            } // end try-catch
            
            // get user input again within loop to continue
            //    execution
            System.out.print("\nEnter a new value or -1 to exit: ");
            temp = read.nextLine();
            
            // ensure user didn't input sentinel value
            //    must use equals() method because relational 
            //    operators only compare references to objects, 
            //    not the value of the objects
            if(temp.equals("-1") == false)
                flag = isNumeric(temp);
            else
                break;
        } // end outer while
        
        // close reader
        read.close();
    } // end main
    
    // function to determine whether the argument is an
    //    integer value
    // returns true if the argument can be parsed as an integer
    private static boolean isNumeric(String str)
    {
        // try to parse the argument as an int
        try
        {
            // cast string input into an int value
            Integer.parseInt(str);
        }
        catch (Exception e)
        {
            // if parsing failed, the value is not an integer
            //    so return false
            return false;
        } // end try catch
        
        // return true if the value can be parsed as an int
        // this statement will only be reached if the program 
        //    doesn't enter the catch clause
        return true;
    } // end isNumeric()
} // end class Homework2_416
