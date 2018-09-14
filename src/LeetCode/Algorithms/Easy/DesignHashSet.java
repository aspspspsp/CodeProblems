package src.LeetCode.Algorithms.Easy;

public class DesignHashSet {
    int[] keys;

    /** Initialize your data structure here. */
    public DesignHashSet() {
        keys = new int[1000000];
    }

    public void add(int key) {
        keys[key] = 1;
    }

    public void remove(int key) {
        keys[key] = 0;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(keys[key] == 1)
            return true;

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
