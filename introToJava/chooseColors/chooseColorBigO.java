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

public class Part1EX {

    public static void main(String[] args) {
        System.out.printf("%s\n%s\n%s\n", "User info:",
                "Enter a number between 400.0 and 700.0",
                "that represents a visible spectrum of light.");

        int bigO = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the number that represents the color you want: ");
        float color = input.nextFloat();

        //determine which color user has input
        ++bigO;
        if (color < 570) {
            ++bigO;
            if (color < 475) {
                ++bigO;
                if (color < 445) {
                    System.out.println("The color you entered is Violet");
                    System.out.println("The number of evaluations was " + bigO);
                } else {
                    System.out.println("The color you entered is Indigo");
                    System.out.println("The number of evaluations was " + bigO);
                }
            } else {
                ++bigO;
                if (color < 510) {
                    System.out.println("The color you entered is Blue");
                    System.out.println("The number of evaluations was " + bigO);
                } else {
                    System.out.println("The color you entered is Green");
                    System.out.println("The number of evaluations was " + bigO);
                }
            }
        } else {
            ++bigO;
            if (color < 650) {
                ++bigO;
                if (color < 590) {
                    System.out.println("The color you entered is Yellow");
                    System.out.println("The number of evaluations was " + bigO);
                } else {
                    System.out.println("The color you entered is Orange");
                    System.out.println("The number of evaluations was " + bigO);
                }
            } else {
                System.out.println("The color you entered is Red");
                System.out.println("The number of evaluations was " + bigO);
            }
        }//end if/else
    }//end Main
}//end Class
