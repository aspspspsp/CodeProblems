package src.LeetCode.Medium;
public class RangeSumQueryMutable {
    int[] nums;
    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
    }
    
    public void update(int i, int val) {
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        int result = 0;
        for(int a = i; a <= j; a ++) {
            result += this.nums[a];
        }
        
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */