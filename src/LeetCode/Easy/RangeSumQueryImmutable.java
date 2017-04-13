package LeetCode.Easy;
public class RangeSumQueryImmutable {
    int[] numbers;
    public RangeSumQueryImmutable(int[] nums) {
        numbers = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for(int counter = i; counter <= j; counter ++) {
            sum += numbers[counter];
        }
        
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);