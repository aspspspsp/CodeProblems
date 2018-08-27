class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return result;
        
        for(int i = 0; i < nums.length; i ++) {
            /* 因為數值只會出現一次，而且都是正數，而且數字只會出現1~n(n為陣列大小)
               所以我們利用這種特性來做標記(0~n-1的位置紀錄1~n是否出現重複的狀況，
               正數為1次或是不出現，負數為出現2次) */
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                result.add(index + 1);
            
            nums[index] = -nums[index];
        }
        
        return result;
    }
}
