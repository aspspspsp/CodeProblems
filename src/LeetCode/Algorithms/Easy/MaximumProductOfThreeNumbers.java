package src.LeetCode.Algorithms.Easy;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int n = nums.length;

        // 逼
        Arrays.sort(nums);

        // ㄢ贺薄猵
        int n1 = nums[0] * nums[1] * nums[n - 1]; // ㄢ程璽计 * 程タ计
        int n2 = nums[n - 1] * nums[n - 2] * nums[n - 3]; // 计

        // т程
        int max = Math.max(n1, n2);

        return max;
    }
}
