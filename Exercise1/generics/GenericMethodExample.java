
class Util {

    // Generic method: prints a value twice
    static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }

    // Generic method: returns the second argument
    static <T> T firstOf(T a, T b) {
        return b;
    }
}

public class GenericMethodExample {
    public static void main(String[] args) {

        Util.printTwice(100);

        System.out.println(Util.firstOf("Hi", "Hello"));
    }
}
