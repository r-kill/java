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
        Scanner input = new Scanner(System.in);
        int pin = 12345;

        //user info
        System.out.println("WELCOME TO THE BANK OF CLOUD.");
        System.out.print("ENTER YOUR PIN: ");
        int userPin = input.nextInt();

        /* END PART 1 QUESTION 1
        //if user gets pin right on first try, allow access
        if (userPin == pin) {
            System.out.println("\nPIN ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT.");
        } else {
            //entered wrong pin, try again
            for (int count = 1; userPin != pin; count++) {
                System.out.println("\nINCORRECT PIN. TRY AGAIN.");
                System.out.print("ENTER YOUR PIN: ");
                userPin = input.nextInt();

                //Count number of tries and let the user know if they entered correct pin
                if (userPin == pin && count < 3) {
                    System.out.println("\nPIN ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT.");
                    break;
                }//end If

                if (userPin != pin && count >= 2) {
                    System.out.printf("\n%s\n%s\n", "YOU HAVE RUN OUT OF ATTEMPTS.",
                            "YOU'RE NOW LOCKED OUT OF THE ACCOUNT.");
                    break;
                }//end If
            }//end For
        }//end I
        END PART 1 QUESTION 1 */
        //START Part 1 Question 2
        if (userPin == pin) {
            System.out.println("\nPIN ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT.");
        } else {
            int count = 1;
            do {
                System.out.println("\nINCORRECT PIN. TRY AGAIN.");
                System.out.print("ENTER YOUR PIN: ");
                userPin = input.nextInt();

                //Count number of tries and let the user know if they entered correct pin
                if (userPin == pin && count < 3) {
                    System.out.println("\nPIN ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT.");
                    break;
                }//end If

                if (userPin != pin && count >= 2) {
                    System.out.printf("\n%s\n%s\n", "YOU HAVE RUN OUT OF ATTEMPTS.",
                            "YOU'RE NOW LOCKED OUT OF THE ACCOUNT.");
                    break;
                }//end If

                count++;
            } while (count != 3);
        }//end If
    }//end Main
}//end Class
