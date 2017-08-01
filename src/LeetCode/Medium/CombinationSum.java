package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
這題因為是數組是有序的，故不用進行排序，所以可以直接進行dfs，而不用怕答案重複
1. 對數組中的數字進行逐步拜訪
2. 再從該數組出發(下一步從自己出發，因為每個數可以用兩次)，拜訪至數組結尾
3. 拜訪到完成目標(達到目標數)為止，但若達不到目標(暫存目標數<0)，則跳出
*/

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //存放結果數組
        List<List<Integer>> result = new ArrayList<>();
        
        //存放中間結果s
        List<Integer> temp = new ArrayList<>();
        
        //從第0歩開始
        int m = 0;
        
        //進行回溯查找
        helper(candidates, target, m, result, temp);
        
        //返回結果
        return result;
    }
    
    void helper(int[] candidates, int target, int m, List<List<Integer>> result, List<Integer> temp) {
        //若target == 0表示temp內的結果加起來等於target(满足条件，将中間結果加入結果數組)
    	if(target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        if(target < 0)
            return;
        
        //從candidates數組中找符合條件的中間集
        for(int i = m; i < candidates.length; i ++) {
            int cur = candidates[i];
            
            //將符合條件的candidates放入中間結果
            temp.add(cur);
            
            //進行遞歸
            helper(candidates, target - cur, i, result, temp);
            
            //因為剛剛的暫存結果已經進行了遞歸，故要將已經遞歸後的數從暫存結果中刪去(避免結果中出現重複的數組)
            temp.remove(temp.size() - 1);
        }
    }
}