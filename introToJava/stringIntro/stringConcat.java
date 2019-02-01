/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class StringConcat {

    public static void main(String[] args) {
        String s1 = "Happy ";
        String s2 = "Birthday";

        System.out.printf("s1 = %s\ns2 = %s\n\n", s1, s2);
        System.out.printf("Result of s1.concat(s2) = %s\n", s1.concat(s2));
        System.out.printf("s1 after concatenation = %s\n", s1);
    }//end Main
}//end Class
