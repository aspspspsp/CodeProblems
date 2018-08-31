package src.LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        //將數組中所有的元素放入map當中，並計算出現的數量
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            if(map.containsKey(nums[i]) == false) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        
        //因為Harmonious Subsequence之中最大值與最小值只能差1，故只在map中找到比他大1的數的出現數量，並比較最大值
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            if(map.containsKey(num + 1) == false)
                continue;
            
            //計算Harmonious Subsequence的數量
            int hs = map.get(num + 1) + entry.getValue();
            
            //得出最大值
            if(hs > max)
                max = hs;
        }
        
        return max;
    }
}