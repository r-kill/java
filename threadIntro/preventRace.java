/*
 * Author: Rowan Kill
 * Class: CSCI 310 - Fall 2018
 * Assignment: Homework 3 - problem 6.39 in the textbook
 * Date: 10/22/2018
 */
package homework3;

import java.util.Random;

// prevent a race condition from occurring when multiple
//    threads are active simultaneously
public class Homework3
{
    public static void main(String[] args)
    {
        // random value used to determine resources needed by a process
        Random randValue = new Random();
        
        // resource manager object
        Manager resourceMgr = new Manager();
        
        // create processes that use random number of resources
        //    can request between 1 and 5 resources inclusively
        Process p1 = new Process(1, 1 + randValue.nextInt(5), resourceMgr); 
        Process p2 = new Process(2, 1 + randValue.nextInt(5), resourceMgr); 
        Process p3 = new Process(3, 1 + randValue.nextInt(5), resourceMgr); 
        Process p4 = new Process(4, 1 + randValue.nextInt(5), resourceMgr);
        
        // inform user that threads are being started
        System.out.println("All processes are loading...");
        System.out.println("[ACTION] |   PID   |       Results      " + 
                           " |     Manager Info");
        System.out.println("=============================================" + 
                           "========================");
        
        // start threads
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        
        // wait for threads to complete
        try
        {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
        }
        catch (Exception e)
        {
            // inform user of exception while waiting for threads
            System.out.println("Error while threads were running.\n\n" + e);
        } // end try catch
    } // end main()
} // end class Homework3

// resource manager class
class Manager
{
    public static final int MAX_RESOURCES = 5;
    private int availableResources = MAX_RESOURCES;
    
    // allows Process objects to see how many resources are available
    public int utilization = availableResources;

    // decrease availableResources by count
    // return 0 if sufficient resources available
    //    otherwise return -1
    public synchronized int decreaseCount(int count, Process p)
    {
        // check if resources are available before and after waiting
        while(availableResources < count)
        {
            // block thread if resources not available
            try
            {
                // if thread must wait, inform user
                System.out.println("[BLOCKED] Process " + p.pid + " blocked, " +
                           count + " requested, " + availableResources +
                           " available resources.");
                
                wait();
                
                // inform user when the thread in running again
                System.out.println("[UNBLOCK] Process " + p.pid + " requests " +
                           count + " resources, " + availableResources +
                           " available after wait.");
            }
            catch(Exception e)
            {
                // inform user of error
                System.out.println("Error blocking thread " +
                                   p.pid + ".\n\n" + e);
            } // end try catch
        } // end while
        
        // decrement availableResources and return 0
        availableResources -= count;

        // update public resources variable
        utilization = availableResources;

        return 0;
    } // end decreaseCount()

    // increase availableResources by count
    // notify other threads that the current thread has finished
    public synchronized void increaseCount(int count)
    {
        availableResources += count;
        notify();
                
        // update public resources variable
        utilization = availableResources;
    } // end increaseCount()
} // end class Manager

// class for a process - a thread that requests resources from an
//    object of the Manager class
class Process extends Thread
{
    // int to hold the number of resources requested
    private int resources;

    // int to hold process identifier - public for cleaner output
    public int pid;

    // resource manager object - instance provided by main()
    private Manager mgr;

    // constructor for Process object - requests resources
    //    from Manager class
    public Process(int proc_id, int resourceRequest, Manager resMgr)
    {
        resources = resourceRequest;
        pid = proc_id;
        mgr = resMgr;
    } // end constructor

    // run method for thread to execute
    public void run()
    {
        // print the number of resources requested by current process
        System.out.println("[REQUEST] Process " + pid + " requests " +
                           resources + " resources, " + mgr.utilization +
                           " available resources.");
        
        // attempt to get resources by the current process 
        //    equivalent to decrementing availableResources
        mgr.decreaseCount(resources, this);
            
        // process is allocated resources and runs
        System.out.println("[ACQUIRE] Process " + pid + " assigned " +
                           resources + " resources, " + mgr.utilization +
                           " resources remain.");

        // release resources when done
        mgr.increaseCount(resources);
        
        // output the fact that resources were released
        System.out.println("[RELEASE] Process " + pid + " releases " +
                           resources + " resources, " +
                           mgr.utilization + " resources available.");
    } // end run()
} // end class Process
