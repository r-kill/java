/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class CounterControlledWhile {

    public static void main(String[] args) {
        int count = 0;

        //count is incrememted in while test, can lose the {}
        while (++count <= 10) {
            System.out.printf("%d ", count);
        }//end While
        System.out.println();
    }//end Main
}//end Class
