import java.util.HashMap
public class table2<K,V> {
    public static class HashNode<K, V> {
        private K key;
        private V value;
        public HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public table2() {
        chainArray = new HashNode[M];
    }

    public table2(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    public static void main(String[] args) {
        // Create the source hash table
        HashMap<Integer, String> source = new HashMap<>();
        source.put(1, "One");
        source.put(2, "Two");
        source.put(3, "Three");

        // Create a new destination hash table and copy the data
        HashMap<Integer, String> destination = new HashMap<>(source);

        // Print the copied hash table
        System.out.println("Copied Hash Table: " + destination);
    }
}

}
