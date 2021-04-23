package homework3.task3;


public class SimpleHashMap<K, V> {

    private final int DEFAULT_INITIAL_CAPACITY = 10;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    Node[] table = new Node[DEFAULT_INITIAL_CAPACITY];
    private int size = 0;


    public int size() {
        return size;
    }

    public V put(K key, V value) {
        int hashValue = hash(key);
        int i = indexFor(hashValue, table.length);

        for (Node node = table[i]; node != null; node = node.next) {
            Object k;
            if (node.hash == hashValue && ((k = node.key) == key || key.equals(k))) {
                V oldValue = (V) node.value;
                node.value = value;
                return oldValue;
            }
        }
        addNode(key, value, hashValue, i);
        return null;
    }


    public V get(K key) {
        int hashValue = hash(key);
        int i = indexFor(hashValue, table.length);

        for (Node node = table[i]; node != null; node = node.next) {
            if (node.key.equals(key) && hashValue == node.hash) {
                return (V) node.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int hashValue = hash(key);
        int i = indexFor(hashValue, table.length);
        int count = 0;
        V oldValue = null;
        Node old = null;
        if (!(table[i].next == null)) {
            for (Node node = table[i]; node != null; node = node.next) {
                if (node.key.equals(key) && hashValue == node.hash) {
                    if (node.next == null) {
                        oldValue = (V) node.value;
                        old.next = null;
                        return oldValue;
                    } else if (node.next != null && count == 0) {
                        table[i] = node.next;
                    } else {
                        old.next = node.next;
                        oldValue = (V) node.value;
                        return oldValue;
                    }
                }
                old = node;
                count++;
            }
        } else {
            oldValue = (V) table[i].value;
            table[i] = null;

        }
        return oldValue;
    }

    public void addNode(K key, V value, int hashValue, int i) {

        if (++size >= table.length * DEFAULT_LOAD_FACTOR) {
            Node[] newTable = new Node[table.length << 1];

            for (int j = 0; j < table.length; j++) {
                Node e = table[j];
                table[j] = null;
                do {
                    Node next = e.next;
                    int s = indexFor(e.hash, newTable.length);
                    e.next = newTable[s];
                    newTable[s] = e;
                    e = next;
                } while (e != null);
            }
            table = newTable;
        }

        Node eNode = table[i];

        table[i] = new Node(hashValue, key, value, eNode);
    }


    public int indexFor(int hashValue, int length) {
        return hashValue % length;
    }


    public int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;


        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        public K getKey() {
            return key;
        }


        public V getValue() {
            return value;
        }
    }

}
