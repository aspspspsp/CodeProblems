package src.LeetCode.Algorithms.Medium;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        // 紀錄哪些元素已經被拜訪過
        boolean[] visited = new boolean[nums.length];

        // 從每一個元素開始拜訪，並找到最大步數
        int max = 0;
        for(int num : nums)
            max = Math.max(max, dfs(nums, num, visited, 0));

        return max;
    }

    int dfs(int[] nums, int cur_pos, boolean[] visited, int step) {
        // 下一個位置
        int next_pos = nums[cur_pos];

        // 若下一個位置拜訪過，則返回當前的步數
        if(visited[next_pos] == true)
            return step;

        int max = 0;

        // 標記，已經拜訪過

        visited[next_pos] = true;

        // 找到最大步數
        max = Math.max(max, dfs(nums, next_pos, visited, step + 1));
        // 這邊不用到dfs傳統套路，回覆上一動(因為call不到，而且又會超時)

        return max;
    }
}
