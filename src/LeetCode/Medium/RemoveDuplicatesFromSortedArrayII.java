package LeetCode.Medium;
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        boolean isOnce = false;
        
        int end = 0;
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] == nums[end] && isOnce == true) {
                continue;
            }
            
            //�����l��������S�ɂ����}��
            if(nums[i] == nums[end] && isOnce == false)
                isOnce = true;
            else if(nums[i] != nums[end] && isOnce == true)
                isOnce = false;
            
            end = end + 1;
            nums[end] = nums[i];
        }
        
        return end + 1;
    }
}