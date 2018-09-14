package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();

        dfs(0, nums, new ArrayList(), resultSet);

        List<List<Integer>> result = new ArrayList(resultSet);

        return result;
    }


    void dfs(int start, int[] nums, List<Integer> tmp, Set<List<Integer>> resultSet) {
        // 從該位置開始向後找尋遞增數列
        for(int i = start; i < nums.length; i ++) {
            // 開始做遞增數列(前一個數>大於最後一個數)
            if(tmp.size() == 0 || nums[i] >= tmp.get(tmp.size() - 1)) {
                // 放入符合條件的數
                tmp.add(nums[i]);

                // 將該遞增序列放入答案set
                if(tmp.size() >= 2)
                    resultSet.add(new ArrayList(tmp));

                // 進行下一個位置的歷遍
                dfs(i + 1, nums, tmp, resultSet);

                // dfs一定要做這個動作，不然會多東西
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
