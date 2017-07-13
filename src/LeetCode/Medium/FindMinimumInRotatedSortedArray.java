package LeetCode.Medium;

public class FindMinimumInRotatedSortedArray {
    //這題使用修改過的二分查找法
    public int findMin(int[] nums) {
        //處理數組為空的情況
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        //處理數組只有一個元素的情況
        if(nums.length == 1) {
            return nums[0];
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        /*若數組沒有被旋轉過，直接返回第一個
        經旋轉過後的數組，最左邊的數絕對不可能小於最右邊
        ex:
         0 1 2 3 4  0 < 4
         ---------
         4 0 1 2 3  4 > 3
         3 4 0 1 2  3 > 2
         2 3 4 0 1  2 > 1
         1 2 3 4 0  1 > 0
        */
        if(nums[low] < nums[high]) {
            return nums[0];
        }
        
        /*
                0 1 2 3 4 5 6
                ---------------
        原数组：*0 1 2 4 5 6 7
        情况1： 6 7 *0 1 2 4 5   //左邊一半有序
        情况2： 2 4 5 6 7 *0 1   //右邊一半有序
        
        如果左半边有序，那么左半边最小就是左边第一个元素，可以和当前最小相比取小的，然后走向右半边。
        否则，那么就是右半半边第一个元素，然后走向左半边。
        */
        while(low < high) {
            //若最右邊序號-最左邊序號為1時，表示已經搜索到最小值
            if(high - low == 1) {
                return nums[high];
            }
            
            int mid = (low + high) / 2;
            
            //若中間元素比左邊元素大(左邊一半有序ASD)，搜索右邊߅
            if(nums[mid] > nums[low]) {
                low = mid;
            //反之(右邊一半有序ASD)，搜索左邊߅
            } else {
                high = mid;
            }
        }
        
        //沒有結果則返回-1ֵ
        return -1;
    }
}