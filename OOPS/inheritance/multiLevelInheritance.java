class device {
    void poweron() {
        System.out.println("Device powered On");
    }
}

class phone extends device {
    void makecall() {
        System.out.println("Calling the number.....");
    }
}

class dabbaphone extends phone {
    void sendmessage() {
        System.out.println("Sending message.....");
    }
}

public class multiLevelInheritance {
    public static void main(String[] args) {
        dabbaphone myPhone = new dabbaphone();
        myPhone.poweron();
        myPhone.makecall();
        myPhone.sendmessage();
    }
}
