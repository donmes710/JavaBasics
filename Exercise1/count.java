

import java.util.*;

public class count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int positive = 0;
        int negative = 0;
        int zero = 0;
        char choice;
        do {
            System.out.print("Enter a number: ");
            int num = sc.nextInt();
            if (num > 0) {
                positive++;                
            } else if (num < 0) {
                negative++;
            } else {
                zero++;
            }

            System.out.print("Do you want to enter again? (y/n): ");
            choice =sc.next().toLowerCase().charAt(0);
        } while (choice == 'y');
        System.out.println("Positive numbers: " + positive);
        System.out.println("Negative numbers: " + negative);
        System.out.println("Zeros: " + zero);
    }
}