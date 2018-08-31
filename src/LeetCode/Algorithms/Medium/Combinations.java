package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author ZiHan
 * 從n取k，不重複
 * 
 * ex: n = 4, k = 2
 * [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * 有3個變量 n, k, m
 * dfs1                dfs2
 * ========================================================
 * m = 1   temp = [1], m = 2   temp = [1,2]
 *                     m = 3   temp = [1,2]
 *                     m = 4   temp = [1,4]
 * m = 2   temp = [2], m = 3   temp = [2,3]
 *                     m = 4   temp = [2,4]
 * m = 3   temp = [3], m = 4   temp = [3,4]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        //結果
        List<List<Integer>> result = new ArrayList<>();
        
        //暫存結果
        List<Integer> temp = new ArrayList<>();
        
        //進行深度搜索，從1開始(m=1)
        dfs(result, temp, n, k, 1);
        
        return result;
    }
    /*
    temp 暫存結果
    n 共多少個
    k n取k個
    m 目前從第m個數字開始
    */
    void dfs(List<List<Integer>> result, List<Integer> temp, int n, int k, int m) {
        //結果可以了ex:[1,2]，加入結果
        if(k == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        //開始於m，類似於排列，逐個數字拜訪
        for(int i = m; i <= n; i ++) {
            temp.add(i);
            dfs(result, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}