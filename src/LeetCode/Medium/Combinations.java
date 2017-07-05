package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        //�Y��
        List<List<Integer>> result = new ArrayList<>();
        
        //����Y��
        List<Integer> temp = new ArrayList<>();
        
        //�M���������
        dfs(result, temp, n, k, 1);
        
        return result;
    }
    /*
    temp ����Y��
    n �����ق�
    k nȡk��
    m Ŀǰ��m���_ʼ
    */
    void dfs(List<List<Integer>> result, List<Integer> temp, int n, int k, int m) {
        //�Y��������ex:[1,2]������Y��
        if(k == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        //�������У��������ְ��L
        for(int i = m; i <= n; i ++) {
            temp.add(i);
            dfs(result, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}