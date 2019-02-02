/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * NOTES
 * TIME SPENT SO FAR: 14 hours
 */
import java.util.Scanner;
import java.util.ArrayList;

public class OnlineFoodOrder {

    //scanner variable
    public static Scanner input = new Scanner(System.in);

    //user input, default to -1
    public static int choice = -1;

    //array holding food items
    public static String[] foodName = {"Hamburger", "Wings", "Pizza", "Lemonade"};

    //array holding quantity of each item
    public static int[] foodQuant = new int[4];

    //array to hold food prices
    public static int[] prices = {8, 1, 5, 3};

    //array to hold the items user ordered dynamically
    public static ArrayList<String> foodOrder = new ArrayList<String>();

    //array to hold order prices dynamically
    public static ArrayList<Integer> orderPrices = new ArrayList<Integer>();

    //array to hold quantities of food dynamically
    public static ArrayList<Integer> foodQuants = new ArrayList<Integer>();

    //total for purchase
    public static double total = 0.0;

    //tax value
    public static double tax = .0777;

    //flag for showing a page separator
    public static boolean flag = true;

    public static void main(String[] args) {
        //start
        mainMenu();
    }//end Main

    public static void mainMenu() {
        do {
            //print menu
            System.out.println();
            System.out.printf("\t%s\n\t%s\n%s\n\t%d%s\n\t%d%s\n\t%d%s\n\t%d%s\n",
                    "Welcome to Food Place!", "Please enter your choice from the menu or enter 0 (zero) to exit:",
                    "", 1, ". Add food to order", 2, ". Remove food from order", 3, ". Review your order",
                    4, ". Checkout");

            try {
                //get input
                System.out.println("\nWhat would you like to do?");
                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                switch (choice) {
                    case 0:
                        lineBreak();
                        System.out.println("\nExiting. Please come again!");
                        System.out.println("We hope you enjoyed your time!");
                        choice = 0;
                        break;
                    case 1:
                        lineBreak();
                        addFood();
                        break;
                    case 2:
                        removeFood();
                        break;
                    case 3:
                        lineBreak();
                        //set flag to true just in case
                        flag = true;
                        review(flag);
                        break;
                    case 4:
                        lineBreak();
                        checkout();
                        break;
                    default:
                        choice = -1;
                        System.out.println("\nYou need to enter a choice on the list!");
                }//end Switch
            } catch (Exception e) {
                System.out.println("\nError in your input.");
                System.out.println("You need to enter a choice from the list!");

                //clears scanner buffer for string inputs
                input.nextLine();
            }//end Try..Catch error check
        } while (choice != 0);
    }//end mainMenu

