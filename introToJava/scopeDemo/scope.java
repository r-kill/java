/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class Scope {

    private static int x = 1;

    public static void main(String[] args) {
        int x = 5;

        System.out.printf("Local x in main is %d\n", x);

        useLocalVar();
        useField();
        useLocalVar();
        useField();

        System.out.printf("\nLocal x in main is %d\n", x);
    }//end Main

    public static void useLocalVar() {
        int x = 25;

        System.out.printf("\nLocal x on entering method useLocalVar is %d", x);
        ++x;
        System.out.printf("\nLocal x on exiting method useLocalVar is %d\n", x);
    }//end useLocalVar

    public static void useField() {
        System.out.printf("\nLocal x on entering method useField is %d", x);
        x *= 10;
        System.out.printf("\nLocal x on exiting method useField is %d\n", x);
    }//end useField
}
