package Easy;
/*
 * 想像有兩個數組
 * 
 * ex: 
 *數組1 1223
 *數組2 ____(尚未填入值)
 * 
 * step1:
 * 想像數組2的變化
 * 1: 1 填入1
 * 2: 12 填入2
 * 3: 12 將2填入原來的地方
 * 4: 123 填入3
 */

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
    	//為指針
        int end = 0;
        
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == nums[end]) {
                continue;
            }
            end ++;
            nums[end] = nums[i];
        }
        
        return end + 1;
    }

}