/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
import java.util.Arrays;

public class ArrayManipulations {

    public static void main(String[] args) {
        double[] dblArray = {8.4, 9.3, 0.2, 7.9, 3.4};
        Arrays.sort(dblArray);
        System.out.print("\ndblArray: ");

        for (double value : dblArray) {
            System.out.printf("%.1f ", value);
        }//end For

        //fill 10 element array with 7s
        int[] fillArray = new int[10];
        Arrays.fill(fillArray, 7);
        displayArray(fillArray, "fillArray");

        //copy one array to another
        int[] intArray = {1, 2, 3, 4, 5, 6};
        int[] arrayCopy = new int[intArray.length];
        System.arraycopy(intArray, 0, arrayCopy, 0, intArray.length);
        displayArray(intArray, "intArray");
        displayArray(arrayCopy, "arraryCopy");

        //compare two arrays for equality
        boolean b = Arrays.equals(intArray, arrayCopy);
        System.out.printf("\n\nintArray %s arrayCopy\n", (b ? "==" : "!="));

        //same as above
        b = Arrays.equals(intArray, fillArray);
        System.out.printf("intArray %s fillArray\n", (b ? "==" : "!="));

        //search array for a value
        int location = Arrays.binarySearch(intArray, 5);

        if (location >= 0) {
            System.out.printf("Found 5 at element %d in intArray\n", location);
        } else {
            System.out.println("5 not found in intArray");
        }//end If..Else

        //search array for 8763
        location = Arrays.binarySearch(intArray, 8763);

        if (location >= 0) {
            System.out.printf("Found 8763 at element %d in intArray\n", location);
        } else {
            System.out.println("8763 not found in intArray");
        }//end If..Else
    }//end Main

    public static void displayArray(int[] array, String description) {
        System.out.printf("\n%s: ", description);

        for (int value : array) {
            System.out.print(value + " ");
        }//end For
    }//end displayArray
}//end Classs
