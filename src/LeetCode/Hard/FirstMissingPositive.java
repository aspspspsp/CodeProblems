public class Solution {
/*
注意：题目要求是find the first missing positive integer 。
也就是说，即便你给的数组是4 5 6 7，看似都一一排好序，但是
返回值一定是1，也就是如果给的数组是4 5 7 8 ，答案不是6，是1。

因此，有了这个性质，我们就能i和A[i]是否相等来做判断了。
“实现中还需要注意一个细节，就是如果当前的数字所对应的下标
已经是对应数字了，那么我们也需要跳过，因为那个位置的数字
已经满足要求了，否则会出现一直来回交换的死循环。”


*/
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        }
        
        //桶排序
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
                i ++;
            // 防止死循环.条件不能是else if (nums[i] != i + 1)  
            //比如[1,1]会引起死循环  
            } else if(nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i ++;
            }
        }
        
        //find the first missing positive integer 
        i = 0;
        while(i < nums.length && nums[i] == i + 1) {
            i ++;
        }
        
        return i + 1;
    }
    
    // 交換
    void swap(int[] nums, int i, int j) {            
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}