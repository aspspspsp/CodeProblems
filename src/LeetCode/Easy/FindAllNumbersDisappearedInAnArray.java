package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        //hash�Ǽo�ÿ�������F�^�ĴΔ�
        int [] hash = new int[length + 1];
        
        //�v��һ��num���M���o�ÿ�������F�^�ĴΔ�(��1�_ʼ)
        for(int i = 0; i < length; i ++) {
            hash[nums[i]] ++;
        }
        
        //�����F�Δ���0�ķ���𰸮���(��1�_ʼ)
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i <= length; i ++) {
            if(hash[i] == 0)
                result.add(i);
        }
        
        return result;
    }
}