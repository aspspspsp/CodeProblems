package Easy;

public class RotateArray {
/*
每次交换range=n-k范围内的数字
如[1,2,3,4,5,6,7] k = 3， 交换完后就是 [7, 5, 6, 1, 2, 3, 4]
此时n = k_last, k = n- (range%k_last) = 2
变完后[6, 5, 7], 反复做下去，直到k = 0 or n<=1
注意是从后往前交换
*/
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //(k = k % n)是避免从后往前交换的問題
        while((k = k % n) > 0 && n > 1) {
            //交換range = n-k范围内的數字
            int range = n - k;
            for(int i = 1; i <= range; i ++) {
                int temp = nums[n - i];
                nums[n - i] = nums[n - i - k];
                nums[n - i - k] = temp;
            }
            
            //避免从后往前交换的問題
            n = k;
            k = n - (range % k);
        }
        
    }
}