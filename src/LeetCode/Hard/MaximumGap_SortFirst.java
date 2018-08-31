package src.LeetCode.Hard;

import java.util.Arrays;
/*
 * 這種方法應該會超時(需要線性時間)，但LeetCode對這題的時間限制不要求，
 * 導致這提異常簡單，但真正面試時，還是需要時間更短的算法
 */
public class MaximumGap_SortFirst {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        
        //先排序
        Arrays.sort(nums);
        
        //找最大間隔
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; i ++) {
            int gap = Math.abs(nums[i] - nums[i + 1]);
            if(gap > max) {
                max = gap;
            }
        }
        
        return max;
    }
}
