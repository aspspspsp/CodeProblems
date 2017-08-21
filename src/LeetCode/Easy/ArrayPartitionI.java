package LeetCode.Easy;

import java.util.Arrays;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        if(nums == null || nums.length == 0)
            return result;
        
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 0; i --) {
            if(i % 2 == 0)
                result += nums[i];
        }
        
        return result;
    }
}
