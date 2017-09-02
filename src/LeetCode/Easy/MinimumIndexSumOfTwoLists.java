package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        //字串, 出現的位置
        Map<String, Integer> map = new HashMap<>();
        
        //對list1的所有字串建立HashMap
        for(int i = 0; i < list1.length; i ++) {
            map.put(list1[i], i);
        }
        
        //利用list2的字串信息對map進行查找
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i ++) {
            if(map.containsKey(list2[i]) == true) {
                //使出現的索引為最小
                int cur = map.get(list2[i]) + i;
                if(min > cur) {
                    res.clear();
                    res.add(list2[i]);
                    min = cur;
                } else if(min == cur) {
                    res.add(list2[i]);
                }
            }
        }
        
        
        String[] result = new String[res.size()];
        for(int i = 0; i < res.size(); i ++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
}