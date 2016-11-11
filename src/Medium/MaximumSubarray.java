package Medium;
/*
求最大子数组和，即求区间和的最大值

这里首先介绍一种巧妙的贪心算法，
localSum[i]表示当前子数组和
globalSum[i],表示求得的最大子数组和
当localSum[i] <= 0时，累加数组中的元素只会使得到的和更小，故此时应将此部分和丢弃
，使用此时遍历到的数组元素替代。

思想:
 1,2,-3,4
 歷遍到-4時
 決定是否要丟棄1,2,-3的總和
 
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
            //若localSum比當前歷遍的數組小時則重置(相當於捨棄之前的序列和)
            localSum[i] = Math.max(nums[i], localSum[i - 1] + nums[i]);
            //將global進行更新
            globalSum[i] = Math.max(globalSum[i - 1], localSum[i]);
        }
        
        return globalSum[nums.length - 1];
    }
}