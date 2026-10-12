

import java.util.*;

public class gcd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        int result = gcd(num1, num2);
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + result);
    }
    static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }
        return num1;
    }
}