package src.LeetCode.Algorithms.Easy;

public class FindPivotIndex {    /*
    index        0   1   2   3   4  5
    nums     = [ 1,  7,  3,  6,  5,  6]
    leftSum  = [ 1,  8, 11, 17, 23, 29]
    rightSum = [29, 28, 20, 17, 11,  6]

    return                   3
    */
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        int n = nums.length;

        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        leftSum[0] = nums[0];
        rightSum[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i ++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
            rightSum[n - i - 1] = rightSum[n - i] + nums[n - i - 1];

            // 若中途得到答案則直接返回就好
            if(i == n - i - 1 && leftSum[i] == rightSum[n - i - 1])
                return i;
        }

        for(int i = 0; i < n; i ++) {
            if(leftSum[i] == rightSum[i])
                return i;
        }

        return -1;
    }
}
