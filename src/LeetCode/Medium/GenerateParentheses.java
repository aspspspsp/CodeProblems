package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
/*
�����Ƿ���һ���µķ���ʱ������������ѡ��:
���������ţ����߷���������
���ǰ�����������������n�������ţ���һ��ʣ��ɷ��������ž���һ����
��ʣ��ɷ��������������һ���������������ţ�����ǰ�����һ�������ţ�
���ǲ��ܷ�һ�������š��������Ǹ���ʣ��ɷ��������ţ���ʣ��ɷ�������
�ţ�����ݹ飬�Ϳ�����⡣    
*/
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int left = n;
        int right = 0;
        String tmp = "";
        
        helper(left, right, result, tmp);
        return result;
    }
    
    void helper(int left, int right, List<String> result, String tmp) {
        //�������̖�c����̖�������ˣ��t���õ�һ���Y��
        if(left == 0 && right == 0) {
            result.add(tmp);
            return;
        }
        
        //���ÿ��λ�ã��Ѓɂ��x��:
        //1.������̖
        //2.������̖
        if(left > 0) {
            helper(left - 1, right + 1, result, tmp + "(");
        }
        if(right > 0) {
            helper(left, right - 1, result, tmp + ")");
        }
    }
}
