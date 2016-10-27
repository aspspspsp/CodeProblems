package Easy;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> ns =  new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i ++) {
            if(ns.get(nums[i]) == null) 
                ns.put(nums[i], 1);
            else
                ns.put(nums[i], ns.get(nums[i]) + 1);
        }
        
        int maxCount = 0;
        int majorElement = 0;
        
        for(HashMap.Entry<Integer, Integer> entry : ns.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                majorElement = entry.getKey();
            }
        }
        
        return majorElement;
    }
}