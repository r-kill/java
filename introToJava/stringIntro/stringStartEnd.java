/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class StringStartEnd {

    public static void main(String[] args) {
        String[] strs = {"started", "starting", "ended", "ending"};

        //test method startsWith
        for (String string : strs) {
            if (string.startsWith("st")) {
                System.out.printf("\"%s\" starts with \"st\"\n", string);
            }//end If
        }//end For

        System.out.println();

        //test startsWith starting at position 2 of str
        for (String str : strs) {
            if (str.startsWith("art", 2)) {
                System.out.printf("\"%s\" starts with \"art\" at position 2\n", str);
            }//end If
        }//end For

        System.out.println();

        //test endsWith
        for (String str : strs) {
            if (str.endsWith("ed")) {
                System.out.printf("\"%s\" ends with \"ed\"\n", str);
            }//end If
        }//end For
    }//end Main
}//end Class
