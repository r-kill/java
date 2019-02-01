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

public class PassFail {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int pass = 0;
        int fail = 0;
        int counter = 1;
        int result;

        while (counter <= 10) {
            System.out.print("Enter result (1 = pass, 2 = fail): ");
            result = input.nextInt();

            if (result == 1) {
                pass += 1;
            }//end If
            else {
                fail += 1;
            }//end Else

            counter++;
        }//end while

        if (counter != 0) {
            System.out.printf("Passes: %d\nFails: %d\n", pass, fail);
        }///end If

        if (pass > 8) {
            System.out.println("Bonus for prof.");
        }//end If
    }//end Main
}//end ClassAvg2
