package LeetCode.Easy;
/*
總和最大的區間。從數列當中取出一連串數字，求總和；找出最大的總和。
最糟糕的情況，就是不取任何數字，總和為零。
在這裡我們會採用貪心法，利用:
localSum[i]:紀錄當前子序列最大總和，localSum變為負數時就會自動捨棄前面的總和
globalSum[i]:紀錄總體最大總和

範例:
nums = 1,2,-3,4,5,-2
=================================
          1  2  3  4  5  6
=================================
localSum  1  3 -3  4  9  7
globalSum 1  3  3  4  9  9
*/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int [] globalSum = new int[nums.length + 1];
        int [] localSum = new int[nums.length + 1];
        
        //初始化
        localSum[0] = nums[0];
        globalSum[0] = nums[0];
        
        for(int i = 1; i < nums.length; i ++) {
            //若localSum為負數則重置(相當於捨棄之前的序列和)
            localSum[i] = Math.max(nums[i], localSum[i - 1] + nums[i]);
            //將global進行更新
            globalSum[i] = Math.max(globalSum[i - 1], localSum[i]);
        }
        
        return globalSum[nums.length - 1];
    }
}