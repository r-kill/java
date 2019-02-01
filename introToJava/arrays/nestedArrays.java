/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class InitArrray {

    public static void main(String[] arrgs) {
        int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] array2 = {{1, 2}, {3}, {4, 5, 6}};

        System.out.println("Values in array1 by row are");
        outputArray(array1);

        System.out.println("\nValues in array2 by row are");
        outputArray(array2);
    }//end Main

    public static void outputArray(int[][] array) {
        //loop through rows
        for (int row = 0; row < array.length; row++) {
            //loop through columns
            for (int col = 0; col < array[row].length; col++) {
                System.out.printf("%d ", array[row][col]);
            }//end nested For for cols

            System.out.println();
        }//end For for rows
    }//end outputArray
}//end Class
