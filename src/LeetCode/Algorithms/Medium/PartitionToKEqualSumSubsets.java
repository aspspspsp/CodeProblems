package src.LeetCode.Algorithms.Medium;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 紀錄拜訪的位置，默認全部沒有拜訪過
        boolean[] visited = new boolean[nums.length];

        // 進行數組總和的計算
        int sum = 0;
        for(int i = 0; i < nums.length; i ++) {
            sum += nums[i];
        }

        // 若數組無法被k整除，表示k個集合的總和不可能相同
        if(sum % k != 0)
            return false;

        int target = sum / k;

        return dfs(nums, k, 0, target, 0, visited);
    }

    boolean dfs(int[] nums, int k, int start, int target, int cur_sum, boolean[] visited) {
        // 每個集合中的加總相同，返回true
        if(k == 1) {
            return true;
        }

        // 若當前集合符合時，則進行下一個集合的加總動作(並從nums數組的頭開始拜訪(回溯法套路))
        if(target == cur_sum) {
            return dfs(nums, k - 1, 0, target, 0, visited);
        }

        // 從start拜訪至數組末端
        for(int i = start; i < nums.length; i ++) {
            // 若這個位置已經被拜訪過則略過(回溯法套路)
            if(visited[i] == true)
                continue;

            // 標記這個位置已經被拜訪過
            visited[i] = true;

            // 拜訪這個位置的下一個位置，若所有集合加總相同，則將不成功的路徑剪枝(回溯法套路)
            if(dfs(nums, k, i + 1, target, cur_sum + nums[i], visited) == true)
                return true;

            // 記得消去標記(dfs套路)
            visited[i] = false;
        }

        return false;
    }
}
