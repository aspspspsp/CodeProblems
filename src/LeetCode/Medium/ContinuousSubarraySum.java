package src.LeetCode.Medium;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        //考慮k為0的情況
        if(k == 0) {
            for(int i = 0; i < nums.length - 1; i ++) {
                if(nums[i] == 0 && nums[i + 1] == 0)
                    return true;
            }
            return false;
        }
        
        //一般情況
        for(int i = 0; i < nums.length; i ++) {
            int sub_sum = nums[i];
            for(int j = i + 1; j < nums.length; j ++) {
                sub_sum += nums[j];
                //子序列為加總為k或是為k的倍數，則為true
                if(sub_sum == k || sub_sum % k == 0)
                    return true;
            }
        }
        
        return false;
    }
}