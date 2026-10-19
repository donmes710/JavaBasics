import java.util.Scanner;

public class throwException2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the amount to withdraw :");
        int withdrawal=sc.nextInt();
        int amount=5000;

        try{
            if(amount<withdrawal){
                throw new IllegalArgumentException("Insufficient Balance");
            }
            amount-=withdrawal;
            System.out.println("Withdrawal Successfull");
            System.out.println("Remaining Balance : "+amount);

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Program completed");
    }
    
}
