package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public class Solution {
	    public List<List<Integer>> fourSum(int[] nums, int target) {
	        /*
	        �c3sum���
	        �Ɍ�forѭ�h���Ȍ��c3sum�Y��һ��
	        */
	        
	        Arrays.sort(nums);
	        
	        List<List<Integer>> result = new ArrayList<>();
	        
	        for(int i = 0; i < nums.length; i ++) {
	            if(i != 0 && nums[i] == nums[i - 1])
	                continue;
	            for(int j = i + 1; j < nums.length; j ++) {
	                if(j != i + 1 && nums[j] == nums[j - 1])
	                    continue;
	                int k = j + 1;
	                int l = nums.length - 1;
	                while(k < l) {
	                    if(nums[i] + nums[j] + nums[k] + nums[l] == target) {
	                        List<Integer> sub_result = new ArrayList<>();
	                        sub_result.add(nums[i]);
	                        sub_result.add(nums[j]);
	                        sub_result.add(nums[k]);
	                        sub_result.add(nums[l]);
	                        result.add(sub_result);
	                        
	                        k ++;
	                        l --;
	                        
	                        while(k < l && nums[k] == nums[k - 1])
	                            k ++;
	                        while(k < l && nums[l] == nums[l + 1])
	                            l --;
	                        
	                    } else if(nums[i] + nums[j] + nums[k] + nums[l] > target) {
	                        l --;
	                    } else if(nums[i] + nums[j] + nums[k] + nums[l] < target) {
	                        k ++;
	                    }
	                }
	            }
	        }
	        return result;
	    }
	}
}
