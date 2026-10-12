
import java.util.*;

public class  greatestNumber {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the First number :");
        int num1=sc.nextInt();
        System.out.print("Enter the Second Number :");
        int num2=sc.nextInt();
        BiggestNumber(num1, num2);

    }
    static void BiggestNumber(int num1,int num2){
        if(num1>num2){
            System.out.println(num1 +" is larger than "+num2);
        }else if(num1<num2){
            System.out.println(num2 +" is larger than "+num1);      
        }else{
            System.out.println("Both are Equal");
        }
    }
    
}
