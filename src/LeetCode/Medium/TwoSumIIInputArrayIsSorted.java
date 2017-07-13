package LeetCode.Medium;
/*
利用双指针

初始化的时候第一个指针left在下标为0的位置，
第二个指针right在下标为n - 1的位置。
通过比较计算的和与target，移动指针，缩小查找范围。

比如，一开始的时候，left = 0, right = n - 1，
计算此时的和 sum = numbers[left] + numbers[right]。

如果此时的和 > target，说明右边太大了，right –-。
如果 和 < target, 说明左边太小了，left ++。
如果刚好等于，返回此时的left, right。
*/
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        if(numbers == null || numbers.length == 0)
            return indices;
        
        //定義左右二指針
        int left = 0, right = numbers.length - 1;
        
        //使用兩指針左右夾逼的方式來找出兩個index
        while(left >= 0 && right <= numbers.length - 1 && right > left) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                //輸出的答案是要從下標1開始，故要 + 1
                indices[0] = left + 1;
                indices[1] = right + 1;
                break;
            //右邊太大了，將右邊指針向左移
            } else if(sum > target) {
                right --;
            //左邊太小了，將左邊指針向右移
            } else {
                left ++;
            }
        }
        return indices;
    }
}