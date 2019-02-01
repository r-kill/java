/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
import java.util.ArrayList;

public class ArrayListCollection {

    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<String>();

        items.add("red"); //append to list
        items.add(0, "yellow"); //insert item at index 0

        //header
        System.out.print("Display list contents with counter-controlled loop:");

        //display colors in list
        for (int i = 0; i < items.size(); i++) {
            System.out.printf(" %s", items.get(i));
        }//end For

        display(items, "\nDisplay lists contents with enhanced for statement:");

        items.add("green");
        items.add("yellow");
        display(items, "List with two new elements:");

        items.remove("yellow");
        display(items, "Remove first instance of yellow:");

        items.remove(1);
        display(items, "Remove second list element (green):");

        //check if value is in list
        System.out.printf("\"red\" is %sin the list\n",
                items.contains("red") ? "" : "not ");

        //display number of elements in list
        System.out.printf("Size: %s\n", items.size());
    }//end Main

    public static void display(ArrayList<String> items, String header) {
        System.out.print(header);

        //display each element in list items
        for (String item : items) {
            System.out.printf(" %s", item);
        }//end For

        System.out.println();
    }//end display
}//end Class
