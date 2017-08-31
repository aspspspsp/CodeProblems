package LeetCode.Hard;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] nums_ = new int[nums.length + 2];
        
        //在原有數組的基礎上增加邊界，如: 3,1,5,8 -> 1,3,1,5,8,1
        nums_[0] = 1;
        for(int i = 0; i < nums.length; i ++) {
            nums_[i + 1] = nums[i];
        }
        nums_[nums_.length - 1] = 1;
        
        int length = nums_.length;
        
        //開始計算結果
        int[][] result = new int[length][length];
        
        for(int i = 1; i < length; i ++) { //左邊界
            for(int left = 0; left < length - i; left ++) { //右邊界
                int right = left + i;
                for(int k = left + 1; k < right; k ++) {
                    /*
                    dp公式 = 找到left到right區間最大硬幣數
                    又可以分割從left到k與k到right兩個子問題
                    */
                    result[left][right] = Math.max(result[left][right],
                                    nums_[left] * nums_[k] * nums_[right] + result[left][k] + result[k][right]);
                }
            }
        }
        
        //結果則是left,right區間中的最大值
        return result[0][length - 1];
    }
}