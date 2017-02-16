package Medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        //存放結果
        List<List<String>> result = new ArrayList<>();
        
        if(s == null || s.length() == 0) {
            return result;
        }
        
        //暫存子字串的結果
        List<String> palindromes = new ArrayList<>();
        
        //從第一個字元開始拜訪
        dfs(s, 0, palindromes, result);
        
        return result;
    }
    
    void dfs(String s, int start_position, List<String> palindromes,
                List<List<String>> result) {
        /*若拜訪的子字串已經到s的結尾時，
        就將從start_position開始(暫存於palindromes中)的所有子字串加入結果中
        */
        if(start_position == s.length()) {
            result.add(new ArrayList<String>(palindromes));
            //並且結束
            return;
        }
        
        //從start_position開始逐字元拜訪至字串結尾，拜訪子字串
        for(int i = start_position + 1; i <= s.length(); i ++) {
            String sub_str = s.substring(start_position, i);
            
            //若子字串不是回文則進行下一個loop
            if(isPalindrome(sub_str) == false) {
                continue;
            }
            
            //加入暫存結果中
            palindromes.add(sub_str);
            
            //再從第i個開始拜訪子字串
            dfs(s, i, palindromes, result);
            
            /*關於dfs的題目:
            在一次拜訪循環後，一定要將暫存答案的最後一個元素去除，不然答案會錯誤
            */
            palindromes.remove(palindromes.size() - 1);
        }
    }
    
    //檢查是否為回文
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