/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
import java.util.Random;

public class Part2 {

    public static void main(String[] args) {
        //user info
        System.out.println("Welcome to the dice rolling game!");
        System.out.println("The dice will roll until a matching pair is rolled!");

        Random rand = new Random();

        int num1 = 1 + rand.nextInt(6);
        int num2 = 1 + rand.nextInt(6);
        int round = 1;
        double frequency2 = 0;
        double frequency3 = 0;
        double frequency4 = 0;
        double frequency5 = 0;
        double frequency6 = 0;
        double frequency7 = 0;
        double frequency8 = 0;
        double frequency9 = 0;
        double frequency10 = 0;
        double frequency11 = 0;
        double frequency12 = 0;

        while (true) {
            //tell user about the new roll
            System.out.printf("\nRound %d:\n", round);
            System.out.printf("Roll #1: %d\n", num1);
            System.out.printf("Roll #2: %d\n", num2);
            System.out.printf("The total is %d!\n", num1 + num2);

            switch (num1 + num2) {
                case 2:
                    ++frequency2;
                    break;
                case 3:
                    ++frequency3;
                    break;
                case 4:
                    ++frequency4;
                    break;
                case 5:
                    ++frequency5;
                    break;
                case 6:
                    ++frequency6;
                    break;
                case 7:
                    ++frequency7;
                    break;
                case 8:
                    ++frequency8;
                    break;
                case 9:
                    ++frequency9;
                    break;
                case 10:
                    ++frequency10;
                    break;
                case 11:
                    ++frequency11;
                    break;
                default: //case 12
                    ++frequency12;
            }//end Switch

            //break out of loop after info is output if there's a pair
            if (num1 == num2) {
                break;
            }//end If

            //set num1 and num2 to new randInts and go to next round
            num1 = 1 + rand.nextInt(6);
            num2 = 1 + rand.nextInt(6);
            ++round;
        }//end While

        //frequency calculation
        frequency2 /= (double) round;
        frequency3 /= (double) round;
        frequency4 /= (double) round;
        frequency5 /= (double) round;
        frequency6 /= (double) round;
        frequency7 /= (double) round;
        frequency8 /= (double) round;
        frequency9 /= (double) round;
        frequency10 /= (double) round;
        frequency11 /= (double) round;
        frequency12 /= (double) round;

        //print table output
        //header row for table output
        System.out.printf("\n%s%13s", "Number", "Frequency");
        //data rows
        System.out.printf("\n%4s%13.5s", 2, frequency2);
        System.out.printf("\n%4s%13.5s", 3, frequency3);
        System.out.printf("\n%4s%13.5s", 4, frequency4);
        System.out.printf("\n%4s%13.5s", 5, frequency5);
        System.out.printf("\n%4s%13.5s", 6, frequency6);
        System.out.printf("\n%4s%13.5s", 7, frequency7);
        System.out.printf("\n%4s%13.5s", 8, frequency8);
        System.out.printf("\n%4s%13.5s", 9, frequency9);
        System.out.printf("\n%4s%13.5s", 10, frequency10);
        System.out.printf("\n%4s%13.5s", 11, frequency11);
        System.out.printf("\n%4s%13.5s\n", 12, frequency12);
    }//end Main
}//end Class
