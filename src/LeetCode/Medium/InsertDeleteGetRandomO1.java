package LeetCode.Medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomO1 {

    /** Initialize your data structure here. */
	//利用HashSet可以保證插入、刪除與查詢的速度都是O(1)
    Set<Integer> set;
    Random rnd;
    
    public InsertDeleteGetRandomO1() {
        set = new HashSet<Integer>();
        rnd = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isSuccessed = !set.contains(val);
        set.add(val);
        return isSuccessed;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean isSuccessed = set.contains(val);
        set.remove(val);
        return isSuccessed;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        //取得一個隨機數(在這個Set大小的範圍)
        int randInt = rnd.nextInt(set.size());
        
        int num = Integer.MAX_VALUE;
        
        //取得下標為隨機數的元素
        Iterator<Integer> it = set.iterator();
        while(it.hasNext() && randInt >= 0) {
            num = it.next();
            randInt --;
        }
        
        return num;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */