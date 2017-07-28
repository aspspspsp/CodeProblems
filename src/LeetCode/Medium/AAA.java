package LeetCode.Medium;

public class AAA {
	public static void main(String[] args) {
		int [] nums = {2,3,5,6,1}; //1 2 3 5 6
		int k = 1;
		System.err.println(findKthLargest(nums, k));
	}
	
    public static int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 || nums == null)
            return 0;
        
        int start = 0, end = nums.length - 1;
        
        int index = partition(nums, start, end);
        while(index != k - 1) {
            if(index > k - 1) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        
        return nums[index];
    }
    
    static int partition(int[] nums, int left, int right) {
        int l = left, r = right;
        
        int pivot = nums[(l + r) / 2];
        while(l <= r) {
            while(nums[l] < pivot) {
                l ++;
            }
    
            while(nums[r] > pivot) {
                r --;
            }
            
            if(l <= r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l ++;
                r --;
            }
        }
        
        return l;
    }
    
}
