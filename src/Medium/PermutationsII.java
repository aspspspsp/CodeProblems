package Medium;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return result;
        
        List<Integer> path = new ArrayList<>();
        
        //visited是紀錄已經拜訪過的數組
        int [] visited = new int[nums.length];
        for(int i = 0; i < visited.length; i ++) {
            visited[i] = 0;
        }
        
        permution(nums, visited, path, result);
        result = removeDuplicate(result);
        return result;
    }
    
    //去除重複的答案
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
            //若已經拜訪過則略過此數組
            if(visited[i] == 1)
                continue;
            
            visited[i] = 1;
            path.add(nums[i]);
            permution(nums, visited, path, result);
            
            //跟Permutations一樣，為了要保持此組合的當前狀態，故要將最後一個數刪除
            visited[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}