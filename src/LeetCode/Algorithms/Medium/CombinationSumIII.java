package src.LeetCode.Algorithms.Medium;
import java.util.ArrayList;
/*
Input: k = 3, n = 9
[[1,2,6], [1,3,5], [2,3,4]]

這題是將1~n湊成只有k個的排列，每個數字只能用一次，一樣用dfs來解題
*/
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {        
        //存放結果數組
        List<List<Integer>> result = new ArrayList<>();
        
        //存放中間結果
        List<Integer> temp = new ArrayList<>();
        
        //從第1開始，題目要求
        int m = 1;
        
        //進行回溯查找
        helper(k, n, m, temp, result);
        
        //返回結果
        return result;
    }
    
    void helper(int k, int n, int m, List<Integer> temp, List<List<Integer>> result) {
        if(k == 0) {
            if(n == 0) {
                result.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        
        for(int i = m; i <= 9; i ++) {
            //為方便理解，cur為目前拜訪的數字
            int cur = i;
            
            //因為每個數字只能用一次，故要從m + 1開始走
            //ex: 1 2 3 4 -> step1. 1, step2. 2, step3. 3, step4. 4
            temp.add(i);
            
            //進行遞歸
            helper(k - 1, n - cur, i + 1, temp, result);
            
            //因為剛剛的暫存結果已經進行了遞歸，故要將已經遞歸後的數從暫存結果中刪去(避免結果中出現重複的數組)
            temp.remove(temp.size() - 1);
        }
    }
}
