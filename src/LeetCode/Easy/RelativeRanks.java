package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        String[] ranks = new String[nums.length];
        if(nums == null || nums.length == 0)
            return ranks;
        
        //score, rank
        Map<Integer, Integer> map = new HashMap<>();
        
        //對num做複製，以免num被改變順序
        int[] dup = nums.clone();
        
        //注意:sort是遞增排序
        Arrays.sort(dup);
        
        //建立排名map
        int rank = 1;
        for(int i = dup.length - 1; i >= 0; i --) {
            if(map.containsKey(dup[i]) == false) {
                map.put(dup[i], rank);
                rank ++;
            } else {
                map.put(dup[i], rank);
            }
        }
        
        //建立名次結果
        for(int i = 0; i < nums.length; i ++) {
            rank = map.get(nums[i]);
            if(rank == 1) {
                ranks[i] = "Gold Medal";
            } else if(rank == 2) {
                ranks[i] = "Silver Medal";
            } else if(rank == 3) {
                ranks[i] = "Bronze Medal";
            } else {
                ranks[i] = String.valueOf(rank);
            }
        }
        
        return ranks;
    }
}
