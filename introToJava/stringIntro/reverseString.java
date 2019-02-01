/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class MiscStringThings {

    public static void main(String[] args) {
        String s1 = "hello there";
        char[] array = new char[5];

        System.out.printf("s1: %s", s1);

        System.out.printf("\nLength of s1: %d", s1.length());

        System.out.print("\nThe string reversed is: ");

        for (int count = s1.length() - 1; count >= 0; count--) {
            System.out.printf("%c ", s1.charAt(count));
        }//end For

        //copy chars from string into array
        s1.getChars(0, 5, array, 0);
        System.out.print("\nThe character array is: ");

        for (char character : array) {
            System.out.print(character);
        }//end For

        System.out.println();
    }//end Main
}//end Class
