package src.LeetCode.Algorithms.Easy;

import java.util.Set;
import java.util.HashSet;

public class DesignHashMap {

    // ¬ö¿ýkey
    Set<Integer> keys;

    // ¬ö¿ý­È
    int[] values;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        keys = new HashSet<Integer>();
        values = new int[1000000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        keys.add(key);
        values[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(keys.contains(key) == false)
            return -1;

        return values[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(keys.contains(key))
            keys.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */