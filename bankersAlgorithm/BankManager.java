/*
 * Banker's Algorithm - Group Assignment
 * Team 2 - Rowan Kill, Kevin Clark, Zach Harper
 * 12/3/2018
 * CSCI 310 - Fall 2018
 */

public class BankManager {
    
    private int max = 10;               // max amount of customers/resources
    private int min = 1;                // min amount of customers/resources
    
    private int numberOfCustomers;      //number of customers
    private int numberOfResources;      //number of resources
    
    private int[] available;            //available amount of each resource
    private int[][] maximum;            //maximum demand of each customer
    private int[][] allocation;         //amnt currently allocated to each cust
    private int[][] need;               //remaining need of each customer
    
    // flag used to determine when a safe state exists
    boolean safestate = false;
    
    // constructor
    public BankManager(int m, int n) {
        // assign input values
        numberOfResources = m;
        numberOfCustomers = n;
        
        //initialize matrices
        available = new int[m];            
        maximum = new int[n][m];        
        allocation = new int[n][m];     
        need = new int[n][m];           
    } // end constructor

    //generate random number of resources per column in available[] matrix
    public void createAvailable() {
        for(int i = 0; i < numberOfResources; i++)
            available[i] = min+(int)(Math.random()*((max-min)+1)); 
    } // end createAvailable
    
    //show bank resources available matrix
    public void showAvailable() {
        // prepare for values
        System.out.println("Bank - Resources Available: ");
        System.out.print("\t[ ");   // print brackets around values
        
        // print values in the matrix
        for(int i = 0; i < numberOfResources; i++){
            // put commas between values appropriately
            if(i == numberOfResources - 1)
                System.out.print(available[i] + " ");
            else
                System.out.print(available[i] + ", ");
        } // end for
        
        // finalize output
        System.out.println("]\n");   // print brackets around values
    } // end showAvailable()

    // generates random values for matrix of customer's maximum 
    //    demands per resource types
    public void maximumCustomerDemand() {
        // generate each row
        for (int i = 0; i < numberOfCustomers; i++) {
            // generate each column in each row
            for (int j = 0; j < numberOfResources; j++) {
                // randomize the values in each column of each row
                maximum[i][j] = (int)(Math.random()*(available[j]+1)); 
            } // end nested for
        } // end outer for
    } // end maximumCustomerDemand()
    
    //display maximum bank demand matrix of each customer per resource type
    public void showMaximumDemand() {
        // prepare for values to be printed
        System.out.println("Bank - Maximum Demand:");
        
        // print the values in the rows of the matrix
        for (int i = 0; i < numberOfCustomers; i++) {  
            System.out.print("\t[ ");   // print brackets around values
            
            // print the values in each column of each row of the matrix
            for (int j = 0; j < numberOfResources; j++) {
                // put commas between values appropriately
                if(j == numberOfResources - 1)
                    System.out.print(maximum[i][j] + " ");
                else
                    System.out.print(maximum[i][j] + ", ");
            } // end nested for
            
            // finalize row output
            System.out.println("]");
        } // end outer for
        
        // whitespace
        System.out.println();
    } // end showMaximumDemand()
    
    // Assigns matrix of individual customer maximum demand 
    //    for each resource type
    public int[] getCustomerMaxDemand(int custNumber) {
        // initialize maxDemand array
        int[] maxDemand = new int[numberOfResources];
        
        // find the maximum amount of each resource that the 
        //    customer custNumber can request
        for (int i = 0; i < numberOfResources; i++) 
            maxDemand[i] = maximum[custNumber][i];
        
        // return maxDemand[]
        return maxDemand;
    } // end getCustomerMaxDemand
    
    // generates customer need matrix based on maximum 
    //    demand of each customer minus their current allocation
    public void customerNeed() {
        // generate values in each row of need[][]
        for (int i = 0; i < numberOfCustomers; i++) {
            // generate values in each column of each row in need[][]
            for (int j = 0; j < numberOfResources; j++) {
                // calculate each element in need[][]
                need[i][j] = maximum[i][j] - allocation [i][j];
            } // end nested for
        } // end outer for
    } // end customerNeed()
    
