package src.LeetCode.Algorithms.Easy;

public class BinarySearch {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {
            int m = l + (r - l) / 2;

            if(target == nums[m])
                return m;

            if(nums[m] > target)
                r = m - 1;

            if(nums[m] < target)
                l = m + 1;

        }

        return -1;
    }
}
