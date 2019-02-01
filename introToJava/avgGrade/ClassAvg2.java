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

public class ClassAvg2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        int counter = 0;
        int grade;
        double avg;

        System.out.print("Enter grade or -1 to exit program: ");
        grade = input.nextInt();

        while (grade != -1) {
            total += grade;
            counter++;

            System.out.print("Enter grade or -1 to exit program: ");
            grade = input.nextInt();
        }//end while

        if (counter != 0) {
            avg = (double) total / counter;

            System.out.printf("\nTotal of all %d grades entered is %d\n", counter, total);
            System.out.printf("Class average is %.2f\n", avg);
        }///end If
        else {
            System.out.println("No grades were entered.");
        }//end Else
    }//end Main
}//end ClassAvg2

