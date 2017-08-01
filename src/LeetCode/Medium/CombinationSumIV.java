package LeetCode.Medium;

public class CombinationSumIV {
    /*
    题意：给定一个元素互不相同且均为正数的数组，让你用该数组中的数组
    合成target（可以重复使用），问有多少种。

    這題類似於換硬幣(322. Coin Change)，是一道經典的動態規劃問題。
    */
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;

        int[] results = new int[target + 1];
        
        results[0] = 1;

        for(int i = 0; i <= target; i++){
            for(int j = 0; j < nums.length; j ++) {
                int num = nums[j];
                if(i + num <= target) {
                    results[i + num] = results[i + num] + results[i];
                }
            }
        }

        return results[target];
    }
}