package src.LeetCode.Algorithms.Medium;

public class MatchsticksToSquare {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4)
            return false;

        //�p��[�`
        int sum = 0;
        for(int i = 0; i < nums.length; i ++)
            sum += nums[i];

        //�L�o�����i�઺���p
        if(sum % 4 != 0)
            return false;

        return dfs(0, nums, sum / 4, 0, 0, 0, 0);
    }

    boolean dfs(int index, int[] nums, int target, int a, int b, int c, int d) {
        if(index == nums.length) {
            if(a == target && b == target && c == target && d == target)
                return true;

            return false;
        }

        // �ŪK
        if(a > target || b > target || c > target || d > target)
            return false;

        boolean isValid = false;
        isValid |= dfs(index + 1, nums, target, a + nums[index], b, c, d);
        // ������^���G
        if(isValid == true)
            return true;

        isValid |= dfs(index + 1, nums, target, a, b + nums[index], c, d);
        // ������^���G
        if(isValid == true)
            return true;

        isValid |= dfs(index + 1, nums, target, a, b, c + nums[index], d);
        // ������^���G
        if(isValid == true)
            return true;

        isValid |= dfs(index + 1, nums, target, a, b, c, d + nums[index]);
        // ������^���G
        if(isValid == true)
            return true;

        return isValid;
    }
}
