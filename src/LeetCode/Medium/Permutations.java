package LeetCode.Medium;
/*
ʹ�û��ݷ�������ÿһ��������һ����B
ex:123
1.  1  2  3
2.  1,2  1,3  2,1  2,3  3,1  3,2
3.  1,2,3  1,3,2  2,1,3  2,3,1  3,1,2  3,2,1

*/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        
        List<Integer> path = new ArrayList<Integer>();
        dfs(path, result, nums);
        
        return result;
        
    }
    
    public void dfs(List<Integer> path, List<List<Integer>> result, int[] nums) {
        //���˽M�ϵ��L�ȸ����Mһ�ӣ���ʾ�˔��M�ѽ��M���ꮅ���t���Լ���Y��
        if(path.size() == nums.length) {
            //���˷�ֹpath�ĽY���w�㣬���� new һ��
            List<Integer> complete = new ArrayList(path);
            result.add(complete);
            
            //�˽Y���ѽ����^�ˣ��Y��
            return;
        }
        
        
        for(int i = 0; i < nums.length; i ++) {
            //����ǰ�M�ϰ����˔��քt���^
            if(path.contains(nums[i])) {
                continue;
            }
            
            //��Ŀǰ���ּ���M����
            path.add(nums[i]);
            
            //�v����һ����B
            dfs(path, result, nums);
            
            //����Ҫ���ִ˽M�ϵĮ�ǰ��B����Ҫ������һ�����h��
            path.remove(path.size() - 1);
        }
    }
}