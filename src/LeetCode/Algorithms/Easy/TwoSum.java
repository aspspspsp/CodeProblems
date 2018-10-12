package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        // key為數組的值，value為數組值所在的位置
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            List<Integer> list;
            if(map.containsKey(nums[i]) == false)
                list = new ArrayList<>();
            else
                list = map.get(nums[i]);

            list.add(i);
            map.put(nums[i], list);
        }

        for(int num : map.keySet()) {
            result[0] = map.get(num).get(0);

            // 利用num2 = target -num 取得num2
            int t = target - num;

            if(map.containsKey(t) == true) {
                List<Integer> list = map.get(t);
                if(list.size() > 1) {
                    result[1] = list.get(1);
                    return result;
                } else {
                    if(result[0] != list.get(0)) {
                        result[1] = list.get(0);
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
