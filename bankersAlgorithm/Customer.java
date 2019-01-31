/*
 * Banker's Algorithm - Group Assignment
 * Team 2 - Rowan Kill, Kevin Clark, Zach Harper
 * 12/3/2018
 * CSCI 310 - Fall 2018
 */

import java.util.stream.*;
import java.util.Random;

public class Customer extends Thread {
        
    private int numberOfResources;  // number of resources (input)
    private int maxSleep = 5000;    // maximum sleep time of each thread in msec
    private int customerID;         // customer id number
    private int requestNum = 0;     // keep track of number of requests made
    
    private BankManager manager;    // BankManager object
    
    private int[] maxDemand;        // maximum that a customer will demand
    private int[] currentNeed;      // customer's current need
    private int[] request;          // resources customer is requesting

    
    // constructor
    public Customer(int custNumber, int numOfRes, BankManager man) {
        customerID = custNumber;
        numberOfResources = numOfRes;
        manager = man;
        
        //initialize matrices
        maxDemand = new int[numOfRes];
        currentNeed = new int[numOfRes]; 
        request = new int[numOfRes];
    } // end constructor
    
    //gets customer's max demand from bankManager
    public void getCustomerMaxDemand() {
        maxDemand = manager.getCustomerMaxDemand(customerID);
    } // end getCustomerMaxDemand()

    // what the customer threads do when they start
    @Override
    public void run() {
        // flag used to request resources until none are needed
        boolean notEnoughRes = true;
        
        // flag will be false if all resources are released
        boolean givingBackRes = true;
        
        //copies max demand matrix of customer currentNeed matrix
        for (int d = 0; d < numberOfResources; d++)
            currentNeed[d] = maxDemand[d];
        
        // calculate the total needs of the current thread
        int sum = IntStream.of(currentNeed).sum();
        
        // make requests until needs are met
        while (notEnoughRes) {
            try {
                // ensure request <= currentNeed
                //if i do plus 1, if max demand is 0, it will request 1 res
                Random randomize = new Random();
                for (int i = 0; i < numberOfResources; i++)
                    // randomize resources requested
                    request[i] = randomize.nextInt(currentNeed[i]+1);
                
                // request resources through Bank manager
                // if true then request granted and resources allocated
                if (manager.requestResources(customerID, request, requestNum))
                {
                    // updates needs of the customer after allocation
                    for (int j = 0; j < numberOfResources; j++) {
                        currentNeed[j] = currentNeed[j] - request[j];
                    } // end nested for
                    
                    // calculate new sum of current need matrix
                    sum = IntStream.of(currentNeed).sum();
                    
                    // increment request counter
                    requestNum++;
                    
                    // hold the resources for 1 - 5 seconds (random)
                    Thread.sleep((int)(Math.random()*(maxSleep)+1));
                } // end nested if
                
                //exits while loop if no more resources needed by customer
                if (sum == 0) 
                    notEnoughRes = false;
            } 
            catch (Exception e) {}
        } // end outer while
        
        //give back all resources held by customer 
        while (givingBackRes) {
            try {
                // use Bank manager to release resources
                if(manager.releaseResources(customerID, maxDemand))
                    // exit the while loop if all resources were released
                    givingBackRes = false;
            }
            catch (Exception e) {}        
        } // end outer while
        
        // signal to main() that this thread is complete
        // an uncaught exception is used by each thread to tell 
        //    main() (in the BankersAlgorithm class) that it has 
        //    finished running
        throw new RuntimeException();
    }//end run()
}//end customer

