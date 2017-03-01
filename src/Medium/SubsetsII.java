package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        //先排序(以利字串間的比較)
        Arrays.sort(nums);
        
        //用來儲存每一次dfs的結果
        ArrayList<Integer> temp_list = new ArrayList<>();
        
        subsetHelper(result, temp_list, nums, 0);
        
        return result;
    }
    
    void subsetHelper(List<List<Integer>> result,
        ArrayList<Integer> temp_list, int[] nums, int start_position) {
            
        //利用dfs來探索整個數組，來產生排列
        for(int i = start_position; i < nums.length; i ++) {
            //对于当前字符，如果上一个字符与之相等，则过滤掉。
            if(i > start_position && nums[i] == nums[i - 1]) {
                continue;
            }
            
            //加入當前數字
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