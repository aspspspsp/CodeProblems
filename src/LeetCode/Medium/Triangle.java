package LeetCode.Medium;

import java.util.List;

/*
本题是从下往上递归处理。
建立一个 results 数组，存儲每一行的最小和。
以[[2],[3,4],[5,6,7]]为例，dp 的过程如下：
=================================================
                    _
step.3   [2]       10|10|7 |0     //更新 10
                    ____
step.2  [3,4]       8|10|7 |0     //更新 8 10
                    _______
step.1 [5,6,7]      5| 6|7 |0     //更新 5 6 7

step.0              0| 0|0 |0     //建立數組
*/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0 || triangle == null)
            return 0;
        
        int n_level = triangle.size();
        int[] results = new int[n_level + 1];
        
        //从下往上递归处理
        for(int i = n_level - 1; i >= 0; i --) {
            List<Integer> cur = triangle.get(i);
            //拜訪當層元素
            for(int j = 0; j < cur.size(); j ++) {
                results[j] = Math.min(results[j], results[j + 1]) + cur.get(j);
            }
        }
        return results[0];
    }
}
