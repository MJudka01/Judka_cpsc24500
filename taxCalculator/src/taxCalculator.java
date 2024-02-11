/*
Marek Judka
CPSC 24500-001
Assignment 2: Tax Calculator
2-11-24
 */

import java.util.Scanner;

public class taxCalculator
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double tax = 0;
        double income = 0;
        String name;
        boolean valid = true;

        //User inputting their name
        System.out.print("Enter name: ");
        name = sc.next();
        System.out.println(" ");

        /*While loop to ask user to input valid input if they
        originally enter invalid input
         */
        while (valid)
        {
            System.out.print("Enter income: ");
            income = sc.nextDouble();
            System.out.println(" ");
            if (income < 0)
            {
                System.out.println("Invalid Input!!!");
                System.out.println("Please Enter Correct Input");
            }
            else
            {
                valid = false;
            }
        }

        //if statements to calculate income tax based on users income input
        if (income < 4000)
        {
            tax = 0;
        }
        else if (income <= 5500)
        {
            tax += (income - 4000) * 0.10;
        }
        else if (income <= 33500)
        {
            tax = 150;
            tax += (income - 5500) * 0.20;
        }
        else
        {
            tax = 5750;
            tax += (income - 33500) * 0.40;
        }
        System.out.println(name + " has to pay $" + tax + " tax.");
    }
}