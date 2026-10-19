
import java.util.*;

public class circumference {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the radius of the circle :");
        double r=sc.nextDouble();


        System.out.print("The circumference of the circle is :"+ circumference(r));


    }
    public static double circumference(double r1){
        return 2 * 3.14 * r1;
    }
    
}
