/*
 * Banker's Algorithm - Group Assignment
 * Team 2 - Rowan Kill, Kevin Clark, Zach Harper
 * 12/3/2018
 * CSCI 310 - Fall 2018
 */

import java.util.Scanner;

public class BankersAlgorithm {
    // used to count the number of threads that have finished
    public static int finishedCounter = 0;

    // main()
    public static void main(String[] args) {
        int resources = 0;      //length of bank resources specified by user
        int customers = 0;      //number of customers specified by user
        
        BankManager manager;    // Bank object - "producer"
        Customer customer;      // Customer object - threads/"consumers"
        
        // get user input
        resources = getInput(args, resources, 0);
        customers = getInput(args, customers, 1);
        
        // initialize Bank object, then create and show available 
        //    resources matrix for that Bank object
        manager = new BankManager(resources, customers);
        manager.createAvailable();      // create matrix of available resources
        System.out.print("[INITIAL] "); // clarify output
        manager.showAvailable();        // show matrix of available resources
        
        //creates and shows maximum customer demand matrix
        manager.maximumCustomerDemand();
        manager.showMaximumDemand();
        
        //creates and shows customer need matrix
        manager.customerNeed();
        manager.showCustomerNeed();
        
        // create customer threads and start them
        // initialize customers with their max allowed demands from the Bank
        for (int i = 0; i < customers; i++)
        {
            customer = new Customer(i, resources, manager);
            customer.getCustomerMaxDemand();
            customer.start();
            
            // set the uncaught exception handler for each thread
            // threads use uncaught exceptions to tell this class that 
            //    the thread has finished, allowing this class to track 
            //    which threads are done
            customer.setUncaughtExceptionHandler(
                    new Thread.UncaughtExceptionHandler() 
            {
                // when an uncaught exception is thrown, 
                //    increment the number of threads finished
                public void uncaughtException(Thread t, Throwable e)
                {
                    // increment finished threads
                    ++finishedCounter;
                } // end uncaughtException()
            });
        } // end for
        
        // wait for all of the threads to finish
        // using join() wasn't an option in this case - it causes 
        //    threads to execute sequentially, so there's no 
        //    competition for resources (thread 0 runs and completes, 
        //    then thread 1 run and completes, then thread 2 runs and
        //    completes...)
        while(finishedCounter < customers)
            // make main() sleep for 5 seconds
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e) {}
        
        // print final available[] and allocation[][] if all threads are done
        if(finishedCounter == customers)
        {
            System.out.print("[FINAL] ");   // clarify output
            manager.showAvailable();        // show available resources matrix
            System.out.print("[FINAL] ");   // clarify output
            manager.showAllocationMatrix(); // show allocated[][] matrix
        } // end if
    } // end main
    
    // gets and parses user input
    static int getInput(String[] args, int input, int index)
    {
        // variables
        boolean validRes = false;    // number of resource types input
        boolean validCust = false;   // number of customers input
        
        // flag used to determine if command-line arguments were provided
        boolean cmdArgs = false;
            
        // if two arguments were provided, try to parse the values
        if(args.length == 2)
        {
            // ensure input is valid by trying to parse it
            try
            {
                // determine which input to parse
                switch(index)
                {
                    case 0:
                        // parse input for number of resource types
                        input = Integer.parseInt(args[0]);

                        // set validRes flag to true
                        validRes = true;
                        
                        break;
                    case 1:
                        // parse input for number of customers
                        input = Integer.parseInt(args[1]);

                        // set validCust flag to true
                        validCust = true;
                        
                        break;
                    default:
                        // inform user that the passed index argument 
                        //    is not recognized
                        System.out.println("An input value should " +
                                           "not exist at that index.");

                        // throw an error to break out of the try catch
                        throw new Error();
                } // end nested switch
                
                // if no errors occurred while parsing input, 
                //    set cmdArgs flag to true
                cmdArgs = true;
            }
            catch(Exception e) {}
        } // end outer if
        
        // if the user provided bad command-line arguments, 
        //    or if the user didn't provide any/enough
        //    command-line arguments (e.g. using NetBeans),
        //    then ask them to input appropriate values from 
        //    the terminal until one is received
        if(cmdArgs == false)
        {
            // if necessary, ask user to input a new value for 
            //    the number of resource types
            if(validRes == false && index == 0)
            {
                System.out.print("Enter the number of resources available " +
                                 "from 1 to 10: ");
                
                // get input and ensure it's valid
                input = checkInput(input);
            } // end nested if
            
            // if necessary, ask user to input a new value for
            //    the number of customers
            if(validCust == false && index == 1)
            {
                System.out.print("Enter the number of customers " +
                                 "from 1 to 10: ");
                
                // get input and ensure it's valid
                input = checkInput(input);
            } // end nested if
        } // end outer if
        
        // input will be appropriate at this point in the program
        // return it
        return input;
    } // end getInput()
        
    // verifies that the passed argument meets the criteria 
    //    needed to operate on the input values
    // if the argument can't be used, a replacement value 
    //    will be obtained from the user
    static int checkInput(int value)
    {
        // variables
        int max = 10;                // max number of resources
        int min = 1;                 // min number or resources
        
        // used to get input from terminal
        Scanner input = new Scanner(System.in);
        
        // ensure input is valid
        do
        {
            try
            {
                // read input from terminal
                value = Integer.parseInt(input.next());
            }
            catch(Exception e)
            {
                // if an error occurs when parsing the input, 
                //    set the value to -1 so it's caught by the 
                //    following if statement
                value = -1;
            } // end nested try catch

            // ensure input is within defined range
            if (value < min || value > max)
            {
                // error message
                System.out.println("ERROR: Please enter an integer " +
                               "from 1 to 10 (inclusive).\n");
                
                // ask for new input
                System.out.print("Enter a new value: ");
            } // end nested if
        } while (value < min || value > max); 
        
        // value will be an acceptable value to use, so return it
        return value;
    } // end checkInput()
} // end BankersAlgorithm
