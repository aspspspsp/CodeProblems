package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {
    private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSumPairs() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        
        //歷遍整個HashMap
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            //若prefix相同則相加
            if(entry.getKey().startsWith(prefix)) {
                sum += entry.getValue();
            }
        }
        
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
