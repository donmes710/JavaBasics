class Engine{
    void start(){
        System.out.println("Engine is starting");
    }
}

class car{
    private Engine engine;
    car(){
        this.engine=new Engine();
    }
    void drive(){
        engine.start();
        System.out.println("car is moving");
    }
}

public class relationships{
    public static void main(String[] args){
        car bmw=new car();
        bmw.drive();
    }
}