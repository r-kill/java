/*
 * Rowan Kill
 * Homework 5
 * 11/26/2018
 * CSCI 310 - Fall 2018
 */
package homework5;

// abstract class that's extended for different replacement algorithms
public abstract class ReplacementAlgorithm
{
    // number of page faults
    protected int faultCount;
    
    // number of page frames
    protected int numFrames;
    
    // constructor
    public ReplacementAlgorithm(int numFrames)
    {
        // throw an error if number of frames is negative
        if(numFrames < 0)
            throw new IllegalArgumentException();
        
        // set number of frames
        this.numFrames = numFrames;
        
        // initialize faultCount to 0
        faultCount = 0;
    } // end ReplacementAlgorithm()
    
    // return the number of page faults that occurred
    public int getFaultCount()
    {
        return faultCount;
    } // end getFaultCount()
    
    // the pageNumber will be inserted
    public abstract void insert(int pageNumber);
} // end class ReplacementAlgorithm

