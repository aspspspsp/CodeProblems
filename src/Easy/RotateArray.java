package Easy;
public class RotateArray {
    public void rotate(int[] nums, int k) {
        Stack<Integer> right = new Stack<Integer>();
        List<Integer> left = new ArrayList<Integer>();
        int [] result = new int[nums.length];
        
        for(int i = nums.length; i >= k; i --) {
            right.push(nums[i]);
        }
        
        for(int i = 0; i < nums.length - k; i ++) {
            left.add(nums[i]);
        }
        
        int s = 0;
        while(right.empty()) {
            result[s] = right.pop();
            s = s + 1;
        }
        
        for(int i = 0; i < left.size(); i ++) {
            result[s] = left.get(i);
            s = s + 1;
        }
        
    }
}