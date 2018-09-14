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
        // �q�Ӧ�m�}�l�V���M���W�ƦC
        for(int i = start; i < nums.length; i ++) {
            // �}�l�����W�ƦC(�e�@�Ӽ�>�j��̫�@�Ӽ�)
            if(tmp.size() == 0 || nums[i] >= tmp.get(tmp.size() - 1)) {
                // ��J�ŦX���󪺼�
                tmp.add(nums[i]);

                // �N�ӻ��W�ǦC��J����set
                if(tmp.size() >= 2)
                    resultSet.add(new ArrayList(tmp));

                // �i��U�@�Ӧ�m�����M
                dfs(i + 1, nums, tmp, resultSet);

                // dfs�@�w�n���o�Ӱʧ@�A���M�|�h�F��
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
