package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        //������(�����ִ��g�ı��^)
        Arrays.sort(nums);
        
        //�Á탦��ÿһ��dfs�ĽY��
        ArrayList<Integer> temp_list = new ArrayList<>();
        
        subsetHelper(result, temp_list, nums, 0);
        
        return result;
    }
    
    void subsetHelper(List<List<Integer>> result,
        ArrayList<Integer> temp_list, int[] nums, int start_position) {
            
        //����dfs��̽���������M����a������
        for(int i = start_position; i < nums.length; i ++) {
            //���ڵ�ǰ�ַ��������һ���ַ���֮��ȣ�����˵���
            if(i > start_position && nums[i] == nums[i - 1]) {
                continue;
            }
            
            //���뮔ǰ����
            temp_list.add(nums[i]);
            
            //�M����һ��λ�õ�dfs
            subsetHelper(result, temp_list, nums, i + 1);
            
            //dfs��ÿһ݆һ��Ҫ��temp������һ��Ԫ�؄h�����Ų��������e�`
            temp_list.remove(temp_list.size() - 1);
        }
        
        //��ÿ��dfs�ĽY������
        result.add(new ArrayList<Integer>(temp_list));
    }
}