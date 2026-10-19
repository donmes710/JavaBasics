class address{
    String city;
    String state;
    int pincode;

    address(String city,String state,int pincode){
        this.city=city;
        this.state=state;
        this.pincode=pincode;
    }
    void displayAddress(){
        System.out.println(city +" ,"+ state +" ,"+pincode+ " ,");
    }
}
class student{
    String name;
    int rollNo;
    address Address;

    student(String name,int rollNo,address Address){
        this.name=name;
        this.rollNo=rollNo;
        this.Address=Address;
    }
    void displayprofile(){
        System.out.println("student :"+name+ "\nrollNo :"+rollNo+ "\nLives at");
        Address.displayAddress();
    }
}
public class hasaRelationship{
    public static void main(String[] args) {
        address a1=new address("Malappuram", "Kerala", 101);
        student s1=new student("Mohamed Rabin",21,a1);
        s1.displayprofile();
    }
}
