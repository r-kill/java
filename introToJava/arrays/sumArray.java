/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class SumArray {

    public static void main(String[] args) {
        int[] array = {87, 68, 94, 100, 83, 78, 85, 91, 76, 87};
        int total = 0;

        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }//end For

        System.out.printf("Total of array elements is %d\n", total);
    }//end Main
}//end Class
