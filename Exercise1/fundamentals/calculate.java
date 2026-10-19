abstract class shape{
    private String color;
    void setColor(String color){
        this.color=color;
    }
    String getColor(){
        return color;
    }
    abstract double calculateArea();
}
class circle extends shape{
    double radius;
    circle(double radius){
        this.radius=radius;
    }
    @Override 
    double calculateArea(){
        return (3.14)*radius*radius;
    }
}

class rectangle extends shape{
    double length;
    double breadth;

    rectangle(double length,double breadth){
        this.length=length;
        this.breadth=breadth;
    }
    @Override 
    double calculateArea(){
        return length*breadth;
    }
}

public class calculate {
    public static void main(String[] args) {
        shape c = new circle(0.5);
        shape r = new rectangle(12, 6);

        c.setColor("Orange");
        r.setColor("Blue");

        System.out.printf("%s circle area is %.2f",
                c.getColor(), c.calculateArea());

        System.out.println("\n");

        System.out.printf("%s rectangle area is %.2f",
                r.getColor(), r.calculateArea());
        
    }
    
}
