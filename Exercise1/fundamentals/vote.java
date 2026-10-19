

import java.util.*;
public class vote {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your age :");
        int age=sc.nextInt();
        System.out.println(vote(age));
    }
    public static String vote(int age){
        if(age>=18){
            return "Eligible for Vote";

        }else{
            return "not Eligible for vote";
        }
    }
    
}
