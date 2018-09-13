package src.LeetCode.Algorithms.Easy;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int n = nums.length;

        // ���Ƨ�
        Arrays.sort(nums);

        // ��ر��p
        int n1 = nums[0] * nums[1] * nums[n - 1]; // ��ӳ̤j�t�Ƭۭ� * �̤j����
        int n2 = nums[n - 1] * nums[n - 2] * nums[n - 3]; // �T�ӼƬۭ�

        // ��̤j
        int max = Math.max(n1, n2);

        return max;
    }
}
