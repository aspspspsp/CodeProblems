package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
������û����㷨��
1. ����˼·�����ź�����������Ŀ����Ϊ�˶�������治���ܳ��ֵ���������ų��������ڼ��ٲ���ʱ�䣬����֦����
2. ���ѭ��������Ԫ�����ν��б��������ν� nums �е�Ԫ�ؼ����м伯��һ�������������ͽ��м伯��������
3. Ȼ��ÿ�εݹ��а�ʣ�µ�Ԫ��һһ�ӵ���������У����Ұ�Ŀ���ȥ�����Ԫ�أ�Ȼ���ʣ��Ԫ�أ�������ǰ�����Ԫ�أ��ŵ���һ��ݹ��н�������⡣
*/

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        //對候選數組進行排序
        Arrays.sort(candidates);
        
        //存放結果數組
        List<List<Integer>> result = new ArrayList<>();
        
        //存放中間結果s
        List<Integer> temp = new ArrayList<>();
        
        //進行回溯查找
        result = dfs(result, temp, target, candidates, 0);
        
        //返回結果
        return result;
    }
    
    List<List<Integer>> dfs(List<List<Integer>> result, List<Integer> temp, int target, 
        int[] candidates, int j) {
        
        //若target == 0表示temp內的結果加起來等於target(满足条件，将中間結果加入結果數組)
        if(target == 0) {
            result.add(new ArrayList<>(temp));
        }
        
        //從candidates串中找符合條件的中間集，target>=candidates[i]是剪枝操作
        for(int i = j; i < candidates.length && target >= candidates[i]; i ++) {
            
            //將符合條件的candidates放入中間結果
            temp.add(candidates[i]);
            
            //進行遞歸
            result = dfs(result, temp, target - candidates[i], candidates, i);
            
            //因為剛剛的暫存結果已經進行了遞歸，故要將已經遞歸後的數從暫存結果中刪去(避免結果中出現重複的數組)
            temp.remove(temp.size() - 1);
        }
        
        return result;
    }
}