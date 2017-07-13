package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        //結果
        List<List<Integer>> result = new ArrayList<>();
        
        //暫存結果
        List<Integer> temp = new ArrayList<>();
        
        //進行深度搜索
        dfs(result, temp, n, k, 1);
        
        return result;
    }
    /*
    temp 暫存結果
    n 共多少個
    k n取k個
    m 目前從m個開始
    */
    void dfs(List<List<Integer>> result, List<Integer> temp, int n, int k, int m) {
        //結果可以了ex:[1,2]，加入結果
        if(k == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        //類似於排列，逐個數字拜訪
        for(int i = m; i <= n; i ++) {
            temp.add(i);
            dfs(result, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}