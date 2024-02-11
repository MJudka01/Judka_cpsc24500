/*
Marek Judka
CPSC 24500-001
Assignment 3: Rock, Paper, and Scissors
2-23-24
 */

import java.util.Scanner;
import java.util.Random;

public class rockPaperScissors
{
    //Method to get the users choice
    public static int userChoice ()
    {
        Scanner scanner = new Scanner(System.in);
        int uPick = 0;
        //do while loop for user choice and to repeat if user enters wrong selection
        do
        {
            System.out.println("Enter your choice: (1 - Rock, 2 - Paper, 3 - Scissors)");
            uPick = scanner.nextInt();

            if (uPick < 0 || uPick > 3) // invalid input checker
            {
                System.out.println("Invalid input, please select 1, 2, or 3");
                System.out.println(" ");
            }
        }
        while (uPick < 0 || uPick > 3);
        return uPick;
    }

    //method to randmoly generate the comp choice
    public static int compChoice () //creating the randomly generated computer choice
    {
        Random rndchoice = new Random();
        return rndchoice.nextInt(3) + 1; // make the random number fall within the bounds of 1-3
    }

    //Method to display the randomly generated computer choice
    public static void compChoiceDisplayed (int compChoice)
    {
        System.out.println(" ");
        System.out.println("The computer chose: ");

        //switch to go through all the possible options and to take the return of the compChoice method
        switch (compChoice)
        {
            case 1: System.out.println("1 - Rock");
                break;
            case 2: System.out.println("2 - Paper");
                break;
            case 3: System.out.println("3 - Scissors");
                break;
        }

    }

    //method to figure out who the winner is, method takes both the user and comp choice paramaters to determine who won
    public static void winner (int userChoice, int compChoice)
    {
        //else if statements to go through all the possible win/loss/tie scenarios
        if (userChoice == compChoice)
        {
            System.out.println(" ");
            System.out.println("The game ended in a tie, better luck next time.");
            System.out.println(" ");
        }
        else if ( userChoice == 1 && compChoice == 3)
        {
            System.out.println(" ");
            System.out.println("Congratulations, you have won!!");
            System.out.println(" ");
        }
        else if ( userChoice == 2 && compChoice == 1)
        {
            System.out.println(" ");
            System.out.println("Congratulations, you have won!!");
            System.out.println(" ");
        }
        else if ( userChoice == 3 && compChoice == 2)
        {
            System.out.println(" ");
            System.out.println("Congratulations, you have won!!");
            System.out.println(" ");
        }
        else
        {
            System.out.println("Womp Womp, the computer has won :(, better luck next time!");
            System.out.println(" ");
        }
    }



    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        char again;

        //rules of the game
        System.out.println("Welcome to the game of Rock, Paper, Scissors!");
        System.out.println("The rules are as followed: ");
        System.out.println("1 - Rock");
        System.out.println("2 - Paper");
        System.out.println("3 - Scissors");
        System.out.println(" ");
        System.out.println("Lets Play!");

        //do while loop to keep the game repeating if the player wants to or kill it if they dont
        do
        {
            int userChoice = userChoice();

            int compChoice = compChoice();

            compChoiceDisplayed(compChoice);

            winner(userChoice, compChoice);

            System.out.println("Do you want to play again???");
            System.out.println("(Y - yes / N - no)");
            again = scanner.next().charAt(0);
        }
        while (again == 'Y' || again == 'y');

        System.out.println("Thank you for playing, come play again soon!");

    }
}
