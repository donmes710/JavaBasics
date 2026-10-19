
import java.util.Scanner;

public class AreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1: Triangle");
        System.out.println("2: Square");
        System.out.println("3: Rectangle");
        System.out.print("Enter Your Choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the breadth in cm: ");
                int breadth = sc.nextInt();

                System.out.print("Enter the height in cm: ");
                int height = sc.nextInt();

                double triangleArea = (breadth * height) / 2.0;
                System.out.println("Area: " + triangleArea + " sq. cm");
                break;

            case 2:
                System.out.print("Enter the side in cm: ");
                int side = sc.nextInt();

                int squareArea = side * side;
                System.out.println("Area: " + squareArea + " sq. cm");
                break;

            case 3:
                System.out.print("Enter the length in cm: ");
                int length = sc.nextInt();

                System.out.print("Enter the breadth in cm: ");
                int rectangleBreadth = sc.nextInt();

                int rectangleArea = length * rectangleBreadth;
                System.out.println("Area: " + rectangleArea + " sq. cm");
                break;

            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
