/*
 * Rowan Kill
 * Homework 5
 * 11/26/2018
 * CSCI 310 - Fall 2018
 */
package homework5;

import java.util.Arrays;
import java.util.Random;

public class Homework5
{
    public static void main(String[] args)
    {
        // reference string - 10,000 numbers
        String reference = "";
        
        // value that represents the number of frames to use 
        //    for the algorithms
        int numFrames = 1;
        
        // holds the characters of the reference string
        int item;
        
        // used to generate random numbers in the
        //    reference string
        Random rand = new Random();
        
        // generate reference string - all values 
        //    between 0 and 9 (inclusive)
        for(int i = 0; i < 10000; ++i)
            reference += rand.nextInt(10);
        
        // test algorithms for each number of page frames
        while(numFrames <= 8)
        {
            // show the number of frames used by the
            //    queues for this iteration
            System.out.println("Number of frames used: " + 
                               numFrames);
            
            // create fifo object for the FIFO algorithm
            fifo fifoTest = new fifo(numFrames, reference);
            
            // create lru object for the LRU algorithm
            lru lruTest = new lru(numFrames, reference);
            
            // insert each number in the reference string into 
            //    the FIFO and LRU queue
            for(int num = 0; num < reference.length(); ++num)
            {
                // get next integer item from reference string
                // reference is a string, and the characters in that string 
                //    are the numbers needed to assign to item
                // need to get the character from the string, then get the 
                //    numeric value of that character
                // for example, char s = "5" => s has numeric value of 5
                item = Character.getNumericValue(reference.charAt(num));

                // provide an identifier for the number to be inserted
                fifoTest.setID(num);
                lruTest.setID(num);

                // insert page number
                fifoTest.insert(item);
                lruTest.insert(item);
            } // end outer for
            
            // print fault count for FIFO
            System.out.println("FIFO faulted " + fifoTest.getFaultCount() + 
                               " times with " + numFrames + 
                               " page frames.");
            
            // print fault count for LRU
            System.out.println("LRU faulted " + lruTest.getFaultCount() + 
                               " times with " + numFrames + 
                               " page frames.\n");
            
            // increment the number of frames
            ++numFrames;
        } // end while
    } // end main()
} // end class Homework5

// class used to implement the FIFO paging algorithm
class fifo extends ReplacementAlgorithm
{
    // reference string
    private String reference;
    
    // integer array that represents the queue in the FIFO algorithm
    // queue[] holds the page reference number that's in the 
    //    reference string
    // queueIDs[] holds the position of the page reference number 
    //    within the reference string
    //    example: if the 4th character in the reference string is "8", 
    //    then an empty queue[] will hold "8" at index 0, and an empty 
    //    queueIDs[] will hold "4" at index 0.
    private int[] queue = new int[numFrames];

    // used to determine which element was first in the queue
    // queue[] holds the page reference number that's in the 
    //    reference string
    // queueIDs[] holds the position of the page reference number 
    //    within the reference string
    //    example: if the 152nd character in the reference string is "2", 
    //    then an empty queue[] will hold "2" at index 0, and an empty 
    //    queueIDs[] will hold "152" at index 0.
    // the index of a value in queueIDs[] matches the index used for 
    //    the corresponding value in queue[]
    private int[] queueIDs = new int[numFrames];

    // this will contain the index of the value in the 
    //    queue that was "first in" (has been in queue 
    //    for the longest amount of time)
    // this variable is related to "small"
    // small holds the smallest value in the queueIDs[] array 
    //    this determines which item has been in the queue the 
    //    longest (therefore the first item in the queue, 
    //    relative to the other items)
    // firstID holds the index of the index of "small" in the 
    //    queueIDs[] array (the smallest value in the queueIDs[] 
    //    array)
    private int firstID = 0;

    // this will contain the ID value of the value in 
    //    the queue that was "first in" (has been in queue 
    //    for the longest amount of time)
    // since the amount of time spent in the queue is 
    //    determined by the ID of the item, the smallest ID 
    //    will have been in the queue for the longest amount 
    //    of time (the IDs of the characters in the reference 
    //    string are the indices of those characters in the 
    //    string, so they start at 0).
    // this variable is related to "firstID"
    // small holds the smallest value in the queueIDs[] array 
    //    this determines which item has been in the queue the 
    //    longest (therefore the first item in the queue, 
    //    relative to the other items)
    // firstID holds the index of the smallest value in the 
    //    queueIDs[] array
    private int small;
    
    // this will contain a unique integer that identifies 
    //    each item (number in the reference string)
    // the ID is the position of the given number in the 
    //    reference string
    private int itemID = -1;