    // show the full customer needs matrix at current point in time
    public void showCustomerNeed() {
        // prepare for values
        System.out.println("Customer need matrix:");
        
        // print the values in each row of need[][]
        for (int i = 0; i < numberOfCustomers; i++) {
            System.out.print("\t[ ");   // print brackets around values
            
            // print the values in each column of each row in need[][]
            for (int j = 0; j < numberOfResources; j++) {
                // separate the values with commas appropriately
                if(j == numberOfResources - 1)
                    System.out.print(need[i][j] + " ");
                else
                    System.out.print(need[i][j] + ", ");
            } // end nested for
            
            // finalize output for each row
            System.out.println("]");
        } // end outer for
        
        // whitespace
        System.out.println();
    } // end showCustomerNeed()
    
    // Shows the customer allocation matrix
    public void showAllocationMatrix() {
        // prepare for values
        System.out.println("Bank - Allocation Matrix:");
        
        // print each row of the allocation[][] matrix
        for (int i = 0; i < numberOfCustomers; i++) {  
            System.out.print("\t[ ");   // print brackets around values
            
            // print the values in each column of each row in allocation[][]
            for (int j = 0; j < numberOfResources; j++) {
                // separate the values with commas appropriately
                if(j == numberOfResources - 1)
                    System.out.print(allocation[i][j] + " "); 
                else
                    System.out.print(allocation[i][j] + ", "); 
            } // end nested for
            
            // finalize the output for each row
            System.out.println("]");
        } // end outer for
        
        // whitespace
        System.out.println();
    } // end showAllocationMatrix()
    
    //customer request resources 
    public synchronized boolean requestResources(int custID, int[] custReq, int requestNum) 
    { 
        // used to determine if request can be fulfilled
        boolean safe = false;
        
        // keep requesting same resources until request complete
        while(!safe)
        {
            // if a safe sequence is found, then allocate requested resources
            // update matrecies to reflect the allocation of resources
            if(safeState(custID, custReq, requestNum))
            {
                // acknowledge that resources are being used
                System.out.println("Customer " + custID + " request " 
                                   + requestNum + " granted.");
                
                // show what resources are in use
                showAllocationMatrix();
                
                // set flag to show that resources have been allocated
                safe = true;
            }
            else    // no safe state was found
            {
                // try to wait for the requested resources to be made 
                //    available when another thread releases their 
                //    resources
                try
                {
                    // inform user that customer thread must wait for resources
                    System.out.println("Customer " + custID + 
                                       " must wait for request " + 
                                       requestNum + "!\n");

                    // wait for requested resources until notified by 
                    //    another thread, then repeat request
                    wait();
					
                    // inform user that customer is requesting again
                    System.out.println("Customer " + custID + 
                                       " waited - repeating " +
                                       "request " + requestNum + ".");
                }
                catch (Exception e) {} // end try catch
            } // end if else
        } // end while
        
        // notify other threads to try requesting after getting resources
        notifyAll();
        
        // return true because requests must be fulfilled
        return true;
    } // end requestResources()
    
    //customer release resources
    public synchronized boolean releaseResources(int custID, int[] custRel) {
        // print which customer is releasing their resources and 
        //    what resources they'll be releasing
        System.out.print("Customer " + custID + " releasing resources: [ ");
        
        // print values
        for(int val = 0; val < numberOfResources; ++val)
        {
            // separate the values with commas appropriately
            if(val == numberOfResources - 1)
                System.out.print(custRel[val] + " ");
            else
                System.out.print(custRel[val] + ", ");
        } // end outer for
        
        // finalize output and print some whitespace
        System.out.println("]");
        
        // updates allocation[][] matrix
        for (int i = 0; i < numberOfResources; i++) {
            allocation[custID][i] = allocation[custID][i] - custRel[i];
        } // end for
        
        // notify other threads that resources have been made available
        // use notifyAll() to prevent deadlock
        notifyAll();
        
        // inform user that a customer has finished
        showAllocationMatrix();
        return true;
    } // end releaseResources()
    
