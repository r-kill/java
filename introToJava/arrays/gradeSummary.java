/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
public class SummarizeGrades {

    public static void main(String[] args) {
        int[][] gradesArray =
                {{87, 96, 70},
                {68, 87, 90},
                {94, 100, 90},
                {100, 81, 82},
                {83, 65, 85},
                {78, 87, 65},
                {85, 75, 83},
                {91, 94, 100},
                {76, 72, 84},
                {87, 93, 73}};

        outputGrades(gradesArray);

        System.out.printf("\n%s %d\n%s %d\n\n", "Lowest grde is",
                getMin(gradesArray), "Highest grade is", getMax(gradesArray));

        outputBar(gradesArray);
    }//end Main

    public static int getMin(int grades[][]) {
        //assume first element is smallest
        int lowGrade = grades[0][0];

        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                if (grade < lowGrade) {
                    lowGrade = grade;
                }//end inner If
            }//end nested For
        }//end outer For
        return lowGrade;
    }//end getMin

    public static int getMax(int grades[][]) {
        //assume first element is highest
        int highGrade = grades[0][0];

        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                if (grade > highGrade) {
                    highGrade = grade;
                }//end inner If
            }//end nested For
        }//end outer For
        return highGrade;
    }//end getMax

    public static double getAvg(int[] gradeSet) {
        int total = 0;

        for (int grade : gradeSet) {
            total += grade;
        }//end For
        return (double) total / gradeSet.length;
    }//end getAvg

    public static void outputBar(int grades[][]) {
        System.out.println("Overall grade distribution:");

        int[] freq = new int[11];

        //increment the correct grades in gradebook
        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                ++freq[grade / 10];
            }//end nested For
        }//end outer For

        //for each grade frequency, print bar in chart
        for (int count = 0; count < freq.length; count++) {
            if (count == 10) {
                System.out.printf("%5d: ", 100);
            } else {
                System.out.printf("%02d-%02d: ", count * 10, count * 10 + 9);
            }//end If..Else

            //print bar of asterisks
            for (int stars = 0; stars < freq[count]; stars++) {
                System.out.print("*");
            }//end For

            System.out.println();
        }//end outer For
    }//end outputBar

    public static void outputGrades(int grades[][]) {
        System.out.println("The grades are:\n");
        System.out.print("            ");

        //create a column header for each exam
        for (int exam = 0; exam < grades[0].length; exam++) {
            System.out.printf("Test %d ", exam + 1);
        }//end For

        //column header for avg
        System.out.println("Average");

        //fill in table
        for (int student = 0; student < grades.length; student++) {
            System.out.printf("Student %2d", student + 1);

            //output students grades
            for (int test : grades[student]) {
                System.out.printf("%7d", test);
            }//end nested For

            //pass row of grades to getAvg
            double avg = getAvg(grades[student]);
            System.out.printf("%9.2f\n", avg);
        }//end outer For
    }//end outputGrades
}//end Class
