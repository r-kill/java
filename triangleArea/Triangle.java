/*
 * Author: Rowan Kill
 * Class: CSCI 310 - Fall 2018
 * Homework 2 - Triangle class
 * Due: 10/3/2018
 */

// This program implements an equilateral triangle class 
//    that inherits (extends) the Shape class.
package homework2_e;

// Triangle class - equilateral triangle
public class Triangle implements Shape
{
    // double for side length of triangle, area, and circumference
    private double side = -1.0;
    
    // constructor for triangle object
    // sets private side variable to side length argument
    public Triangle(double s)
    {
        // set side length to argument value
        // cast argument value to double in case an integer is passed
        side = s;
    } // end constructor
    
    // function that calculates the area of the triangle object
    // function header is in Shape interface
    public double area()
    {
        // return the area of the triangle
        // area = .5 * base * height
        //    base = side / 2
        //    height = base * sqrt(3)
        //    multiply area by 2 otherwise the result
        //        is only half of the actual area
        return (.5 * (side / 2) * ((side / 2) * Math.sqrt(3))) * 2;
    } // end function area()
    
    // function that calculate the circumference of the triangle object
    // function header is in Shape interface
    public double circumference()
    {
        System.out.println("\nTriangles don't have a circumference, "+
                           "they have a perimeter.");
        System.out.print("In this case, the perimeter of the triangle = ");
        return side * 3;
    } // end circumference() function
} // end Triangle class
