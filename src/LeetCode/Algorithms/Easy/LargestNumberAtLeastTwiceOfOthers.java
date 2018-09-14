package src.LeetCode.Algorithms.Easy;

public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int max = 0;
        int max_index = -1;
        for(int i = 0; i < nums.length; i ++) {
            if(max < nums[i]) {
                max = nums[i];
                max_index = i;
            }
        }

        boolean isValid = true;
        for(int i = 0; i < nums.length; i ++) {
            if(i == max_index)
                continue;

            if(max < nums[i] * 2)
                isValid = false;
        }

        if(isValid == true)
            return max_index;

        return -1;
    }
}
