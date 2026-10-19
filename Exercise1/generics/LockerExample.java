
class Locker<T> {
    private T item;

    // Store an item
    void put(T item) {
        this.item = item;
    }

    // Retrieve the item
    T get() {
        return item;
    }
}

public class LockerExample {
    public static void main(String[] args) {

        Locker<String> bookLocker = new Locker<>();
        bookLocker.put("Java Book");
        System.out.println("Locker has: " + bookLocker.get());

        Locker<Integer> codeLocker = new Locker<>();
        codeLocker.put(1234);
        System.out.println("Locker has: " + codeLocker.get());
    }
}
