package LeetCode.Medium;

public class JumpGame {
/*
贪心算法即可。
我们维护一个变量right，表示当前可以到达的最右位置，然后遍历数组处理如下情况：
    1）发现当前可以到达的最右位置right小于当前位置，表示无法跳到该位置，直接返回false；
    2）更新right的值；
    3）如果更新后的right的值大于等于最后一个元素的索引，表示从当前位置就可以调到末尾，直接返回true。
算法的时间复杂度O(n)，空间复杂度O(1)。
*/
    public boolean canJump(int[] nums) {
        int right = 0; // 可以到達的最右邊位置
        for(int i = 0; i < nums.length; i ++) {
            if(right < i) {
                return false;
            }
            
            right = Math.max(right, i + nums[i]);
            if(right >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}