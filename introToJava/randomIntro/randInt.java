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

public class RandInt {

    public static void main(String[] args) {
        Random rands = new Random();
        int face;

        for (int i = 1; i <= 20; i++) {
            face = 1 + rands.nextInt(6);

            System.out.printf("%d ", face);

            if (i % 5 == 0) {
                System.out.println();
            }//end If
        }//end For
    }//end Main
}//end Class
