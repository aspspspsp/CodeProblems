/*
本题采用回溯算法。
1. 基本思路是先排好序，这样做的目的是为了对数组后面不可能出现的情况进行排除，有利于减少查找时间，即剪枝操作
2. 外层循环对数组元素依次进行遍历，依次将 nums 中的元素加入中间集，一旦满足条件，就将中间集加入结果集
3. 然后每次递归中把剩下的元素一一加到结果集合中，并且把目标减去加入的元素，然后把剩下元素（包括当前加入的元素）放到下一层递归中解决子问题。
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        //對候選數組進行排序
        Arrays.sort(candidates);
        
        //存放結果數組
        List<List<Integer>> result = new ArrayList<>();
        
        //存放中間結果
        List<Integer> temp = new ArrayList<>();
        
        //進行回溯查找
        result = dfs(result, temp, target, candidates, 0);
        
        //返回結果
        return result;
    }
    
    List<List<Integer>> dfs(List<List<Integer>> result, List<Integer> temp, int target, 
        int[] candidates, int j) {
        
        //若target == 0表示temp內的結果加起來等於target(满足条件，将中間結果加入結果數組)
        if(target == 0) {
            result.add(new ArrayList<>(temp));
        }
        
        //從candidates串中找符合條件的中間集，target>=candidates[i]是剪枝操作
        for(int i = j; i < candidates.length && target >= candidates[i]; i ++) {
            
            //將符合條件的candidates放入中間結果
            temp.add(candidates[i]);
            
            //進行遞歸
            result = dfs(result, temp, target - candidates[i], candidates, i);
            
            //因為剛剛的暫存結果已經進行了遞歸，故要將已經遞歸後的數從暫存結果中刪去(避免結果中出現重複的數組)
            temp.remove(temp.size() - 1);
        }
        
        return result;
    }
}