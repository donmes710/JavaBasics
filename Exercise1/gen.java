
class Box<T> {
    T item;

    void set(T item) {
        this.item = item;
    }

    T get() {
        return item;
    }
}

class gen {
    public static void main(String[] args) {

        // Example 1: Box with String
        // Box<String> box = new Box<>();
        // box.set("hello");
        // String s = box.get();
        // System.out.println(s);

        // Example 2: Box with Integer
        Box<Integer> box = new Box<>();
        box.set(42);

        int s = box.get();
        System.out.println(s);
    }
}
