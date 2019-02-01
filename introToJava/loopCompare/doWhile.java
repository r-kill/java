/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class DoWhileTest {

    public static void main(String[] args) {
        int count = 1;

        do {
            System.out.printf("%d ", count);
            ++count;
        } while (count <= 10);

        System.out.println();
    }//end Main
}//end Class
