/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class EnhancedFor {

    public static void main(String[] args) {
        int[] array = {87, 68, 94, 100, 83, 78, 85, 91, 76, 87};
        int total = 0;

        for (int num : array) {
            total += num;
        }//end For

        System.out.printf("Total elements i array is: %d\n", total);
    }//end Main
}//end Class
