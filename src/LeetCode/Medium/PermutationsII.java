package LeetCode.Medium;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return result;
        
        List<Integer> path = new ArrayList<>();
        
        //visited�Ǽo��ѽ����L�^�Ĕ��M
        int [] visited = new int[nums.length];
        for(int i = 0; i < visited.length; i ++) {
            visited[i] = 0;
        }
        
        permution(nums, visited, path, result);
        result = removeDuplicate(result);
        return result;
    }
    
    //ȥ�����}�Ĵ�
    List<List<Integer>> removeDuplicate(List<List<Integer>> list) {
        HashSet hashSet = new HashSet(list);
        list.clear();
        list.addAll(hashSet);
        
        return list;
    }
    
    void permution(int [] nums, int[] visited,
    List<Integer> path, List<List<Integer>> result) {
        int size = nums.length;
        if(size == path.size()) {
            List<Integer> complete = new ArrayList<Integer>(path);

            result.add(complete);
            return;
        }
        
        for(int i = 0; i < size; i ++) {
            //���ѽ����L�^�t���^�˔��M
            if(visited[i] == 1)
                continue;
            
            visited[i] = 1;
            path.add(nums[i]);
            permution(nums, visited, path, result);
            
            //��Permutationsһ�ӣ�����Ҫ���ִ˽M�ϵĮ�ǰ��B����Ҫ������һ�����h��
            visited[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}