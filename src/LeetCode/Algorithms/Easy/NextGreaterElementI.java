package src.LeetCode.Algorithms.Easy;

public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        
        int[] result = new int[nums1.length];
        
        for(int i = 0; i < nums1.length; i ++) {
            int n1 = nums1[i];
            int n1_index = findIndex(n1, nums2);
            if(n1_index >= 0 && n1_index + 1 < nums2.length) {
                result[i] = findNearsetLarger(n1_index + 1, n1, nums2);
            } else {
                result[i] = -1;
            }
        }
        
        return result;
    }
    
    int findNearsetLarger(int index, int n, int[] nums) {
        for(int i = index; i < nums.length; i ++) {
            if(n < nums[i])
                return nums[i];
        }
        
        return -1;
    }
    
    int findIndex(int n, int[] nums) {
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == n)
                return i;
        }
        
        return -1;
    }
}
