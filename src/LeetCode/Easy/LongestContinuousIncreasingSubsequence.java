package LeetCode.Easy;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return 1;
        
        int[] result = new int[nums.length];
        
        result[0] = 1;
        
        int max = 0;
        
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] > nums[i - 1])
                result[i] = result[i - 1] + 1;
            else
                result[i] = 1;
            max = Math.max(result[i], max);
        }
        
        return max;
    }
}