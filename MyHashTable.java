public class MyHashTable<K, V> {
    // nested static class
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

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        int hashValue = key.hashCode() % M;
        if (hashValue < 0) {
            hashValue += M;
        }
        return hashValue;
    }

    public void put(K key, V value) {
        int hashValue = hash(key);
        HashNode<K, V> node = chainArray[hashValue];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[hashValue];
        chainArray[hashValue] = newNode;
        size++;
    }

    public V get(K key) {
        int hashValue = hash(key);
        HashNode<K, V> node = chainArray[hashValue];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int hashValue = hash(key);
        HashNode<K, V> prevNode = null;
        HashNode<K, V> currNode = chainArray[hashValue];
        while (currNode != null) {
            if (currNode.key.equals(key)) {
                if (prevNode == null) {
                    chainArray[hashValue] = currNode.next;
                } else {
                    prevNode.next = currNode.next;
                }
                size--;
                return currNode.value;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
    }

