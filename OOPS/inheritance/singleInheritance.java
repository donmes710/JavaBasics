class animal{
    void eat(){
        System.out.println("This animal eats food");
    }
}

class Dog extends animal{
    void bark(){
        System.out.println("The Dog barks");

    }
}
public class singleInheritance{
    public static void main(String[] args) {
        Dog myDog=new Dog();
        myDog.bark();
        myDog.eat();
    }    
}
