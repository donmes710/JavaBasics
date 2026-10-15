
 // Multi type parameters
class Pair<K, V> {
    private K key;
    private V value;

    // Constructor
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getter for key
    K getKey() {
        return key;
    }

    // Getter for value
    V getValue() {
        return value;
    }
}

public class multiParaGen {
    public static void main(String[] args) {

        Pair<String, Integer> p = new Pair<>("Age", 25);

        String k = p.getKey();
        Integer v = p.getValue();

        System.out.println(k + ": " + v);
    }
}
