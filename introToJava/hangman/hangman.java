/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
import java.util.Formatter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Hangman {

    //global random number generator
    public static Random rand = new Random();
    
    //global list to hold wrong guesses
    public static ArrayList<String> misses = new ArrayList<String>();
    
    //global list to hold the gameWord and underscores
    public static ArrayList<String> word = new ArrayList<String>();
    
    //global list to hold contenct of score.txt file, 1 line in file per element in list
    public static ArrayList<String> leaderBoard = new ArrayList<String>();
    
    //second global list to hold scores, but not 1 line per element
    //this is used to compare scores between users, since the score position is the same throughout the file
    public static ArrayList<String> scoreFileChars = new ArrayList<String>();
    
    //global int to hold num guesses that were wrong
    public static int missCount = 0;
    
    //global variable to hold number of guesses total
    public static int guesses = 0;
    
    //global variable to hold the users score
    public static int score = 0;
    
    //global flag to control score checking in leaderboards, another to control writing to file
    //and another to tell a catch block not to print
    public static boolean contFlag = true, 
                          catchFlag = true, 
                          writeFlag = false;

    public static void main(String[] args) {
        //variables that needed to be initialized with a wider scope
        Scanner input = new Scanner(System.in);
        String gameWord = "", userName = "", continuePlaying = "", guess = "";
        String concatWord = "str unused";

        //inform user and get info
        System.out.printf("%s\n%s\n%s\n\n%s\n%s\n%s\n\t%s\n\t%s\n\t%s\n\t%s\n",
                "User Info: This is going to be a game of hangman,",
                "you'll have 20 tries to guess the correct word and every wrong",
                "guess will be displayed on the screen.",
                "There is a scoreboard, so if your score beats one of the high",
                "scores you will see your name on the board!",
                "You get points based on the number of guesses you get wrong:",
                "3 point for not missing a single letter,",
                "2 points for missing at most 4 letters,",
                "and 1 point for missing between 4 and 7 tries.",
                "Unfortunately, if you use more than 7 tries you get no points for that round.");

        System.out.println("\nRemember: The rule is that you can onnly enter one LETTER at a time.");

        System.out.printf("\n\n%s\n%s\n%s\n\n%s",
                "In case your score does manage to beat one of the high scores,",
                "you're going to need to enter a username to display on the board.",
                "Your username CANNOT have more than 4 characters.",
                "Enter your username here: ");
        userName = input.nextLine();

        //if username is longer than 4 characters, redo input
        while (userName.length() > 4) {
            System.out.printf("\n\n%s\n%s\n%s\n\n%s",
                    "In case your score does manage to beat one of the high scores,",
                    "you're going to need to enter a username to display on the board.",
                    "Your username CANNOT have more than 4 characters.",
                    "Enter your username here: ");
            userName = input.nextLine();
        }//end While

        //if username is less than 4 characters, add spaces
        if (userName.length() < 4) {
            userName = String.format("%-4s", userName);
        }//end If
        do {
            //choose a random word from word list in data.txt
            boolean flag = false;
            do {
                try {
                    Scanner dataRead = new Scanner(new File("data.txt"));
                    //if file is found, create and fill list with data in file
                    ArrayList<String> words = new ArrayList<String>();
                    while (dataRead.hasNext()) {
                        words.add(dataRead.next());
                    }//end While

                    //once list has words, choose a random one, can access all words in list
                    int indexOfWord = rand.nextInt(words.size());
                    gameWord = words.get(indexOfWord);

                    //fill word list with _ to initialize length, _ will be replaced with letters
                    for (int i = 0; i < gameWord.length(); i++) {
                        word.add("_");
                    }//end For

                    //no longer need dateRead error checking
                    dataRead.close();
                } catch (Exception ex) {
                    System.out.println("\nFile not found.");
                }//end Try-catch
            } while (flag);

            //print leader board
            printLeaderBoard();

            //read scores info a second time to a new list that stores each object
            //in the score file as an element, used to edit scores and writes updated
            //leader board to the score file
            try {
                //open file for reading
                Scanner scoreRead = new Scanner(new File("score.txt"));

                //fill scoreFileChars list with each element being a char or string (1, |, 0, |, name,...)
                while (scoreRead.hasNext()) {
                    scoreFileChars.add(scoreRead.next());
                }//end While

                //close scoreRead for now
                scoreRead.close();
            } catch (Exception e) {
                System.out.println("\nThere was an error trying to import the leader board.");
            }//end Try..Catch

            //game UI and input handling
            do {
                //reset concatWord after each iteration if it's not ""
                if (concatWord != "") {
                    concatWord = "";
                } else {
                    break;
                }//end If..else

                //after word is chosen, print underlines (equal to length of word)
                lineBreak();
                printWord();

                //output the users misses
                System.out.print("\nMisses: ");
                //print contents of misses list unless it's empty
                if (misses.isEmpty() && guesses == 0) {
                    System.out.println("Nothing guessed yet.");
                } else {
                    for (String i : misses) {
                        System.out.print(i + " ");
                    }//end For
                    System.out.println();
                }//end If..else

                //get user to guess letter
                System.out.print("\nGuess: ");
                try {
                    guess = input.next();
                    ++guesses;

                    //validate that user entered one char
                    if ((guess.length() == 1) && (guess.matches(".*\\d.*") == false)) {
                        //check if input is in word once, add to missed list if it is not
                        if (gameWord.contains(guess)) {
                            //if gameWord contains the guess once, replace all _ with letter
                            //indexOf returns the first occurance of the letter ONLY
                            for (int index = gameWord.indexOf(guess); index >= 0; index = gameWord.indexOf(guess, index + 1)) {
                                word.set(index, guess);
                            }//end For
                        } else {
                            //if guessed letter isn't in list then add it to misses list
                            misses.add(guess);
                            missCount++;
                        }//end nested If..else
                    } else {
                        //if input is longer than one char or contains a digit tell user and add miss
                        System.out.println("\nYou know the rules... You can only enter one letter at a time!");
                        System.out.println("This DOES count as a miss.");
                        missCount++;
                        misses.add(guess);

                        //set this to false so the catch doesn't run
                        catchFlag = false;
                    }//end If..else
                } catch (Exception e) {
                    //if catchFlag is true then print this block, prevents redundancy
                    if (catchFlag == true) {
                        System.out.println("\nYou can only enter one letter at a time!");
                        System.out.println("This DOES count as a miss.");
                        missCount++;
                        misses.add(guess);
                    }//end If
                }//end Try/catch

                //convert list of letters to string in order to compare it to gameWord
                for (String i : word) {
                    concatWord += i;
                }//end For
            } while ((missCount < 20) && (concatWord.equals(gameWord) == false));

            //print the word one last time for the user
            lineBreak();
            printWord();

            //determine score
            if (missCount == 0) {
                score += 3;
            } else if (missCount <= 4) {
                score += 2;
            } else if (missCount <= 7 && missCount > 4) {
                score += 1;
            }//end If..elseif

            //tell user if they've won
            lineBreak();
            if (concatWord.equals(gameWord)) {
                System.out.println("\nCongratulations! You guessed the word!");
            } else {
                System.out.println("\nGame over! You've run out of tries.");
            }//end If..else

            //tell user their score
            System.out.println("\nYour current score is: " + score);

            //convert integer score to String for comparisons
            String points = String.valueOf(score);

            //compare user score with leader board scores and replace if users score is larger
            for (int i = 0; i < scoreFileChars.size(); i += 5) {
                //first score index needs an offset to be checked by loop
                if (i == 0) {
                    //compare score with list.get(2) - 2 is offset
                    int comparisonValue = points.compareToIgnoreCase(scoreFileChars.get(2));

                    //this has to be comparisonValue >= 0 because compareToIgnoreCase will return
                    //points value as a positive if it's greater than the argument, 0 if they're equal
                    //and points value as a negative if it's smaller
                    if (comparisonValue >= 0) {
                        //leader score is less than user score so replace sscores and name
                        scoreFileChars.set(2, points);
                        scoreFileChars.set(4, userName);

                        //tell user
                        System.out.println("\nYou now have the highest score I've ever seen!!");

                        //flag to tell the program not to check positions 2-5
                        contFlag = false;

                        //tell program to write to score file
                        writeFlag = true;
                    }//end If

                    //add an offset to i since the second score is stores at index 7 of scoreFileChars
                    i += 7;
                }//end If for first score position

                //check positions 2-5 on leader board if first posittion isn't beat
                int comparisonValue = points.compareToIgnoreCase(scoreFileChars.get(i));
                if ((comparisonValue >= 0) && (contFlag == true)) {
                    //leader score is greater than user score so replace scores and name
                    scoreFileChars.set(i, points);
                    scoreFileChars.set((i + 2), userName);

                    //tell user
                    System.out.println("\nWow! You're now number " + ((i / 5) + 1) + " on the leader board!");

                    //if a score on the board is found to be less, set continuation flag to false
                    contFlag = false;

                    //tell program to write to score file
                    writeFlag = true;

                    //once element is found that's replacable, no need to loop further so break
                    break;
                }//end If
            }//end For

            //use formatter to write new leader board to the score file
            //have to subtract 5 fromk limit because it'll go out of bounds
            //and each line in the file equates to 5 elements
            if (writeFlag) {
                try {
                    Formatter fileWriter = new Formatter("score.txt");

                    //put info in file
                    for (int k = 0; k <= scoreFileChars.size() - 5; k += 5) {
                        //print info to file
                        fileWriter.format("%s  |   %s   |   %s\n",
                                scoreFileChars.get(k),
                                scoreFileChars.get(k + 2),
                                scoreFileChars.get(k + 4));
                    }//end For

                    //close fileWriter
                    fileWriter.close();
                } catch (Exception e) {
                    //warn user of error opening file
                    System.out.println("\nError! Threr was a problem saving the scores!");
                }//end Try..catch
            }//end If

            //print leader board after score check
            lineBreak();
            printLeaderBoard();

            //ask user if they want to continue playing
            System.out.print("\nWould you like to keep playing (Y or N)? ");
            try {
                continuePlaying = input.next();
                switch (continuePlaying.toLowerCase()) {
                    case "yes":
                    case "y":
                        //keep playing game, start over.
                        System.out.println("\nStarting the game over, your score will not be cleared.");
                        lineBreak();

                        //reset variables
                        guesses = 0;
                        missCount = 0;
                        contFlag = true;
                        writeFlag = false;
                        catchFlag = true;
                        misses.clear();
                        word.clear();
                        leaderBoard.clear();
                        scoreFileChars.clear();
                        break;
                    case "no":
                    case "n":
                        System.out.println("\nOkay. Quitting the game now.");
                        break;
                    default:
                        //if user enters anything but y/Y, n/N, or other variations
                        System.out.println("\nYou need to enter Y or N.");
                }//end Switch
            } catch (Exception e) {
                //warn user that there was an error in their input
                System.out.println("\nThere was an error, make sure you only enter Y or N.");
            }//end Try/catch
        } while (contFlag == true); //if you choose to play again, contFlag is true due to variable reset
    }//end Main

    public static void printLeaderBoard() {
        //print leader board to screen
        System.out.println("\n\tHangman Game");
        System.out.println("      Top Five Scores:");
        System.out.println("\nRank | Score | Name");
        System.out.println("------------------------");
        //read score.txt and output data
        try {
            //open file for reading
            Scanner scoreRead = new Scanner(new File("score.txt"));

            //if scores list is empty, fill it with file data
            //else clear it and refill it with new data
            if (leaderBoard.isEmpty()) {
                //fill scores list and output contents
                int count = 0;
                while (scoreRead.hasNextLine()) {
                    leaderBoard.add(scoreRead.nextLine());
                    System.out.println("  " + leaderBoard.get(count));
                    count++;
                }//end While
            } else {
                //clear list
                leaderBoard.clear();

                //fill scores list and output contents
                int count = 0;
                while (scoreRead.hasNextLine()) {
                    leaderBoard.add(scoreRead.nextLine());
                    System.out.println("  " + leaderBoard.get(count));
                    count++;
                }//end While
            }//end If..else

            //close scoreRead for now, needs to be opened later if user score breaks a leader score
            scoreRead.close();
        } catch (Exception e) {
            System.out.println("\nThere was an error trying to read the leader board.");
        }//end Try..Catch
    }//end printLeaderBoard

    public static void printWord() {
        System.out.print("\nWord: ");
        for (String h : word) {
            System.out.print(h + " ");
        }//end For
        System.out.println();
    }//end printWord

    public static void lineBreak() {
        System.out.println("\n====================================="
                + "=============================================");
    }//end lineBreak
}//end Class
