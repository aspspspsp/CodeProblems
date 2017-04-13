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
        
        //�����x���M�M������
        Arrays.sort(candidates);
        
        //��ŽY�����M
        List<List<Integer>> result = new ArrayList<>();
        
        //������g�Y��
        List<Integer> temp = new ArrayList<>();
        
        //�M�л��ݲ���
        result = dfs(result, temp, target, candidates, 0);
        
        //���ؽY��
        return result;
    }
    
    List<List<Integer>> dfs(List<List<Integer>> result, List<Integer> temp, int target, 
        int[] candidates, int j) {
        
        //��target == 0��ʾtemp�ȵĽY����������target(���������������g�Y������Y�����M)
        if(target == 0) {
            result.add(new ArrayList<>(temp));
        }
        
        //��candidates�����ҷ��ϗl�������g����target>=candidates[i]�Ǽ�֦����
        for(int i = j; i < candidates.length && target >= candidates[i]; i ++) {
            
            //�����ϗl����candidates�������g�Y��
            temp.add(candidates[i]);
            
            //�M���f�w
            result = dfs(result, temp, target - candidates[i], candidates, i);
            
            //��鄂���ĕ���Y���ѽ��M�����f�w����Ҫ���ѽ��f�w��Ĕ��ĕ���Y���Єhȥ(����Y���г��F���}�Ĕ��M)
            temp.remove(temp.size() - 1);
        }
        
        return result;
    }
}