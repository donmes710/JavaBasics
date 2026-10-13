public class exception {
    public static void main(String[] args) {
        int a =10;
        int b=0;
        
        try{
            int res=a/b;
            System.out.println("result : "+res);
        }catch(ArithmeticException e){
            System.out.println("Cannot Divided by 0");
        }
    }
    
}