    public static void addFood() {
        do {
            //initial menu output
            System.out.printf("\n%s\n%s\n", "Enter one food choice from the list below or",
                    "enter 0 (zero) to go back to the main menu: ");
            System.out.printf("\n%s %s    %s\n", "ID", "Food Name", "Price");
            for (int item = 0; item < prices.length; item++) {
                System.out.printf("%d%s\t%s\n", item + 1,
                        ". " + foodName[item],
                        "$" + prices[item]);
            }//end For

            try {
                //get input
                System.out.println("\nWhat food item would you like?");
                System.out.print("Enter your choice here: ");
                choice = input.nextInt();
                switch (choice) {
                    case 0:
                        choice = -1;
                        System.out.println("\nReturning to main menu!");
                        return;
                    case 1:
                        //get quantity for choice of food and append it to order
                        System.out.print(foodName[choice - 1] + "(quantity): ");

                        //get input
                        int quant = input.nextInt();

                        //make sure user knows that they're entering an item with quantity of 0
                        //if they enter 0 or a negative number
                        if (quant <= 0) {
                            System.out.printf("\n%s\n%s\n%s\n%s\n%s",
                                    "Just so you're aware, you've entered 0 as the",
                                    "quantity, or a negative quantity, for the item you selected.",
                                    "This means you will get zero of that item,",
                                    "but it will be on the list.",
                                    "Do you want to continue (Y or N)? ");
                            //this will be caught by default
                            String answer = input.next();
                            switch (answer) {
                                case "Y":
                                case "YES":
                                case "Yes":
                                case "yes":
                                case "y":
                                    System.out.println("\nAdding item to list with zero quantity.");
                                    //error here is caught by outer try/catch
                                    foodQuant[choice - 1] = quant;

                                    //adjust total and append item name to list
                                    total += prices[choice - 1] * foodQuant[choice - 1];
                                    foodOrder.add(foodName[choice - 1]);

                                    //these hold the price & quantity of the food ordered
                                    orderPrices.add(prices[choice - 1]);
                                    foodQuants.add(foodQuant[choice - 1]);
                                    break;
                                case "N":
                                case "NO":
                                case "No":
                                case "no":
                                case "n":
                                    System.out.println("\nOkay. Returning to add item menu.");
                                    break;
                                default:
                                    //if user enters anything but y/Y, n/N, or other variations
                                    System.out.println("\nYou need to enter Y or N.");
                            }//end Switch
                            break;
                        } else {
                            //error here is caught by outer try/catch
                            foodQuant[choice - 1] = quant;

                            //adjust total and append item name to list
                            total += prices[choice - 1] * foodQuant[choice - 1];
                            foodOrder.add(foodName[choice - 1]);

                            //these hold the price & quantity of the food ordered
                            orderPrices.add(prices[choice - 1]);
                            foodQuants.add(foodQuant[choice - 1]);
                        }//end If to warn user of having zero quantity
                        break;
                    case 2:
                        //get quantity for choice of food and append it to order
                        System.out.print(foodName[choice - 1] + "(quantity): ");

                        //get input
                        quant = input.nextInt();

                        //make sure user knows that they're entering an item with quantity of 0
                        //if they enter 0 or a negative number
                        if (quant <= 0) {
                            System.out.printf("\n%s\n%s\n%s\n%s\n%s",
                                    "Just so you're aware, you've entered 0 as the",
                                    "quantity, or a negative quantity, for the item you selected.",
                                    "This means you will get zero of that item,",
                                    "but it will be on the list.",
                                    "Do you want to continue (Y or N)? ");
                            //this will be caught by default
                            String answer = input.next();
                            switch (answer) {
                                case "Y":
                                case "YES":
                                case "Yes":
                                case "yes":
                                case "y":
                                    System.out.println("\nAdding item to list with zero quantity.");
                                    //error here is caught by outer try/catch
                                    foodQuant[choice - 1] = quant;

                                    //adjust total and append item name to list
                                    total += prices[choice - 1] * foodQuant[choice - 1];
                                    foodOrder.add(foodName[choice - 1]);

                                    //these hold the price & quantity of the food ordered
                                    orderPrices.add(prices[choice - 1]);
                                    foodQuants.add(foodQuant[choice - 1]);
                                    break;
                                case "N":
                                case "NO":
                                case "No":
                                case "no":
                                case "n":
                                    System.out.println("\nOkay. Returning to add item menu.");
                                    break;
                                default:
                                    //if user enters anything but y/Y, n/N, or other variations
                                    System.out.println("\nYou need to enter Y or N.");
                            }//end Switch
                            break;
                        } else {
                            //error here is caught by outer try/catch
                            foodQuant[choice - 1] = quant;

                            //adjust total and append item name to list
                            total += prices[choice - 1] * foodQuant[choice - 1];
                            foodOrder.add(foodName[choice - 1]);

                            //these hold the price & quantity of the food ordered
                            orderPrices.add(prices[choice - 1]);
                            foodQuants.add(foodQuant[choice - 1]);
                        }//end If to warn user of having zero quantity
                        break;
                    case 3:
                        //get quantity for choice of food and append it to order
                        System.out.print(foodName[choice - 1] + "(quantity): ");

                        //get input
                        quant = input.nextInt();

                        //make sure user knows that they're entering an item with quantity of 0
                        //if they enter 0 or a negative number
                        if (quant <= 0) {
                            System.out.printf("\n%s\n%s\n%s\n%s\n%s",
                                    "Just so you're aware, you've entered 0 as the",
                                    "quantity, or a negative quantity, for the item you selected.",
                                    "This means you will get zero of that item,",
                                    "but it will be on the list.",
                                    "Do you want to continue (Y or N)? ");
                            //this will be caught by default
                            String answer = input.next();
                            switch (answer) {
                                case "Y":
                                case "YES":
                                case "Yes":
                                case "yes":
                                case "y":
                                    System.out.println("\nAdding item to list with zero quantity.");
                                    //error here is caught by outer try/catch
                                    foodQuant[choice - 1] = quant;

                                    //adjust total and append item name to list
                                    total += prices[choice - 1] * foodQuant[choice - 1];
                                    foodOrder.add(foodName[choice - 1]);

                                    //these hold the price & quantity of the food ordered
                                    orderPrices.add(prices[choice - 1]);
                                    foodQuants.add(foodQuant[choice - 1]);
                                    break;
                                case "N":
                                case "NO":
                                case "No":
                                case "no":
                                case "n":
                                    System.out.println("\nOkay. Returning to add item menu.");
                                    break;
                                default:
                                    //if user enters anything but y/Y, n/N, or other variations
                                    System.out.println("\nYou need to enter Y or N.");
                            }//end Switch
                            break;
                        } else {
                            //error here is caught by outer try/catch
                            foodQuant[choice - 1] = quant;

                            //adjust total and append item name to list
                            total += prices[choice - 1] * foodQuant[choice - 1];
                            foodOrder.add(foodName[choice - 1]);

                            //these hold the price & quantity of the food ordered
                            orderPrices.add(prices[choice - 1]);
                            foodQuants.add(foodQuant[choice - 1]);
                        }//end If to warn user of having zero quantity
                        break;
                    case 4:
                        //get quantity for choice of food and append it to order
                        System.out.print(foodName[choice - 1] + "(quantity): ");

                        //get input
                        quant = input.nextInt();

                        //make sure user knows that they're entering an item with quantity of 0
                        //if they enter 0 or a negative number
                        if (quant <= 0) {
                            System.out.printf("\n%s\n%s\n%s\n%s\n%s",
                                    "Just so you're aware, you've entered 0 as the",
                                    "quantity, or a negative quantity, for the item you selected.",
                                    "This means you will get zero of that item,",
                                    "but it will be on the list.",
                                    "Do you want to continue (Y or N)? ");
                            //this will be caught by default
                            String answer = input.next();
                            switch (answer) {
                                case "Y":
                                case "YES":
                                case "Yes":
                                case "yes":
                                case "y":
                                    System.out.println("\nAdding item to list with zero quantity.");
                                    //error here is caught by outer try/catch
                                    foodQuant[choice - 1] = quant;

                                    //adjust total and append item name to list
                                    total += prices[choice - 1] * foodQuant[choice - 1];
                                    foodOrder.add(foodName[choice - 1]);

                                    //these hold the price & quantity of the food ordered
                                    orderPrices.add(prices[choice - 1]);
                                    foodQuants.add(foodQuant[choice - 1]);
                                    break;
                                case "N":
                                case "NO":
                                case "No":
                                case "no":
                                case "n":
                                    System.out.println("\nOkay. Returning to add item menu.");
                                    break;
                                default:
                                    //if user enters anything but y/Y, n/N, or other variations
                                    System.out.println("\nYou need to enter Y or N.");
                            }//end Switch
                            break;
                        } else {
                            //error here is caught by outer try/catch
                            foodQuant[choice - 1] = quant;

                            //adjust total and append item name to list
                            total += prices[choice - 1] * foodQuant[choice - 1];
                            foodOrder.add(foodName[choice - 1]);

                            //these hold the price & quantity of the food ordered
                            orderPrices.add(prices[choice - 1]);
                            foodQuants.add(foodQuant[choice - 1]);
                        }//end If to warn user of having zero quantity
                        break;
                    default:
                        //this case is here as a precaution in case try/catch fails
                        choice = -1;
                        System.out.println("\nYou need to enter a choice on the list!");
                }//end Switch
            } catch (Exception e) {
                System.out.println("\nError in your input.");
                System.out.println("You need to enter a choice from the list!");

                //clears scanner buffer for string inputs
                input.nextLine();
            } finally {
                //runs regardless of exceptions
                lineBreak();
            }//end Try..Catch..Finally error check
        } while (choice != 0);
    }//end addFood

