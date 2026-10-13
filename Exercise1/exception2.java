public class exception2 {
    public static void main(String[] args) {
        int a =10;
        int b=0;      
        
        try{
            int[] numbers={10,2,4};
            System.out.println(numbers[7]);
        }catch(ArrayIndexOutOfBoundsException arr){
            System.out.println("Index Number not found");
        }
        try{
            int result=a/b;
            System.out.println("result :"+result);
        }
        
        catch(ArithmeticException e){
            System.out.println("cannot divided by zero");
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Finally block Executed");
            
        }
    }
    
}
