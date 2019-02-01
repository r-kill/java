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

public class Craps {

    private static final Random rands = new Random();

    private enum Status {
        CONTINUE, WON, LOST
    };

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args) {
        int myPoint = 0;
        Status gameStatus;

        int sumDice = rollDice();

        switch (sumDice) {
            case SEVEN:
            case YO_LEVEN:
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                gameStatus = Status.LOST;
                break;
            default:
                gameStatus = Status.CONTINUE;
                myPoint = sumDice;
                System.out.printf("Point is %d\n", myPoint);
                break;
        }//end Switch

        while (gameStatus == Status.CONTINUE) {
            sumDice = rollDice();

            if (sumDice == myPoint) {
                gameStatus = Status.WON;
            } else if (sumDice == SEVEN) {
                gameStatus = Status.LOST;
            }//end If//end If Else
        }//end While

        if (gameStatus == Status.WON) {
            System.out.println("Player wins.");
        } else {
            System.out.println("Player losess.");
        }//end If Else
    }//end Main

    public static int rollDice() {
        int die1 = 1 + rands.nextInt(6);
        int die2 = 1 + rands.nextInt(6);

        int sum = die1 + die2;

        System.out.printf("Player rolled %d + %d = %d\n", die1, die2, sum);

        return sum;
    }//end rollDice
}//end Class