    public static void review(boolean flag) {
        //check if they've ordered anything yet
        if (foodOrder.isEmpty()) {
            System.out.print("\nYou haven't chosen anything to order.\n\n");
            choice = -1;
            //return user to the menu they were on before review was invoked
            lineBreak();
            mainMenu();
        } else {
            //if the arraylist for the order isn't empty, continue with last method
            //output table
            System.out.println("\nYour order consists of:");
            System.out.printf("\n%s %s    %s\t%s\t%s\n", "ID", "Food Name", "Price", "Quantity", "Fee");
            for (int item = 0; item < foodOrder.size(); item++) {
                System.out.printf("%d%s\t%s\t%s\t\t%s\n",
                        item + 1,
                        ". " + foodOrder.get(item),
                        "$" + (orderPrices.get(item)),
                        foodQuants.get(item),
                        "$" + (orderPrices.get(item) * foodQuants.get(item)));
            }//end For
            System.out.printf("%s%.2f\n", "\nTotal:\t\t\t\t\t$", total);

            //place line break if flag is passed as true
            if (flag) {
                lineBreak();
            }//end nested If
        }//end outer If..Else
    }//end review

    public static void removeFood() {
        //set this to false so review won't display first line break
        flag = false;
        do {
            //display users order based on value of user input w/ line break before
            lineBreak();
            //make sure choice isn't 0 to prevent returning to methods unexpectedly
            if (choice > 0) {
                review(flag);
                //if choice <= 0 after review, returns control to last method
                if (choice <= 0) {
                    return;
                }//end Nested If
            }//end If

            //checks input from user and adjusts variables accordingly
            try {
                //user info and get input
                System.out.println("\nEnter the ID of the food you want to remove");
                System.out.println("or else enter 0 (zero) to exit to the main menu.");
                System.out.print("Enter your choice here: ");
                choice = input.nextInt();

                //input validation
                switch (choice) {
                    case 0:
                        choice = -1;
                        System.out.println("\nReturning to main menu!");
                        lineBreak();
                        return;
                    case 1:
                        //check if they've ordered the ID they enter and adjust variables
                        if (foodOrder.contains(foodOrder.get(choice - 1))) {
                            //get input for new quantity
                            System.out.printf("\n%s\n%s\n%s\n",
                                    "You can either enter 0 (zero) to delete the item from your list,",
                                    "or you can enter a positive number that's less than the original",
                                    "quantity to represent the quantity.");
                            System.out.printf("\n%s", "Enter the new quantity of the food you selected: ");

                            //this is caught by outer try/catch
                            int replacement = input.nextInt();
                            //make sure user can't abuse inputs
                            if (replacement > foodQuants.get(choice - 1)) {
                                //if user enters a value higher than original quant
                                System.out.println("\nYou can't remove what you don't have!");
                                break;
                            } else if (foodQuants.get(choice - 1) != 0 && replacement == foodQuants.get(choice - 1)) {
                                //if user enters the amount they already have
                                //is quantity is already 0, don't catch it here so they will be able to remove the item
                                System.out.println("\nYou already have that many "
                                        + foodOrder.get(choice - 1) + "s.");
                                break;
                            } else if (replacement < 0) {
                                //if user enters a negative number
                                System.out.println("\nYou can only have positive quantities of food.");
                                break;
                            } else if (replacement == 0) {
                                //if user enters 0 to delete item from list
                                //ask user first
                                System.out.println("\nAre you sure you want to remove this item (Y or N)? ");
                                //get input, bad input is caught by default or try/catch
                                String remover = input.next();
                                switch (remover) {
                                    case "Y":
                                    case "YES":
                                    case "Yes":
                                    case "yes":
                                    case "y":
                                        System.out.println("\nRemoving item now.");
                                        System.out.println("You will be placed either in the main menu or");
                                        System.out.println("the remove item menu depending on if you have any items");
                                        System.out.println("in your order after removing this one.");

                                        //adjust total and remove all traces of item entry
                                        total -= foodQuants.get(choice - 1) * orderPrices.get(choice - 1);
                                        foodQuants.remove(choice - 1);
                                        orderPrices.remove(choice - 1);
                                        foodOrder.remove(choice - 1);
                                        break;
                                    case "N":
                                    case "NO":
                                    case "No":
                                    case "no":
                                    case "n":
                                        System.out.println("\nOkay. Returning to remove item menu.");
                                        break;
                                    default:
                                        //if user enters anything but y/Y, n/N, or other variations
                                        System.out.println("\nYou need to enter Y or N.");
                                }//end Switch to validate complete removal
                                break;
                            }//end nested If..ElseIf validation

                            //adjust the quantity of the item removed
                            foodQuants.set(choice - 1, replacement);

                            //tell user new quantity
                            System.out.printf("%s%s%s%d", "\n",
                                    foodOrder.get(choice - 1),
                                    " (new reduced quanntity): ",
                                    foodQuants.get(choice - 1));
                            System.out.println();

                            //adjust total - assuming user has not deleted items
                            total -= orderPrices.get(choice - 1) * foodQuants.get(choice - 1);
                        } else {
                            //else is not necessary
                            //it's a precautionary validation in case the try/catch fails
                            System.out.println("\nYou didn't order that item! Try again.\n");
                        }//end outer If..Else
                        break;
                    case 2:
                        //check if they've ordered the ID they enter and adjust variables
                        if (foodOrder.contains(foodOrder.get(choice - 1))) {
                            //get input for new quantity
                            System.out.printf("\n%s\n%s\n%s\n",
                                    "You can either enter 0 (zero) to delete the item from your list,",
                                    "or you can enter a positive number that's less than the original",
                                    "quantity to represent the quantity.");
                            System.out.printf("\n%s", "Enter the new quantity of the food you selected: ");

                            //this is caught by outer try/catch
                            int replacement = input.nextInt();
                            //make sure user can't abuse inputs
                            if (replacement > foodQuants.get(choice - 1)) {
                                //if user enters a value higher than original quant
                                System.out.println("\nYou can't remove what you don't have!");
                                break;
                            } else if (foodQuants.get(choice - 1) != 0 && replacement == foodQuants.get(choice - 1)) {
                                //if user enters the amount they already have
                                //is quantity is already 0, don't catch it here so they will be able to remove the item
                                System.out.println("\nYou already have that many "
                                        + foodOrder.get(choice - 1) + "s.");
                                break;
                            } else if (replacement < 0) {
                                //if user enters a negative number
                                System.out.println("\nYou can only have positive quantities of food.");
                                break;
                            } else if (replacement == 0) {
                                //if user enters 0 to delete item from list
                                //ask user first
                                System.out.println("\nAre you sure you want to remove this item (Y or N)? ");
                                //get input, bad input is caught by default or try/catch
                                String remover = input.next();
                                switch (remover) {
                                    case "Y":
                                    case "YES":
                                    case "Yes":
                                    case "yes":
                                    case "y":
                                        System.out.println("\nRemoving item now.");
                                        System.out.println("You will be placed either in the main menu or");
                                        System.out.println("the remove item menu depending on if you have any items");
                                        System.out.println("in your order after removing this one.");

                                        //adjust total and remove all traces of item entry
                                        total -= foodQuants.get(choice - 1) * orderPrices.get(choice - 1);
                                        foodQuants.remove(choice - 1);
                                        orderPrices.remove(choice - 1);
                                        foodOrder.remove(choice - 1);
                                        break;
                                    case "N":
                                    case "NO":
                                    case "No":
                                    case "no":
                                    case "n":
                                        System.out.println("\nOkay. Returning to remove item menu.");
                                        break;
                                    default:
                                        //if user enters anything but y/Y, n/N, or other variations
                                        System.out.println("\nYou need to enter Y or N.");
                                }//end Switch to validate complete removal
                                break;
                            }//end nested If..ElseIf validation

                            //adjust the quantity of the item removed
                            foodQuants.set(choice - 1, replacement);

                            //tell user new quantity
                            System.out.printf("%s%s%s%d", "\n",
                                    foodOrder.get(choice - 1),
                                    " (new reduced quanntity): ",
                                    foodQuants.get(choice - 1));
                            System.out.println();

                            //adjust total - assuming user has not deleted items
                            total -= orderPrices.get(choice - 1) * foodQuants.get(choice - 1);
                        } else {
                            //else is not necessary
                            //it's a precautionary validation in case the try/catch fails
                            System.out.println("\nYou didn't order that item! Try again.\n");
                        }//end outer If..Else
                        break;
                    case 3:
                        //check if they've ordered the ID they enter and adjust variables
                        if (foodOrder.contains(foodOrder.get(choice - 1))) {
                            //get input for new quantity
                            System.out.printf("\n%s\n%s\n%s\n",
                                    "You can either enter 0 (zero) to delete the item from your list,",
                                    "or you can enter a positive number that's less than the original",
                                    "quantity to represent the quantity.");
                            System.out.printf("\n%s", "Enter the new quantity of the food you selected: ");

                            //this is caught by outer try/catch
                            int replacement = input.nextInt();
                            //make sure user can't abuse inputs
                            if (replacement > foodQuants.get(choice - 1)) {
                                //if user enters a value higher than original quant
                                System.out.println("\nYou can't remove what you don't have!");
                                break;
                            } else if (foodQuants.get(choice - 1) != 0 && replacement == foodQuants.get(choice - 1)) {
                                //if user enters the amount they already have
                                //is quantity is already 0, don't catch it here so they will be able to remove the item
                                System.out.println("\nYou already have that many "
                                        + foodOrder.get(choice - 1) + "s.");
                                break;
                            } else if (replacement < 0) {
                                //if user enters a negative number
                                System.out.println("\nYou can only have positive quantities of food.");
                                break;
                            } else if (replacement == 0) {
                                //if user enters 0 to delete item from list
                                //ask user first
                                System.out.println("\nAre you sure you want to remove this item (Y or N)? ");
                                //get input, bad input is caught by default or try/catch
                                String remover = input.next();
                                switch (remover) {
                                    case "Y":
                                    case "YES":
                                    case "Yes":
                                    case "yes":
                                    case "y":
                                        System.out.println("\nRemoving item now.");
                                        System.out.println("You will be placed either in the main menu or");
                                        System.out.println("the remove item menu depending on if you have any items");
                                        System.out.println("in your order after removing this one.");

                                        //adjust total and remove all traces of item entry
                                        total -= foodQuants.get(choice - 1) * orderPrices.get(choice - 1);
                                        foodQuants.remove(choice - 1);
                                        orderPrices.remove(choice - 1);
                                        foodOrder.remove(choice - 1);
                                        break;
                                    case "N":
                                    case "NO":
                                    case "No":
                                    case "no":
                                    case "n":
                                        System.out.println("\nOkay. Returning to remove item menu.");
                                        break;
                                    default:
                                        //if user enters anything but y/Y, n/N, or other variations
                                        System.out.println("\nYou need to enter Y or N.");
                                }//end Switch to validate complete removal
                                break;
                            }//end nested If..ElseIf validation

                            //adjust the quantity of the item removed
                            foodQuants.set(choice - 1, replacement);

                            //tell user new quantity
                            System.out.printf("%s%s%s%d", "\n",
                                    foodOrder.get(choice - 1),
                                    " (new reduced quanntity): ",
                                    foodQuants.get(choice - 1));
                            System.out.println();

                            //adjust total - assuming user has not deleted items
                            total -= orderPrices.get(choice - 1) * foodQuants.get(choice - 1);
                        } else {
                            //else is not necessary
                            //it's a precautionary validation in case the try/catch fails
                            System.out.println("\nYou didn't order that item! Try again.\n");
                        }//end outer If..Else
                        break;
                    case 4:
                        //check if they've ordered the ID they enter and adjust variables
                        if (foodOrder.contains(foodOrder.get(choice - 1))) {
                            //get input for new quantity
                            System.out.printf("\n%s\n%s\n%s\n",
                                    "You can either enter 0 (zero) to delete the item from your list,",
                                    "or you can enter a positive number that's less than the original",
                                    "quantity to represent the quantity.");
                            System.out.printf("\n%s", "Enter the new quantity of the food you selected: ");

                            //this is caught by outer try/catch
                            int replacement = input.nextInt();
                            //make sure user can't abuse inputs
                            if (replacement > foodQuants.get(choice - 1)) {
                                //if user enters a value higher than original quant
                                System.out.println("\nYou can't remove what you don't have!");
                                break;
                            } else if (foodQuants.get(choice - 1) != 0 && replacement == foodQuants.get(choice - 1)) {
                                //if user enters the amount they already have
                                //is quantity is already 0, don't catch it here so they will be able to remove the item
                                System.out.println("\nYou already have that many "
                                        + foodOrder.get(choice - 1) + "s.");
                                break;
                            } else if (replacement < 0) {
                                //if user enters a negative number
                                System.out.println("\nYou can only have positive quantities of food.");
                                break;
                            } else if (replacement == 0) {
                                //if user enters 0 to delete item from list
                                //ask user first
                                System.out.println("\nAre you sure you want to remove this item (Y or N)? ");
                                //get input, bad input is caught by default or try/catch
                                String remover = input.next();
                                switch (remover) {
                                    case "Y":
                                    case "YES":
                                    case "Yes":
                                    case "yes":
                                    case "y":
                                        System.out.println("\nRemoving item now.");
                                        System.out.println("You will be placed either in the main menu or");
                                        System.out.println("the remove item menu depending on if you have any items");
                                        System.out.println("in your order after removing this one.");

                                        //adjust total and remove all traces of item entry
                                        total -= foodQuants.get(choice - 1) * orderPrices.get(choice - 1);
                                        foodQuants.remove(choice - 1);
                                        orderPrices.remove(choice - 1);
                                        foodOrder.remove(choice - 1);
                                        break;
                                    case "N":
                                    case "NO":
                                    case "No":
                                    case "no":
                                    case "n":
                                        System.out.println("\nOkay. Returning to remove item menu.");
                                        break;
                                    default:
                                        //if user enters anything but y/Y, n/N, or other variations
                                        System.out.println("\nYou need to enter Y or N.");
                                }//end Switch to validate complete removal
                                break;
                            }//end nested If..ElseIf validation

                            //adjust the quantity of the item removed
                            foodQuants.set(choice - 1, replacement);

                            //tell user new quantity
                            System.out.printf("%s%s%s%d", "\n",
                                    foodOrder.get(choice - 1),
                                    " (new reduced quanntity): ",
                                    foodQuants.get(choice - 1));
                            System.out.println();

                            //adjust total - assuming user has not deleted items
                            total -= orderPrices.get(choice - 1) * foodQuants.get(choice - 1);
                        } else {
                            //else is not necessary
                            //it's a precautionary validation in case the try/catch fails
                            System.out.println("\nYou didn't order that item! Try again.\n");
                        }//end outer If..Else
                        break;
                    default:
                        //default is also a precautionary validation
                        choice = -1;
                        System.out.println("\nYou need to enter a choice on the list!");
                }//end Switch
            } catch (Exception ex) {
                System.out.println("\nError in your input.");
                System.out.println("You need to enter a choice from the list!");

                //clears scanner buffer for string inputs
                input.nextLine();
            }//end Try/Catch error check
        } while (choice != 0);
    }//end removeFood

