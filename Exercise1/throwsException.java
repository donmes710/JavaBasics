import java.io.FileReader;
import java.io.IOException;

public class throwsException {

    static void readFile() throws IOException{
        FileReader file=new FileReader("data.txt");
        System.out.println("file Opened");
    }
    public static void main(String[] args) {
        try{
            readFile();
        }catch(IOException e){
            System.out.println("No file found");
        }
    }
}
