package Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return result;
        
        //用來儲存每一次dfs的結果
        ArrayList<Integer> temp_list = new ArrayList<>();
        
        subsetHelper(result, temp_list, nums, 0);
        
        return result;
    }
    
    void subsetHelper(List<List<Integer>> result,
            ArrayList<Integer> temp_list, int[] nums, int start_position) {
        //利用dfs來探索整個數組，來產生排列
        for(int i = start_position; i < nums.length; i ++) {
            temp_list.add(nums[i]);
            
            //進行下一個位置的dfs
            subsetHelper(result, temp_list, nums, i + 1);
            
            //dfs在每一輪一定要將temp的最後一個元素刪除，才不會導致錯誤
            temp_list.remove(temp_list.size() - 1);
        }
        
        //把每次dfs的結果存入
        result.add(new ArrayList<Integer>(temp_list));
    }
}