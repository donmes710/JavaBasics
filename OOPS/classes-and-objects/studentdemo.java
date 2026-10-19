class student{
    String name;
    static String college="IIT Chennai";

    student(String name){
        this.name=name;
    }
    void stucol(){
        System.out.println(name +"studies in" + college);
    }
}


public class studentdemo {
    public static void main(String[] args) {
        student s1=new student("Mohamed Rabin");
        student s2=new student("Adarsh");
        s1.stucol();
        s2.stucol();
    }
    
}
