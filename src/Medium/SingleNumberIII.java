package Medium;

import java.util.HashMap;
import java.util.Set;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> temp_result = new HashMap<> ();
        
        for(int i = 0; i < nums.length; i ++) {
            if(temp_result.get(nums[i]) == null) {
                temp_result.put(nums[i], 1);
            } else {
                temp_result.remove(nums[i]);
            }
        }
        
        int [] result = new int[temp_result.size()];
        
        Set<Integer> keys = temp_result.keySet();
        int i = 0;
        for(int key : keys) {
            result[i] = key;
            i ++;
        }
        
        return result;
    }
}