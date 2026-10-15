
class Pair<K, V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }
}

public class GenericPairExample {
    public static void main(String[] args) {
        Pair<String, Integer> p = new Pair<>("Age", 22);

        String k = p.getKey();
        Integer v = p.getValue();

        System.out.println(k + ":" + v);
    }
}

/*
class PairWithoutGenerics {
    private Object key;
    private Object value;

    PairWithoutGenerics(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    Object getKey() {
        return key;
    }

    Object getValue() {
        return value;
    }
}
*/
