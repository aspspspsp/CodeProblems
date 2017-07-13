package LeetCode.Medium;

/*
最大乘積要考慮到負數的問題，故使用兩個數組來記錄動態規劃的結果
當疊代數組時，每個元素有兩種可能:正數或負數
所以當當前為負數時，需要追蹤每次動態規劃的最小值，利用它可以找到最大值
我們定義兩個本地變量，一個追蹤最大值，另一個追蹤最小值
*/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int [] maxResult = new int[nums.length];
        int [] minResult = new int[nums.length];
        
        //定義起始值
        maxResult[0] = nums[0];
        minResult[0] = nums[0];
        
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i ++) {
            //因為是乘法，故要考慮兩種情況
            if(nums[i] > 0) {
                //動態規劃
                //֮����Ҫ����nums[i]�cmaxResult[i - 1]���^���ǿ��]��*0����r
                maxResult[i] = Math.max(nums[i], maxResult[i - 1] * nums[i]);
                minResult[i] = Math.min(nums[i], minResult[i - 1] * nums[i]);
            } else {
                //動態規劃
                maxResult[i] = Math.max(nums[i], minResult[i - 1] * nums[i]);
                minResult[i] = Math.min(nums[i], maxResult[i - 1] * nums[i]);
            }
            //在結果中選一個最大的
            result = Math.max(result, maxResult[i]);
        }
        
        return result;
    }
}