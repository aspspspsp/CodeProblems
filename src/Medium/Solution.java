package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] t = {1,2,3,4};
		s.permute(t);
	}
	
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length == 0)
            return ans;
        else if(nums.length == 1) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(nums[0]);
            ans.add(tmp);
            return ans;
        }
        ans.add(getIntList(nums));
        
        int[] clones = nums.clone();
        int cur_i = -1;
        int cur_j;
        do {
            cur_i = cur_i + 1;
            
            if(cur_i >= nums.length - 1) {
                cur_i = 0;
            }
            
            cur_j = cur_i + 1;
            clones = swap(clones, cur_i, cur_j);
            ans.add(getIntList(clones));
        } while(!Arrays.equals(nums, clones));
        return ans;
    }
    
    public List<Integer> getIntList(int[] nums) {
        List<Integer> intsList = new ArrayList<Integer> ();
        for(int i = 0; i < nums.length; i ++) {
            intsList.add(nums[i]);
        }
        
        return intsList;
    }
    
    public void printInts(int[] nums) {
        for(int i = 0; i < nums.length; i ++) {
            System.err.print(nums[i]);
        }
        System.err.println();
    }
    
    public int[] swap(int[] nums, int p_i, int p_j) {
        int tmp = nums[p_i];
        nums[p_i] = nums[p_j];
        nums[p_j] = tmp;
        return nums;
    }
}