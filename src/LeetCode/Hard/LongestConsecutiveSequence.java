package LeetCode.Hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        //這個set是用來存儲所有數字的集合
        Set<Integer> set = new HashSet<Integer>();
        
        //把所有數字加入set當中
        for(int num : nums) {
            set.add(num);
        }
        
        //默認lcs_max=1(因為lcs最短為1)
        int lcs_max = 1;
        
        //歷遍數組中每個數字
        for(int num : nums) {
            //滿足題目要求 1(left) 2 3(左邊比目前少1)
            int left = num - 1;
            
            //滿足題目要求 1 2 3(right)(右邊比目前多1)
            int right = num + 1;
            
            //目前lcs的數量
            int lcs_count = 1;
            
            //把從左邊的連續數組全部找出，並從集合中刪除(表示已經使用過了)
            /* ex: cur = 3
             *     set = 1 3 2 100 4 count = 1
                   set = 3 100 4     count = 3
            */
            while(set.contains(left)) {
                lcs_count ++;
                set.remove(left);
                left --;
            }
                
            //把從右邊的連續數組全部找出，並從集合中刪除(表示已經使用過了)
            /*ex: cur = 3
             *    set = 1 3 2 100 4 count = 1
                  set = 1 3 2 100   count = 2
            */
            while(set.contains(right)) {
                lcs_count ++;
                set.remove(right);
                right ++;
            }    
            
            lcs_max = Math.max(lcs_count, lcs_max);
        }
        
        return lcs_max;
    }
}