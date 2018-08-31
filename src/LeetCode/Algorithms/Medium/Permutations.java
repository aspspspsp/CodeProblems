package src.LeetCode.Algorithms.Medium;
/*
使用回溯法，想像每一個數都是一個狀態
ex:123
1.  1  2  3
2.  1,2  1,3  2,1  2,3  3,1  3,2
3.  1,2,3  1,3,2  2,1,3  2,3,1  3,1,2  3,2,1

*/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        
        List<Integer> path = new ArrayList<Integer>();
        dfs(path, result, nums);
        
        return result;
        
    }
    
    public void dfs(List<Integer> path, List<List<Integer>> result, int[] nums) {
        //若此組合的長度跟數組一樣，表示此數組已經組合完畢，則可以加入結果
        if(path.size() == nums.length) {
            //為了防止path的結果歸零，故在 new 一個
            List<Integer> complete = new ArrayList(path);
            result.add(complete);
            
            //此結果已經到頭了，結束
            return;
        }
        
        //每次進行下一步時，都要從數組的第一個元素拜訪(因為排列位置都不一樣)
        for(int i = 0; i < nums.length; i ++) {
            //若當前組合包含此數字則略過
            if(path.contains(nums[i])) {
                continue;
            }
            
            //將目前數字加入組合中
            path.add(nums[i]);
            
            //歷遍下一個狀態
            dfs(path, result, nums);
            
            //為了要保持此組合的當前狀態，故要將最後一個數刪除
            path.remove(path.size() - 1);
        }
    }
}