import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class dateTime4 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter a date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        LocalDate date;

        try {
            date = LocalDate.parse(input);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date! Use yyyy-MM-dd format.");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== Date Explorer =====");
            System.out.println("1. Display Month");
            System.out.println("2. Display Year");
            System.out.println("3. Display Day of Week");
            System.out.println("4. Look Back by Months");
            System.out.println("5. Check Leap Year");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayMonth(date);
                    break;

                case 2:
                    displayYear(date);
                    break;

                case 3:
                    displayDayOfWeek(date);
                    break;

                case 4:
                    lookBackMonths(date);
                    break;

                case 5:
                    checkLeapYear(date);
                    break;

                case 6:
                    System.out.println("Thank you for using Date Explorer!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    // Display month
    public static void displayMonth(LocalDate date) {
        Month month = date.getMonth();
        System.out.println("Month: " + month);
    }

    // Display year
    public static void displayYear(LocalDate date) {
        int year = date.getYear();
        System.out.println("Year: " + year);
    }

    // Display day of week
    public static void displayDayOfWeek(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        System.out.println("Day of Week: " + day);
    }

    // Look back by a specified number of months
    public static void lookBackMonths(LocalDate date) {
        System.out.print("Enter number of months to look back: ");
        int months = sc.nextInt();

        if (months < 0) {
            System.out.println("Please enter a non-negative number.");
        } else {
            LocalDate previousDate = date.minusMonths(months);
            System.out.println("Date " + months
                    + " months ago: " + previousDate);
        }
    }

    // Check leap year
    public static void checkLeapYear(LocalDate date) {
        int year = date.getYear();

        if (date.isLeapYear()) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
}