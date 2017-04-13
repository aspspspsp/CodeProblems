package LeetCode.Easy;

import java.util.HashMap;

// �鿴�������Ƿ����ظ�Ԫ���������ظ�Ԫ���������������K
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1) {
            return false;
        }
        //�o�<key, λ��>
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            //���������}Ԫ��
            if(hashMap.containsKey(nums[i])) {
                //�z���g���Ƿ���k
                if((i - hashMap.get(nums[i])) <= k) {
                    return true;
                }
            }
            
            //�o�ԓ���cλ��
            hashMap.put(nums[i], i);
        }
        
        return false;
    }
}