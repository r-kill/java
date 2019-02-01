/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
// This works as long as the file is in the main directory and has data in it
import java.io.File;
import java.util.Scanner;

public class ReadTextFile {

    public static void main(String[] args) throws Exception {
        //open text file for reading w/ a scanner
        Scanner input = new Scanner(new File("clients.txt"));

        int acctNum;
        String fName, lName;
        double balance;

        System.out.printf("%-10s%-12s%-12s%10s\n", "Account", "First Name", "Lsat Name", "Balance");

        while (input.hasNext()) {
            acctNum = input.nextInt();
            fName = input.next();
            lName = input.next();
            balance = input.nextDouble();

            //display record contents
            System.out.printf("%-10d%-12s%-12s%10.2f\n", acctNum, fName, lName, balance);
        }//end While

        input.close();
    }//end Main
}//end Class
