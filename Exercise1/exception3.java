import java.util.*;

public class exception3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first number : ");
        int num1=sc.nextInt();
        System.out.print("Enter the second number :");
        int num2=sc.nextInt();

        try{
            int result=num1 /num2;
            if(num2 == 0){
                throw new ArithmeticException("Cannot divided by zero");
            }
            System.out.println("Result :"+result);
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Program completed");
        }
    }
    

    
}
