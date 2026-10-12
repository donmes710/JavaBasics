class battery{
    int batteryCapacity;

    battery(int batterCapacity){
        this.batteryCapacity=batteryCapacity;
    }
    void drain(){
        System.out.println("Battery used" +"\nCapacity Remaining :"+(batteryCapacity-100)+"mah");
    }
}
class camera{
    int pix;
    camera(int pix){
        this.pix=pix;
    }
    void takePhoto(){
        System.out.println("click...Captured a photo with"+pix+"sensor");
    }
}

class mobile{
    String brand;
    battery Battery;
    camera Camera;

    mobile(String brand,battery Battery,camera Camera){
        this.brand=brand;
        this.Battery=Battery;
        this.Camera=Camera;
    }
    void snapPicture(){
        System.out.println(brand+"is active");
        Camera.takePhoto();
        Battery.drain();
    }
}
public class phone {
    public static void main(String[] args) {
        battery b1=new battery(1000);
        camera c1=new camera(750);
        mobile m1=new mobile("Nothing", b1, c1);
        m1.snapPicture();
        
    }
}
