package LeetCode.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if(buildings == null)
            return result;
        
        //默認初始堆大小為11
        PriorityQueue<Integer> maxHeap = new PriorityQueue(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        
        //保存即將排序後的輪廓邊緣點
        List<int[]> sort = new ArrayList<>();
        for(int[] building : buildings) {
            sort.add(new int[] {building[0], building[2]});
            sort.add(new int[] {building[1], -building[2]});
        }
        
        //將所有輪廓邊緣點排序
        Collections.sort(sort, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[]i2) {
                if(i1[0] != i2[0])
                    return i1[0] - i2[0];
                else
                    return i2[1] - i1[1];
            }
        });
        
        int pre = 0;
        int cur = 0;
        for(int i = 0; i < sort.size(); i ++) {
            int[] building = sort.get(i);
            if(building[1] > 0) {
                maxHeap.add(building[1]);
                cur = maxHeap.peek();
            } else {
                maxHeap.remove(-building[1]);
                if(maxHeap.peek() == null)
                    cur = 0;
                else
                    cur = maxHeap.peek();
            }
            
            //當前節點與前一節點不同，說明遇到拐點
            if(cur != pre) {
                result.add(new int[] {building[0], cur});
                pre = cur;
            }
        }
        
        return result;
    }
}