package src.LeetCode.Algorithms.Medium;

import java.util.Random;
/*
 * 解法:
 * 歷遍整個數組，在歷遍每一個元素的同時，也生成一個隨機的index(範圍:整個數組的長度)
 * ，然後當前元素在與這個隨機的元素進行交換。
*/
public class ShuffleAnArray {
    int[] nums;
    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rnd = new Random();
        
        if(nums.length == 0)
            return null;
        
    //將整個數組複製一遍
    //(因為reset這個方法必須要返回原始順序的數組，故需要複製數組)
        int[] numsForShuffle = nums.clone();
	
    //歷遍整個數組
        for(int i = 0; i < numsForShuffle.length; i ++) {
        //產生一個隨機的index，這個index會與當前歷遍的數字進行交換，達到隨機洗牌的目的
        //這個index的範圍就是整個數組的大小
        	int rndIndex = rnd.nextInt(numsForShuffle.length);
            numsForShuffle = swap(numsForShuffle, rndIndex, i);
        }
        return numsForShuffle;
    }
    
    int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */