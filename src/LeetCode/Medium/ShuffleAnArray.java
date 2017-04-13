package LeetCode.Medium;

import java.util.Random;

public class ShuffleAnArray{
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
        
	//�}�u�@�����M
        int[] numsForShuffle = nums.clone();
	
	//�v���������M
        for(int i = 0; i < numsForShuffle.length; i ++) {
	    //ÿ�غ϶��M�н��Q(�ڔ��M���S�C��һ�����M�н��Q)���@�Ӳ����_�����ȫ�S�C
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