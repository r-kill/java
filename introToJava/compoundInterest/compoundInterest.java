/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class CompoundInterest {

    public static void main(String[] args) {
        double amount;
        double p = 1000.0;
        double rate = 0.05;

        System.out.printf("%s%20s\n", "Year", "Amount to deposit");

        for (int year = 1; year <= 10; year++) {
            //adding 1.0 + rate is inefficient and wasteful
            amount = p * Math.pow(1.0 + rate, year);
            System.out.printf("%4d%,20.2f\n", year, amount);
        }//end For
    }//end Main
}//end Class