    // flag that's used to determine if a given item is 
    //    currently in the queue
    private boolean present = false;

    // flag used to determine when the queue is full
    private boolean isEmpty = true;

    // flag used to determine when an item was added to the queue
    private boolean itemAdded = false;
    
    // constructor
    public fifo(int numFrames, String ref)
    {
        // set numFrames
        super(numFrames);
        
        // set reference
        reference = ref;
        
        // initialize the queue[] array with -1
        Arrays.fill(queue, -1);
    } // end constructor
    
    // method to set the identifier of the item being inserted
    public void setID(int id)
    {
        // set itemID
        itemID = id;
    } // end setID()
    
    // insert an item into the queue - replace a page if necessary
    public void insert(int item)
    {
        // ensure itemID has been set
        if(itemID == -1)
            throw new Error("Missing an ID for this item, " +
                            "use fifo_object.setID(#)");
        
        // move on to the next item if current item is in queue[]
        for(int index = 0; index < numFrames; ++index)
        {
            // if item is in the queue, set the flag to true so 
            //    the next number in the reference string is checked
            if(queue[index] == item)
            {
                present = true;

                // stop checking queue[] for the current 
                //    item after it's found
                break;
            } // end nested if
        } // end nested for

        // if the current item is in the queue, move on to the next item
        // else a page fault occurs, so replace a page
        if(present == true)
        {
            // reset present flag
            present = false;

            // move on to the next item in the reference string
            return;
        }
        else    // item is not in queue[]
        {
            // count the fault
            ++faultCount;

            // add item to the queue (when queue isn't full)
            if(isEmpty)
            {
                for(int index = 0; index < numFrames; ++index)
                    // if a value in queue is -1, then it can hold a
                    //    page reference from the reference string
                    if(queue[index] == -1)
                    {
                        // add item to queue
                        queue[index] = item;

                        // record the ID of the item
                        queueIDs[index] = itemID;

                        // if queue is full, set isEmpty 
                        //    flag to false
                        if(index == numFrames - 1)
                            isEmpty = false;

                        // set itemAdded flag to show than 
                        //    an item was added
                        itemAdded = true;

                        // break out of loop to prevent repeats
                        break;
                    } // end nested if
            } // end nested if

            // ensure the queue is full before trying to replace pages
            if(itemAdded == false)
            {
                // initialize values for small and first
                small = queueIDs[0];
                firstID = 0;

                // add item to the queue (when queue is full)
                // a page needs to be replaced, so the page with the 
                //    smallest ID in the queueIDs[] array will be the 
                //    "first in" item, so it will be replaced
                for(int id = 0; id < numFrames; ++id)
                {
                    // find smallest ID
                    if(small > queueIDs[id])
                    {
                        // this will be the oldest (first) item in the queue
                        small = queueIDs[id];

                        // assign the index of the smallest value 
                        //    in queueIDs[] to the variable "firstID"
                        firstID = id;
                    } // end nested if
                } // end nested for

                // replace the page that has been in the queue for 
                //    the longest amount of time
                queue[firstID] = item;

                // replace ID of the replaced item in queueIDs[]
                queueIDs[firstID] = itemID;
            } // end nested if

            // reset itemAdded flag before next iteration
            itemAdded = false;
        } // end nested if else
    } // end insert()
} // end class fifo

// class used to implement the LRU paging algorithm
class lru extends ReplacementAlgorithm
{
    // reference string
    private String reference;
    
    // integer array that represents the queue in the LRU algorithm
    // queue[] holds the page reference number that's in the 
    //    reference string
    // queueIDs[] holds the position of the page reference number 
    //    within the reference string
    //    example: if the 4th character in the reference string is "8", 
    //    then an empty queue[] will hold "8" at index 0, and an empty 
    //    queueIDs[] will hold "4" at index 0.
    private int[] queue = new int[numFrames];

    // used to determine which element was first in the queue
    // queue[] holds the page reference number that's in the 
    //    reference string
    // queueIDs[] holds the position of the page reference number 
    //    within the reference string
    //    example: if the 152nd character in the reference string is "2", 
    //    then an empty queue[] will hold "2" at index 0, and an empty 
    //    queueIDs[] will hold "152" at index 0.
    // the index of a value in queueIDs[] matches the index used for 
    //    the corresponding value in queue[]
    private int[] queueIDs = new int[numFrames];

