package Easy;
public class TwoSums {
	public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++ ) {
            
            for(int j = 0; j < nums.length; j ++) {
                
                if(i == j)
                    continue;
                    
                if(nums[i] + nums[j] == target) {
                    int [] ans =  new int[2];
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        
    
        return null;
    }
}