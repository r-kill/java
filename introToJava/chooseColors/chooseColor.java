/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        System.out.printf("%s\n%s\n%s\n", "User info:",
                "Enter a number between 400.0 and 700.0",
                "that represents a visible spectrum of light.");

        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the number that represents the color you want: ");
        float color = input.nextFloat();

        //determine which color user has input
        if ((color >= 400.0) && (color < 445.0)) {
            System.out.println("The color you entered was Violet.");
        } else if ((color >= 445.0) && (color < 475.0)) {
            System.out.println("The color you entered was Indigo.");
        } else if ((color >= 475.0) && (color < 510.0)) {
            System.out.println("The color you entered was Blue.");
        } else if ((color >= 510.0) && (color < 570.0)) {
            System.out.println("The color you entered was Green.");
        } else if ((color >= 570.0) && (color < 590.0)) {
            System.out.println("The color you entered was Yellow.");
        } else if ((color >= 590.0) && (color < 650.0)) {
            System.out.println("The color you entered was Orange.");
        } else if ((color >= 650.0) && (color <= 700.0)) {
            System.out.println("The color you entered was Red.");
        } else {
            System.out.printf("%s %s\n", "You've entered a color that's not",
                    "part of the visible spectrum.");
        }//end if/else if
    }//end Main
}//end Class