    // ensures that a request doesn't produce an unsafe sequence
    // safety algorithm
    public synchronized boolean safeState(int id, int[] request, int requestNum) 
    {
        // boolean array used to determine which processes are finished
        // automatically initializes values to false
        boolean[] finish = new boolean[numberOfCustomers];
        
        // integer array used to store the IDs of customers 
        //    in the safe sequence
        int[] safeSeq = new int[numberOfCustomers];
        
        // work array used in the safety algorithm
        int[] work = new int[numberOfResources];
        
        // flag used to determine when a customer is 
        //    unfinished or in an unsafe state
        boolean inSequence = false;
        
        // show the amount of each resource requested
        // prepare for values to be output
        System.out.print("Customer " + id + " - request " + 
                         requestNum + ": [ ");
        
        // print value of each resource requested
	for (int i = 0; i < numberOfResources; i++) 
        {
            // print the amount of resource i requested by customer id
            // put commas between values appropriately
            if(i == numberOfResources - 1)
                System.out.print(request[i] + " ");
            else
                System.out.print(request[i] + ", ");
        } // end outer for
        
        // finalize output and print whitespace
        System.out.println("]");
        
        // before initializing work[], assume resources were 
        //    allocated to current customer
        // these changes will be reversed if resources cannot 
        //    be allocated
        for (int i = 0; i < numberOfResources; i++) 
        {
            allocation[id][i] += request[i];
            need[id][i] -= request[i];
        } // end for
        
        // initialize work[]
        // work is the sum of the columns in the allocated[][] matrix
        //    minus the maximum # of instances of that resource type
        // in order to accurately calculate the work[] array, 
        //    assume request was allocated
        for(int col = 0; col < numberOfResources; ++col)
        {
            // sums the values in a single column of the matrix for all rows
            int colSum = 0;
            
            // calculate the sum of each column
            for(int row = 0; row < numberOfCustomers; ++row)
            {
                // sum column of allocation[][] matrix
                colSum += allocation[row][col];
            } // end nested for
            
            // initialize work[]
            // want to sum the columns of the allocation[][] matrix
            work[col] = available[col] - colSum;
        } // end outer for
        
        // loop while a process is unfinished or until an unsafe state exists
        int finishedCount = 0;
        while(finishedCount < numberOfCustomers)
        {
            // find an unfinished customer whose needs can be met with work[]
            inSequence = false;
            for(int customerNum = 0; customerNum < numberOfCustomers; 
                ++customerNum)
            {
                // ensure customerNum is unfinished
                if(finish[customerNum] == false)
                {
                    // check if customerNum's needs can be met with work[]
                    // ensures unsafe allocations are caught 
                    //    with second condition
                    // res counts the number of resource types that can  
                    //    meet the needs of customerNum
                    int res;
                    for(res = 0; res < numberOfResources; ++res)
                        if(need[customerNum][res] > work[res] || 
                           work[res] < 0)
                            // if there aren't enough resources 
                            //    for a given need, then break
                            break;
                    
                    // if all of customerNums needs are met, then add 
                    //    allocated resources for that customer to work[]
                    if(res == numberOfResources)
                    {
                        // add allocated resources to work[]
                        for(int i = 0; i < numberOfResources; ++i)
                            work[i] += allocation[customerNum][i];
                        
                        // add this customer to the safe sequence and 
                        //    increment the number of finished processes
                        safeSeq[finishedCount++] = customerNum;
                        
                        // adjust finished array and found flag
                        finish[customerNum] = inSequence = true;
                    } // end nested if
                } // end nested if
            } // end nested for
            
            // if a safe sequence wasn't found
            if(inSequence == false)
            {
                // inform user about unsafe request
                System.out.println("Bank - Safe sequence not found!");
                
                // reverse changes to the allocation[][] and need[][] matrices
                for (int i = 0; i < numberOfResources; i++) 
                {
                    allocation[id][i] -= request[i];
                    need[id][i] += request[i];
                } // end nested for
                
                // return false to make requesting customer wait
                return false;
            } // end nested if
        } // end outer while
        
        // if the program exits the while loop, then a safe sequence was found
        // inform user about safe sequence
        System.out.print("Bank - Safe sequence: [ ");

        // print the sequence
        for(int i = 0; i < numberOfCustomers; ++i)
        {
            // separate the values in the safe sequence with commas
            if(i == numberOfCustomers - 1)
                System.out.print("C" + safeSeq[i] + " ");
            else
                System.out.print("C" + safeSeq[i] + ", ");
        } // end outer for
        
        // finalize output for the safe sequence
        System.out.println("]");

        // return true
        return true;
    } // end safeState
} // end BankManager
