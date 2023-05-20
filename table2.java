public class table2<K,V> {
    public static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

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

}