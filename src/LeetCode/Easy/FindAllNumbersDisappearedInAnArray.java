package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        //hash是紀錄每個數出現過的次數
        int [] hash = new int[length + 1];
        
        //歷遍一次num數組，紀錄每個數出現過的次數(從1開始)
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