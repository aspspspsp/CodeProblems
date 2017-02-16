package Medium;

public class MinimumSizeSubarraySum {
    /*
    这里我们采用滑动窗口的思想，如下：
    target:7
     2  3  1  2  4  3
    [2]                +
    [2  3]             +
    [2  3  1]          +
    [2  3  1  2]       +
       [3  1  2]       -
          [1  2  4]    *
          [1  2  4  3] +
             [2  4  3] -
                [4  3] *
    滑动窗口 [left, right] 初始大小为0，滑动的规则如下：
    1.若元素之和 < s，窗口右边沿向右延伸，直到 元素之和≥s 为止。
    2.若元素之和 ≥ s，更新最小长度。然后窗口左边沿右移一位（即移除窗口中第一个元素），重复第1步。
    */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int left = 0; //紀錄滑窗左邊界
        int right = 0; //紀錄滑窗右邊界
        
        int result = nums.length + 1; //紀錄結果(越小越好)
        int sum = 0;
        
        int length = nums.length;
        
        while(right < length) { //不讓右滑窗超過數組範圍
            sum = sum + nums[right]; //右滑窗負責加數(將數的範圍加大)
            
            //當此範圍的數組之和已經逼近於s時，開始收窄滑窗
            while(sum >= s) {
                //當滑窗只有一個數的時候是最小的(也順便處理左滑窗要超過右滑窗的情況)
                if(right - left + 1 == 1)
                    return 1;
                
                //紀錄最小的
                result = Math.min(result, right - left + 1);
                
                sum = sum - nums[left]; //左滑窗負責減數(將數的範圍減小)
                
                //移動左滑窗
                left = left + 1;
            }
            
            //移動右滑窗
            right = right + 1;
        }
        
        //處理沒有答案的情況
        if(result == length + 1)
            return 0;
            
        return result;
    }
}