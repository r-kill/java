/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class ArmstrongNums {

    public static void main(String[] args) {
        int digitHolder = 0;
        int totalCount = 0;

        System.out.println("All three digit Armstrong Numbers are:\n");

        //this loop breaks down the number and finds the sum of the cubes
        for (int i = 153; i <= 407; i++) {
            /* I've decided to just comment this out since the assignment
               specifically says [not?] to use a nested loop!
            for (int j = 1; j <= 3; j++) {
                numTest = digitHolder % 10;
                digitHolder /= 10;
                digitTotal += Math.pow(numTest, 3);
                totalCount += 2; //5*5*5 counts as 2 multiplications
            }//end nest For that does calculations and tests if armstrong
             */

            digitHolder = i;
            int digit1 = digitHolder % 10;
            int digit2 = ((digitHolder % 100) - (digit1)) / 10;
            int digit3 = ((digitHolder % 1000) - (digit1)) / 100;
            //switch statement will give us the lowest number of multiplications
            switch (i) {
                case 153:
                    System.out.print("(");

                    System.out.printf("%d%s%d%s%d", digit3, "*", digit3, "*", digit3);
                    System.out.print(" + ");
                    System.out.printf("%d%s%d%s%d", digit2, "*", digit2, "*", digit2);
                    System.out.print(" + ");
                    System.out.printf("%d%s%d%s%d", digit1, "*", digit1, "*", digit1);

                    System.out.printf("%s%d\n", ") = ", i);

                    totalCount += 6;
                    continue;
                case 370:
                    System.out.print("(");

                    System.out.printf("%d%s%d%s%d", digit3, "*", digit3, "*", digit3);
                    System.out.print(" + ");
                    System.out.printf("%d%s%d%s%d", digit2, "*", digit2, "*", digit2);
                    System.out.print(" + ");
                    System.out.printf("%d%s%d%s%d", digit1, "*", digit1, "*", digit1);

                    System.out.printf("%s%d\n", ") = ", i);

                    totalCount += 6;
                    continue;
                case 371:
                    System.out.print("(");

                    System.out.printf("%d%s%d%s%d", digit3, "*", digit3, "*", digit3);
                    System.out.print(" + ");
                    System.out.printf("%d%s%d%s%d", digit2, "*", digit2, "*", digit2);
                    System.out.print(" + ");
                    System.out.printf("%d%s%d%s%d", digit1, "*", digit1, "*", digit1);

                    System.out.printf("%s%d\n", ") = ", i);

                    totalCount += 6;
                    continue;
                case 407:
                    System.out.print("(");

                    System.out.printf("%d%s%d%s%d", digit3, "*", digit3, "*", digit3);
                    System.out.print(" + ");
                    System.out.printf("%d%s%d%s%d", digit2, "*", digit2, "*", digit2);
                    System.out.print(" + ");
                    System.out.printf("%d%s%d%s%d", digit1, "*", digit1, "*", digit1);

                    System.out.printf("%s%d\n", ") = ", i);

                    totalCount += 6;
            }//end Switch
        }//end outer For
        System.out.println("\nThe program performed " + totalCount + " multiplications.");
    }//end Main
}//end Class
