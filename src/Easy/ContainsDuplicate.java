package Easy;

import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        
        HashMap<Integer, Integer> nums_ = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++) {
            if(nums_.get(nums[i]) == null)
                nums_.put(nums[i], 1);
            else
                return true;
        }
        
        return false;
    }
}