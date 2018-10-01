package src.LeetCode.Algorithms.Medium;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        // �������Ǥ����w�g�Q���X�L
        boolean[] visited = new boolean[nums.length];

        // �q�C�@�Ӥ����}�l���X�A�ç��̤j�B��
        int max = 0;
        for(int num : nums)
            max = Math.max(max, dfs(nums, num, visited, 0));

        return max;
    }

    int dfs(int[] nums, int cur_pos, boolean[] visited, int step) {
        // �U�@�Ӧ�m
        int next_pos = nums[cur_pos];

        // �Y�U�@�Ӧ�m���X�L�A�h��^��e���B��
        if(visited[next_pos] == true)
            return step;

        int max = 0;

        // �аO�A�w�g���X�L

        visited[next_pos] = true;

        // ���̤j�B��
        max = Math.max(max, dfs(nums, next_pos, visited, step + 1));
        // �o�䤣�Ψ�dfs�ǲήM���A�^�ФW�@��(�]��call����A�ӥB�S�|�W��)

        return max;
    }
}