    public static void checkout() {
        //flag is for the review method
        flag = false;
        do {
            //display users order based on value of user input
            //make sure choice isn't 0 to prevent returning to methods unexpectedly
            if (choice > 0) {
                review(flag);
                double checkout = total + (total * tax);
                System.out.printf("%s%.2f", "Tax:\t\t\t\t\t$", (total * tax));
                System.out.printf("\n%s%.2f\n", "Checkout Total:\t\t\t\t$", checkout);

                //if choice <= 0 after review, returns control to last method
                if (choice <= 0) {
                    return;
                }//end Nested If
            }//end If

            //tell user to exit this menu
            System.out.print("\nThere's nothing more you can do on this menu, please exit to the main menu.");
            System.out.print("\nRemember to enter 0 when in the main menu to quit the program.");
            System.out.print("\nEnter 0 (zero) to go back to the main menu: ");

            //error checking
            try {
                choice = input.nextInt();

                if (choice != 0) {
                    System.out.println("\nYou need to enter 0 (zero)!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("\nError in your input.");
                System.out.println("You need to enter 0 (zero)!");

                //reset buffer
                input.nextLine();
            }//end Try/Catch error check
        } while (choice != 0);
        lineBreak();
        choice = -1;
    }//end checkout

    public static void lineBreak() {
        System.out.println("\n====================================="
                + "=============================================");
    }//end lineBreak
}//end Class
