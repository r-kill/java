/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class PassArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        System.out.println("Effects of passing reference ot entire array: \n"
                + "The values of the original array are:");

        for (int value : array) {
            System.out.printf("   %d", value);
        }//end For

        modifyArray(array);
        System.out.println("\n\nThe values of the modified array are:");

        for (int value : array) {
            System.out.printf("   %d", value);
        }//end For

        System.out.printf("\n\nEffects of passing array element value:\n"
                + "array[3] before modifyElement: %d\n", array[3]);

        modifyElement(array[3]);
        System.out.printf("array[3] after modifyElement: %d\n", array[3]);
    }//end Main

    public static void modifyArray(int[] array2) {
        for (int count = 0; count < array2.length; count++) {
            array2[count] *= 2;
        }//end For
    }//end modifyArray

    public static void modifyElement(int element) {
        element *= 2;
        System.out.printf("Value of element in modifyElement: %d\n", element);
    }//end modifyElement
}//end Class
