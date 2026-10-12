

import java.util.*;

public class sumOfOddNumbers {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the nth Number:");
        int n =sc.nextInt();
     
        sumOfOddNumbers(n);
    }
    static void sumOfOddNumbers(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            if(i%2!=0){
                sum+=i;
            }
        }
        System.out.println("The sum of odd numbers from 1 to " + n + "is :" +sum);
    }
    
}
