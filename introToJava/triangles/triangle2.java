/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        //user info
        System.out.printf("%s\n%s\n%s\n%s\n\n",
                "This program will ask you to input three",
                "integers to represent each of the sides of",
                "a triangle, test if your inputs will make a",
                "triangle, and then output the area if possible.");

        //get input from user
        Scanner input = new Scanner(System.in);
        int Opp, Adj, Hyp;
        System.out.print("Enter an integer to represent ONE of the two small sides: ");
        Opp = input.nextInt();
        System.out.print("Enter an integer to represent the OTHER of the two small sides: ");
        Adj = input.nextInt();
        System.out.print("Enter an integer to represent the Hypotenuse (the longest side): ");
        Hyp = input.nextInt();

        //what to compute and output if the sides DO form triangle
        //test is based on Triangle Inequality Theorem
        //includes 0 even though theorem does not
        if ((Opp + Adj) >= Hyp) {
            if ((Opp + Hyp) >= Adj) {
                if ((Hyp + Adj) >= Opp) {
                    double semiP = .5 * (Opp + Adj + Hyp);
                    double heron = Math.sqrt(semiP * (semiP - Opp) * (semiP - Adj) * (semiP - Hyp));
                    int results = (int) heron;
                    System.out.printf("The area of the triangle is: %d\n", results);
                    return;
                }
            }
        } //end of IF test

        /*
        what to output if the sides DON'T form a triangle
        could be replaced completely with 'else' statement, but that's ch. 3
         */
        System.out.println("The side lengths you entered do not form a triangle.");
    } //end of Main
} //end of Part2 class
