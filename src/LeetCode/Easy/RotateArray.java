package src.LeetCode.Easy;

public class RotateArray {
/*
 * 將數組分為兩段:
 * 1 2 3 4 | 5 6 7
 * 1.翻轉第一段
 * 4 3 2 1 | 5 6 7
 * 2.翻轉第二段
 * 4 3 2 1 | 7 6 5
 * 3.再整個翻轉
 * 5 6 7 1 2 3 4
*/
    public void rotate(int[] nums, int k) {
    	int n = nums.length;
    	k = k % n; //取得最後面的k位數
    	reverse(nums, 0, n - k); //翻轉第一段
    	reverse(nums, n - k, n); //翻轉第二段
    	reverse(nums, 0, n); //再整個翻轉
    }
    
    void reverse(int[] nums, int begin, int end) {
    	int left = begin;
    	int right = end - 1;
    	while(left < right) {
    		swap(nums, left, right);
    		left ++;
    		right --;
    	}
    }
    
    void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}