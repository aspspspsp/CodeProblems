package LeetCode.Medium;

/*
* 1.��ȡnums֮��
* 2.�����õȲ���͵Ĺ�ʽ��ȡnums��ȱ�ٔ��ֵĺ�(1~n֮��)
* 3.nums֮�͜pȥ�Ȳ��֮�͵Ĺ�ʽ�����
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