package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> sub_result = new ArrayList<>();
        List<String> result = new ArrayList<>();
        
        if(digits == "" || digits.length() == 0)
            return result;
        
        helpper(digits, 0, sub_result, result);
        
        return result;
    }
    
    void helpper(String digits, int cur_digit_index, List<String> sub_result, List<String> result) {
        if(cur_digit_index == digits.length()) {
            String sub_res = "";
            for(int i = 0; i < sub_result.size(); i ++)
                sub_res += sub_result.get(i);
            result.add(sub_res);
            return;
        }
        
        String [] combinations = {
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        int cur_digit = Integer.parseInt(String.valueOf(digits.charAt(cur_digit_index)));
        char[] words = combinations[cur_digit - 2].toCharArray();
        
        //再往下進行dfs
        for(int i = 0; i < words.length; i ++) {
            sub_result.add(String.valueOf(words[i]));
            helpper(digits, cur_digit_index + 1, sub_result, result);
            sub_result.remove(sub_result.size() - 1);
        }
    }
}