package src.LeetCode.Medium;
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int temp = 0;
        int cur_step = 0;
        int target = S;
        
        int result = helper(nums, cur_step, temp, target);
        
        return result;
    }
        
    int helper(int[] nums, int cur_step, int temp, int target) {
        //紀錄結果
        int result = 0;
        
        //若全部拜訪完，則檢查結果是否等於S(target)
        if(cur_step == nums.length) {
            if(temp == target) {
                result = result + 1;
            }
            
            return result;
        }
        
        //進行下一步：sum += nums[cur_step + 1]
        int n1 = temp + nums[cur_step];
        result = result + helper(nums, cur_step + 1, n1, target);
        
        //進行下一步：sum += nums[cur_step + 1]
        int n2 = temp - nums[cur_step];
        result = result + helper(nums, cur_step + 1, n2, target);
        
        return result;
    }
}