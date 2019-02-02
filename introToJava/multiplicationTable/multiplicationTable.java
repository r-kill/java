/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        int length = 0;

        for (int row = 0; row <= 12; row++) {
            if (row == 0) {
                System.out.print("X  | ");
                for (int i = 1; i <= 9; i++) {
                    System.out.print(i + "    ");
                }//end nested For used to print header part 1
                System.out.println("");

                for (int j = 0; j < 50; j++) {
                    if (j != 3) {
                        System.out.print("=");
                    } else {
                        System.out.print("+");
                    }//end nest If to print = or + for second row
                }//end For to print other part of header row
                System.out.println("");
            } else {
                length = String.valueOf(row).length();
                System.out.print((length == 1) ? (row + "  | ") : (row + " | "));

                for (int col = 1; col <= 9; col++) {
                    length = String.valueOf(col * row).length();
                    switch (length) {
                        case 1:
                            System.out.print((col * row) + "    ");
                            break;
                        case 2:
                            System.out.print((col * row) + "   ");
                            break;
                        case 3:
                            System.out.print((col * row) + "  ");
                            break;
                        default:
                            System.out.print((col * row) + " ");
                            break;
                    }//end Switch to choose how much whitespace to us
                }//end nest For
                System.out.println("");
            }//end If...else to print header
        }//end outer For
    }//end Main
}//end Class
