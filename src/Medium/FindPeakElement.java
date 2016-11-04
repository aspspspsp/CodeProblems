package Medium;

/*
 * 找到山頂的index
 * ex:12321
 * return 2
 * 
 * 注意偏斜的山
 * ex:321
 * return 0
 * ex:123
 * return 2
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        
        boolean isSkew = true;
        int peak_index = 0;
        for(int i = 1; i < nums.length; i ++) {
            if(i + 1 >= nums.length) {
                break;
            }
            
            //若找到山頂則不是偏斜
            if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                peak_index = i;
                isSkew = false;
                break;
            }
        }
        
        //處理偏斜的部分
        if(isSkew == true && nums.length > 1) {
            if(nums[0] > nums[1]) {
                peak_index = 0;
            } else if(nums[1] > nums[0]){
                peak_index = nums.length  - 1;
            }
            
        }
        
        return peak_index;
    }
}