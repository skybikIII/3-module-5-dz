package hashmap;

import java.util.Objects;

public class MyHashMap<K, V> {
    private int CAPACITY = 10;
    private MyMapBucket[] buckets;
    private int size = 0;

    public MyHashMap() {
        this.buckets = new MyMapBucket[CAPACITY];
    }

    public int getHash(K key) {
        return (key.hashCode() & 0xfffffff) % CAPACITY;
    }

    private MyKeyValueEntry getEntry(K key) {
        int hash = getHash(key);
        for (int i = 0; i < buckets[hash].getEntries().size(); i++) {
            MyKeyValueEntry myKeyValueEntry = buckets[hash].getEntries().get(i);
            if (myKeyValueEntry.getKey().equals(key)) {
                return myKeyValueEntry;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int hash = getHash(key);
        return !(Objects.isNull(buckets[hash]) || Objects.isNull(getEntry(key)));
    }

    public V put(K key, V value) {
        if(containsKey(key)) {
            MyKeyValueEntry entry = getEntry(key);
            V tmp = (V) entry.getValue();
            entry.setValue(value);
            return tmp;
        } else {
            int hash = getHash(key);
            if (buckets[hash] == null)
                buckets[hash] = new MyMapBucket();
            buckets[hash].addEntry(new MyKeyValueEntry<>(key, value));
            size++;
        }
        return null;
    }

    public V get(K key) {
        return containsKey(key) ? (V) getEntry(key).getValue() : null;
    }

    public int getSize() {
        return size;
    }

    public void remove(K key) {
        if(containsKey(key)) {
            int hash = getHash(key);
            buckets[hash].removeEntry(getEntry(key));
            size--;
        }
    }
}