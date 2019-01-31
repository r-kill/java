/*
 * Author: Rowan Kill
 * Class: CSCI 310 - Fall 2018
 * Homework 2 - Shape class
 * Due: 10/3/2018
 */

// This program designs the Shape interface that 
//    will be used by subclasses.
package homework2_e;

// Shape interface
public interface Shape
{
    // define methods for the area and circumference 
    //    of a shape.
    public double area();
    public double circumference();

    // Define PI as a constant double value
    public static final double PI = 3.14159;
} // end Shape interface
