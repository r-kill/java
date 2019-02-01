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

public class RollDie {

    public static void main(String[] args) {
        Random rands = new Random();
        int[] frequency = new int[7];

        for (int roll = 1; roll <= 6000; roll++) {
            ++frequency[1 + rands.nextInt(6)];
        }//end For

        System.out.printf("%s%10s\n", "Face", "Frequency");

        for (int face = 1; face < frequency.length; face++) {
            System.out.printf("%4d%10d\n", face, frequency[face]);
        }//end For
    }//end Main
}//end Class
