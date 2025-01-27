package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) >= 0) {
            values[getIndex(key)] = value;
        } else {
            values[size] = value;
            keys[size] = key;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (getIndex(key) >= 0) {
            return values[getIndex(key)];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
