import java.util.*;

class car{
    String Brand;
    int speed;
    String color;

    car(String Brand,int speed,String color){
        this.Brand=Brand;
        this.speed=speed;
        this.color=color;
    }

    void displayinfo(){
        System.out.println(Brand+"\n"+color+"\n"+speed);
    }

    void accelerated(int incr){
        int or_speed=speed;
        speed+=incr;

        System.out.println("Original Speed :" +or_speed);
        System.out.println(Brand +"Accelerated by "+speed+" km/h");
    }
}

public class constructors {
    public static void main(String[] args) {
        car c1=new car("BMW",120,"Black");
        c1.displayinfo();
        c1.accelerated(60);

    }
    
}
