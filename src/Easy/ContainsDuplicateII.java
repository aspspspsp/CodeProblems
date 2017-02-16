package Easy;

import java.util.HashMap;

// 查看数组内是否有重复元素且相邻重复元素索引间隔不大于K
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1) {
            return false;
        }
        //紀錄<key, 位置>
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            //若包含重複元素
            if(hashMap.containsKey(nums[i])) {
                //檢查間隔是否大於k
                if((i - hashMap.get(nums[i])) <= k) {
                    return true;
                }
            }
            
            //紀錄該數與位置
            hashMap.put(nums[i], i);
        }
        
        return false;
    }
}