    // this will contain the index of the value in the 
    //    queue that hasn't been used in the longest 
    //    amount of time (the smallest value in the
    //    queueIDs[] array is the value least used)
    // this variable is related to "small"
    // small holds the smallest value in the queueIDs[] array 
    //    this determines which item has not been used in the 
    //    longest period of time
    // firstID holds the index of the index of "small" in the 
    //    queueIDs[] array (the smallest value in the queueIDs[] 
    //    array)
    private int firstID = 0;

    // this will contain the smallest value in the queueIDs array
    // since the amount of time spent in the queue is 
    //    determined by the ID of the item, the smallest ID 
    //    will have been in the queue for the longest amount 
    //    of time (the IDs of the characters in the reference 
    //    string are the indices of those characters in the 
    //    string, so they start at 0).
    // this variable is related to "firstID"
    // small holds the smallest value in the queueIDs[] array 
    //    this determines which item has not been used in the
    //    longest period of time
    // firstID holds the index of the smallest value in the 
    //    queueIDs[] array
    private int small;
    
    // this will contain a unique integer that identifies 
    //    each item (number in the reference string)
    // the ID is the position of the given number in the 
    //    reference string
    // initialized to sentinel value of -1
    private int itemID = -1;

    // flag that's used to determine if a given item is 
    //    currently in the queue
    private boolean present = false;

    // flag used to determine when the queue is full
    private boolean isEmpty = true;

    // flag used to determine when an item was added to the queue
    private boolean itemAdded = false;
    
    // constructor
    public lru(int numFrames, String ref)
    {
        // set numFrames
        super(numFrames);
        
        // set reference
        reference = ref;
        
        // initialize the queue[] array with -1
        Arrays.fill(queue, -1);
    } // end constructor
    
    // method to set the identifier of the item being inserted
    public void setID(int id)
    {
        // set itemID
        itemID = id;
    } // end setID()
    
    // insert an item into the queue[] - replace a page if necessary
    public void insert(int item)
    {
        // ensure itemID has been set
        if(itemID == -1)
            throw new Error("Missing an ID for this item, " +
                            "use lru_object.setID(#)");
        
        // determine if item is in queue[]
        for(int index = 0; index < numFrames; ++index)
        {
            // if item is in the queue[], set the flag to true so 
            //    the next number in the reference string is checked
            // count the new instance of the existing item as a "use"
            if(queue[index] == item)
            {
                present = true;
                
                // count the use of the item
                queueIDs[index] = itemID;

                // no need to continue if item is in queue[]
                break;
            } // end nested if
        } // end nested for

        // if the current item is in the queue[], move on to the next item
        // else a page fault occurs, so replace a page
        if(present == true)
        {
            // reset present flag
            present = false;

            // move on to the next item in the reference string
            return;
        }
        else
        {
            // count the fault
            ++faultCount;

            // add item to the queue[] (when queue[] isn't full)
            if(isEmpty)
            {
                for(int index = 0; index < numFrames; ++index)
                    // if a value in queue[] is -1, then it can hold a
                    //    page reference from the reference string
                    if(queue[index] == -1)
                    {
                        // add item to queue[]
                        queue[index] = item;

                        // record the ID of that item
                        queueIDs[index] = itemID;

                        // check if queue[] is full
                        if(index == numFrames - 1)
                            // set isEmpty flag if the queue is full
                            isEmpty = false;

                        // set itemAdded flag to show than an 
                        //    item was added
                        itemAdded = true;

                        // break out of loop to prevent repeats
                        break;
                    } // end nested if
            } // end nested if

            // ensure the queue[] is full before trying to replace pages
            if(itemAdded == false)
            {
                // initialize values of small and firstID
                small = queueIDs[0];
                firstID = 0;

                // add item to the queue[] (when queue[] is full)
                // a page needs to be replaced, so the page with the 
                //    smallest ID in the queueIDs[] array will be the 
                //    least used item, so it will be replaced
                for(int id = 0; id < numFrames; ++id)
                {
                    // find smallest ID
                    if(small > queueIDs[id])
                    {
                        // this will be the item that hasn't 
                        //    been used in the longest period 
                        //    of time
                        small = queueIDs[id];

                        // assign the index of the smallest value to 
                        //    the variable "firstID"
                        // this will be used as the index for queue[] and 
                        //    queueIDs[] to reflect the replaced page
                        firstID = id;
                    } // end nested if
                } // end nested for

                // replace the page that has been in the queue[] for 
                //    the longest amount of time
                queue[firstID] = item;

                // replace ID of the replaced item in queueIDs[]
                queueIDs[firstID] = itemID;
            } // end nested if

            // reset itemAdded flag before next iteration
            itemAdded = false;
        } // end nested if else
    } // end insert()
} // end class lru
