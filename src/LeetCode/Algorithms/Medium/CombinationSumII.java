package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	/*
	 * 因為這題的數組是無序的，故需要先排序才能進行dfs(避免答案重複) 
	 */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
        
        //先排序
        Arrays.sort(candidates);
        
        List<Integer> temp = new ArrayList<>();
        
        //開始歷遍
        helper(candidates, target, 0, 0, temp, result);
        
        return result;
    }
    
    void helper(int[] candidates, int target, int cur_val, int m, List<Integer> temp, List<List<Integer>> result) {
        //若目前結果大於target即可跳出
        if(cur_val > target)
            return;
        
        if(cur_val == target) {
            //若結果已經有重複，則跳出
            if(result.contains(temp))
                return;
            
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = m; i < candidates.length; i ++) {
            temp.add(candidates[i]);
            //因為每個元素只能用一次，故要從m + 1開始走
            //ex: 1 2 3 4 -> step1. 1, step2. 2, step3. 3, step4. 4
            helper(candidates, target, cur_val + candidates[i], i + 1, temp, result);
            
            //dfs最後都要刪去最後一個元素
            temp.remove(temp.size() - 1);
        }
    }
}