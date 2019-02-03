/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class Part1 {

    public static void main(String[] args) {
        //This is the println way to print my name.
        System.out.println("RRRR   OOO  W   W   A   N   N");
        System.out.println("R   R O   O W   W  A A  NN  N");
        System.out.println("R   R O   O W   W A   A N N N");
        System.out.println("RRRR  O   O W W W AAAAA N  NN");
        System.out.println("R R   O   O WW WW A   A N   N");
        System.out.println("R  R  O   O WW WW A   A N   N");
        System.out.println("R   R  OOO  W   W A   A N   N");
        //print a blank line to show the next print method
        System.out.println();

        /*
        This is how
        to print my name
        using only print
         */
        System.out.print("RRRR   OOO  W   W   A   N   N\n");
        System.out.print("R   R O   O W   W  A A  NN  N\n");
        System.out.print("R   R O   O W   W A   A N N N\n");
        System.out.print("RRRR  O   O W W W AAAAA N  NN\n");
        System.out.print("R R   O   O WW WW A   A N   N\n");
        System.out.print("R  R  O   O WW WW A   A N   N\n");
        System.out.print("R   R  OOO  W   W A   A N   N\n");
        /* Print a blank line to more clearly show the next print method */
        System.out.print("\n");

        /**
         * Finally, this is how to print my name using printf
         */
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                "RRRR   OOO  W   W   A   N   N",
                "R   R O   O W   W  A A  NN  N",
                "R   R O   O W   W A   A N N N",
                "RRRR  O   O W W W AAAAA N  NN",
                "R R   O   O WW WW A   A N   N",
                "R  R  O   O WW WW A   A N   N",
                "R   R  OOO  W   W A   A N   N");
    } //end Main
} //end Part1
