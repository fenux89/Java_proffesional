package homework15.task3;


import java.util.*;

public class MyHashMap<K, V> {
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    transient MyHashMap.Node<K, V>[] table;
    transient Set<Map.Entry<K, V>> entrySet;
    transient int size;
    transient int modCount;

    public MyHashMap() {
        table = new MyHashMap.Node[DEFAULT_INITIAL_CAPACITY];
    }

    public void clear() {
        MyHashMap.Node<K, V>[] tab;
        modCount++;
        if ((tab = table) != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
    }

    public int indexFor(int hashValue, int length) {
        return hashValue % length;
    }

    public V put(K key, V value) {
        int hashValue = hash(key);
        int i = indexFor(hashValue, table.length);

        for (MyHashMap.Node node = table[i]; node != null; node = node.next) {
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

    public void addNode(K key, V value, int hashValue, int i) {

        if (++size >= table.length * DEFAULT_LOAD_FACTOR) {
            MyHashMap.Node[] newTable = new MyHashMap.Node[table.length << 1];

            for (int j = 0; j < table.length; j++) {
                MyHashMap.Node e = table[j];
                table[j] = null;
                do {
                    MyHashMap.Node next = e.next;
                    int s = indexFor(e.hash, newTable.length);
                    e.next = newTable[s];
                    newTable[s] = e;
                    e = next;
                } while (e != null);
            }
            table = newTable;
        }

        MyHashMap.Node eNode = table[i];

        table[i] = new MyHashMap.Node(hashValue, key, value, eNode);
    }

    public V remove(Object key) {
        int hashValue = hash(key);
        int i = indexFor(hashValue, table.length);
        int count = 0;
        V oldValue = null;
        MyHashMap.Node old = null;
        if (!(table[i].next == null)) {
            for (MyHashMap.Node node = table[i]; node != null; node = node.next) {
                if (node.key.equals(key) && hashValue == node.hash) {
                    if (node.next == null) {
                        oldValue = (V) node.value;
                        old.next = null;
                        size--;
                        return oldValue;
                    } else if (node.next != null && count == 0) {
                        table[i] = node.next;
                    } else {
                        old.next = node.next;
                        oldValue = (V) node.value;
                        size--;
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
        size--;
        return oldValue;
    }

    public V get(Object key) {
        int hashValue = hash(key);
        int i = indexFor(hashValue, table.length);

        for (MyHashMap.Node node = table[i]; node != null; node = node.next) {
            if (node.key.equals(key) && hashValue == node.hash) {
                return (V) node.value;
            }
        }
        return null;
    }

    final MyHashMap.Node<K, V> getNode(int hash, Object key) {
        MyHashMap.Node<K, V>[] tab = table;
        int n = tab.length;
        int j = indexFor(hash(key), table.length);
        if (tab[j] == null) {
            return null;
        }
        MyHashMap.Node<K, V> first = tab[indexFor(hash(key), table.length)], e = first.next;

        K k = first.key;
        if (tab != null && n > 0 && first != null) {
            if (first.hash == hash && (k == key || (key != null && key.equals(k))))
                return first;
            if (e != null) {
                for (MyHashMap.Node<K, V> node = first; node != null; node = node.next) {

                    if (node.hash == hash && (node.key == key || (key != null && key.equals(node.key)))) {

                        return node;
                    }
                }
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        return getNode(hash(key), key) != null;
    }

    public boolean containsValue(Object value) {
        MyHashMap.Node<K, V>[] tab = table;
        V v;
        if (tab != null && size > 0) {
            for (MyHashMap.Node<K, V> e : tab) {
                for (; e != null; e = e.next) {
                    if ((v = e.value) == value || (value != null && value.equals(v)))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Set<K> keySet() {
        MyHashMap.Node<K, V>[] tab = table;
        MyHashMap.Node<K, V> nod;
        Set<K> ks = new HashSet<>();
        if (size != 0) {
            for (int j = 0; j < table.length; j++) {
                nod = tab[j];
                if (nod != null) {
                    ks.add(nod.key);
                    for (MyHashMap.Node<K, V> node = tab[1]; node != null; node = node.next) {
                        if (node != null) {
                            ks.add(node.key);
                        }
                    }
                }
            }

        }

        return ks;
    }

    public int size() {
        return size;
    }

    public int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        MyHashMap.Node<K, V> next;

        Node(int hash, K key, V value, MyHashMap.Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

    }
}
