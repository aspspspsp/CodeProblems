package src.LeetCode.Easy;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        //使用輔助數組
        int[] copy = new int[nums.length];
        
        //複製數組的值到輔助數組
        for(int i = 0; i < nums.length; i ++) {
            copy[i] = nums[i];
        }
        
        //排序輔助數組
        Arrays.sort(copy);
        
        //找到未排序的連續數組起點index
        int l = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != copy[i]) {
                l = i;
                break;
            }
        }
        
        //找到未排序的連續數組終點index
        int r = Integer.MAX_VALUE;
        for(int i = nums.length - 1; i >= 0; i --) {
            if(nums[i] != copy[i]) {
                r = i;
                break;
            }
        }
        
        //若都沒找到起點與終點表示此數組為全部排序的數組，故輸出0
        if(l == Integer.MIN_VALUE && r == Integer.MAX_VALUE)
            return 0;
        
        //輸出未排序的連續數組大小
        return r - l + 1;
    }
}