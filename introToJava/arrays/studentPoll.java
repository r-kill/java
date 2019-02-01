/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class StudentPoll {

    public static void main(String[] args) {
        int[] respond = {1, 2, 6, 4, 8, 5, 9, 7, 8, 10, 1, 6, 3, 8, 6,
            10, 3, 8, 2, 7, 6, 5, 7, 6, 8, 6, 7, 5, 6, 6, 5, 6, 7,
            5, 6, 4, 8, 6, 8, 10};
        int[] frequency = new int[11];

        for (int answer = 0; answer < respond.length; answer++) {
            ++frequency[respond[answer]];
        }//end For

        System.out.printf("%s%10s\n", "Rating", "Frequency");

        for (int rate = 1; rate < frequency.length; rate++) {
            System.out.printf("%6d%10d\n", rate, frequency[rate]);
        }//end For
    }//end Main
}//end Class
