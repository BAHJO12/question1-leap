

package com.mycompany.leapmonth;

import java.util.InputMismatchException;
import java.util.Scanner;


public class LeapMonth {

    
    // Method to determine if a given year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    // Method to check if a given month in a given year is a leap month
    // In the Gregorian calendar, only February (month 2) can be a leap month
    public static boolean isLeapMonth(int year, int month) {
        return (month == 2) && isLeapYear(year);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = 0;
        int month = 0;

        // Prompt user for the year with validation
        while (true) {
            System.out.print("Enter year: ");
            try {
                year = scanner.nextInt();
                break; // Exit loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the year.");
                scanner.next(); // Clear invalid input
            }
        }

        // Prompt user for the month with validation
        while (true) {
            System.out.print("Enter month (1-12): ");
            try {
                month = scanner.nextInt();
                if (month >= 1 && month <= 12) {
                    break; // Exit loop if input is valid
                } else {
                    System.out.println("Invalid input. Please enter a month between 1 and 12.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the month.");
                scanner.next(); // Clear invalid input
            }
        }

        // Check if the provided month is a leap month
        boolean result = isLeapMonth(year, month);

        // Display the result
        if (result) {
            System.out.println("The month " + month + " in year " + year + " is a leap month.");
        } else {
            System.out.println("The month " + month + " in year " + year + " is not a leap month.");
        }

        // Close the scanner
        scanner.close();
    }
}
