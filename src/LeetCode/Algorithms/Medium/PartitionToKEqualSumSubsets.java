package src.LeetCode.Algorithms.Medium;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // �������X����m�A�q�{�����S�����X�L
        boolean[] visited = new boolean[nums.length];

        // �i��Ʋ��`�M���p��
        int sum = 0;
        for(int i = 0; i < nums.length; i ++) {
            sum += nums[i];
        }

        // �Y�ƲյL�k�Qk�㰣�A���k�Ӷ��X���`�M���i��ۦP
        if(sum % k != 0)
            return false;

        int target = sum / k;

        return dfs(nums, k, 0, target, 0, visited);
    }

    boolean dfs(int[] nums, int k, int start, int target, int cur_sum, boolean[] visited) {
        // �C�Ӷ��X�����[�`�ۦP�A��^true
        if(k == 1) {
            return true;
        }

        // �Y��e���X�ŦX�ɡA�h�i��U�@�Ӷ��X���[�`�ʧ@(�ñqnums�Ʋժ��Y�}�l���X(�^���k�M��))
        if(target == cur_sum) {
            return dfs(nums, k - 1, 0, target, 0, visited);
        }

        // �qstart���X�ܼƲե���
        for(int i = start; i < nums.length; i ++) {
            // �Y�o�Ӧ�m�w�g�Q���X�L�h���L(�^���k�M��)
            if(visited[i] == true)
                continue;

            // �аO�o�Ӧ�m�w�g�Q���X�L
            visited[i] = true;

            // ���X�o�Ӧ�m���U�@�Ӧ�m�A�Y�Ҧ����X�[�`�ۦP�A�h�N�����\�����|�ŪK(�^���k�M��)
            if(dfs(nums, k, i + 1, target, cur_sum + nums[i], visited) == true)
                return true;

            // �O�o���h�аO(dfs�M��)
            visited[i] = false;
        }

        return false;
    }
}
