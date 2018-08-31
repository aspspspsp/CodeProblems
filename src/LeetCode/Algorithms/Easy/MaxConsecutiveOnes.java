package src.LeetCode.Algorithms.Easy;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] results = new int[nums.length];
        int max = 0;
        
        if(nums[0] == 1) {
            max = 1;
            results[0] = 1;
        }
        
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] == 1) {
                results[i] = results[i - 1] + 1;
                max = Math.max(results[i], max);
            } else
                results[i] = 0;
        }
        
        return max;
    }
}
