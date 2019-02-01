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

public class avgGrade {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        int counter = 1;
        int grade;
        int avg;

        while (counter <= 10) {
            System.out.print("Enter grade: ");
            grade = input.nextInt();
            total += grade;
            counter++;
        }//end while

        avg = total / 10;

        System.out.printf("\nTotal of all 10 grades is %d\n", total);
        System.out.printf("Class average is %d\n", avg);
    }//end Main
}//end avgGrade
