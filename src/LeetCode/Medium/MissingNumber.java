package LeetCode.Medium;

/*
題目翻譯
从0到n之间取出n个不同的数，找出漏掉的那个。 注意：你的算法应当具有线性的时间复杂度。你能实现只占用常数额外空间复杂度的算法吗？

我們可以對
* 1.先將所有nums中的元素加起來
* 2.利用求和(1+2+...+n)公式算出1+2+...+n的總和(利用三角形公式(n*(n+1)/2)求解)
* 3.將nums的和與1+2+...+n的和相減即為所求
*/
public class MissingNumber {
    public int missingNumber(int[] nums) {

        // 先將所有nums中的元素加起來
        int totalForNums = 0;
        for(int i = 0; i < nums.length; i ++) {
            totalForNums = nums[i] + totalForNums;
        }

        // 利用求和(1+2+...+n)公式算出1+2+...+n的總和
        int n = nums.length;
        int totalForUnmissing = n * (n + 1) / 2;

        // 將nums的和與1+2+...+n的和相減即為所求
        return totalForUnmissing - totalForNums;
    }
}