package src.LeetCode.Easy;
/*
 * ex 0 1 2 0 3
 * 1. 1 0 2 0 3
 * 2. 1 2 0 0 3
 * 3. 1 2 3 0 0
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {       
        int length = nums.length;
        
        //����0�t��ǰ�c��һ����0���Q
        for(int i = 0; i < length; i ++) {
            if(nums[i] == 0) {
                for(int j = i + 1; j < length; j ++) {
                    if(nums[j] != 0) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp; 
                        break;
                    }
                }
            }
            
        }
    }
}
