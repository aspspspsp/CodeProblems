package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author zihanxu
 *
 */

public class SummaryRanges {
    class Range {
        int first;
        int last;
    }
    
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        
        List<Range> range_list = new ArrayList<>();
        
        Range first_range = new Range();
        first_range.first = nums[0];
        range_list.add(first_range);
        
        for(int i = 0; i < nums.length - 1; i ++) {
            if(nums[i] + 1 == nums[i + 1]) {
                continue;
            }
            
            Range cur_range = range_list.get(range_list.size() - 1);
            cur_range.last = nums[i];
            
            Range next_range = new Range();
            next_range.first = nums[i + 1];
            range_list.add(next_range);
        }
        
        Range final_range = range_list.get(range_list.size() - 1);
        final_range.last = nums[nums.length - 1];
        
        List<String> result = new ArrayList<>();
        for(int i = 0; i < range_list.size(); i ++) {
            Range r = range_list.get(i);
            String sub_res;
            if(r.first == r.last)
                sub_res = r.first + "";
            else
                sub_res = r.first + "->" + r.last;
            result.add(sub_res);
        }
        
        return result;
    }
}
