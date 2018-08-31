package src.LeetCode.Easy;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 0 || nums == null)
            return 0.0;
        
        //利用滑窗的方式來得到目前的最大值
        /*
         * ex : num = [1, 2, 3, 4, 5] k = 3
         *
         * init.  sum = 1+2+3 = 6 result = 6 //將k個數加上(0~k-1)
         * step1. sum = 6-1+4 = 9 result = 9 //減去第2個數加上第3個數
         * step2. sum = 9-2+5 = 12 result = 12 //減去第3個數加上第4個數
         * 返回result / k
         */
        double sum = 0;
        for(int i = 0; i < k; i ++) {
            sum += nums[i];            
        }
        
        double result = sum;
        for(int i = k; i < nums.length; i ++) {
            sum = sum + nums[i] - nums[i - k];
            result = Math.max(sum, result);
        }
        
        return result / k;
    }
}