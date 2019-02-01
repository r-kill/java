/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class SumEvenInts {

    public static void main(String[] args) {
        int total = 0;
        int total2 = 0;

        for (int num = 2; num <= 20; num += 2) {
            total += num;
        }//end For
        System.out.printf("Sum in %d\n\n", total);

        //this is another way to write same loop as above
        //THIS IS DISCOURAGED THIS IS HARDER TO READ
        for (int num = 2; num <= 20; num += 2, total2 += num);
        System.out.printf("Sum in %d\n", total);
    }//end Main
}//end Class
