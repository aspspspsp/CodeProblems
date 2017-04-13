package LeetCode.Medium;
/*
�ݹ飨Recursive�����취
���Ƚ����ֳ�10���������ĩλ��9�����ǽ����ּ�1
�ݹ�ʽ�����ڶ��������ȸ�����
*/

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    int _n;
    List<Integer> result;
    public List<Integer> lexicalOrder(int n) {
        result = new ArrayList<Integer>();
        _n = n;
        
        //��1�_ʼ
        slove(1);
        return result;
    }
    
    void slove(int m) {
        //����Y��
        result.add(m);
        
        //���Ƚ����ֳ�10�����M�Кv��
        if(m * 10 <= _n) {
            slove(m * 10);
        }
        
        //�������ĩλ<9�����ǽ����ּ�1
        //(m % 10ȡ��ĩβ����)
        if(m < _n && m % 10 < 9) {
            slove(m + 1);
        }
    }
}