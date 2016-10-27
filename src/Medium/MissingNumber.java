package Medium;

/*
* 1.求取nums之和
* 2.再利用等差級數和的公式求取nums不缺少數字的和(1~n之和)
* 3.nums之和減去等差級數之和的公式即為答案
*/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        
        int totalForNums = 0;
        for(int i = 0; i < nums.length; i ++) {
            totalForNums = nums[i] + totalForNums;
        }
        
        int n = nums.length + 1;
        int totalForUnmissing = (int)(n * (0 * 2 + (n - 1) * 1) / 2);
        return totalForUnmissing - totalForNums;
    }
}