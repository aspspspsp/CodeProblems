package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        //��ŽY��
        List<List<String>> result = new ArrayList<>();
        
        if(s == null || s.length() == 0) {
            return result;
        }
        
        //�������ִ��ĽY��
        List<String> palindromes = new ArrayList<>();
        
        //�ĵ�һ����Ԫ�_ʼ���L
        dfs(s, 0, palindromes, result);
        
        return result;
    }
    
    void dfs(String s, int start_position, List<String> palindromes,
                List<List<String>> result) {
        /*�����L�����ִ��ѽ���s�ĽYβ�r��
        �͌���start_position�_ʼ(�����palindromes��)���������ִ�����Y����
        */
        if(start_position == s.length()) {
            result.add(new ArrayList<String>(palindromes));
            //�K�ҽY��
            return;
        }
        
        //��start_position�_ʼ����Ԫ���L���ִ��Yβ�����L���ִ�
        for(int i = start_position + 1; i <= s.length(); i ++) {
            String sub_str = s.substring(start_position, i);
            
            //�����ִ����ǻ��Ąt�M����һ��loop
            if(isPalindrome(sub_str) == false) {
                continue;
            }
            
            //���땺��Y����
            palindromes.add(sub_str);
            
            //�ُĵ�i���_ʼ���L���ִ�
            dfs(s, i, palindromes, result);
            
            /*�P�dfs���}Ŀ:
            ��һ�ΰ��Lѭ�h�ᣬһ��Ҫ������𰸵�����һ��Ԫ��ȥ������Ȼ�𰸕��e�`
            */
            palindromes.remove(palindromes.size() - 1);
        }
    }
    
    //�z���Ƿ�����
    boolean isPalindrome(String str) {
        if(str == null || str.length() == 0) {
            return false;
        }
        
        for(int i = 0; i < str.length(); i ++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        
        return true;
    }
}