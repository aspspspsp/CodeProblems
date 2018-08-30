package src.LeetCode.Medium;

import java.util.List;

public class WordBreak {
	/*
這題可以用動態規劃來解，步驟如下：
定義一個數組results[] 然後讓results[i] = true => 0 - (i - 1)，也就是字串可以被字典裏面的字分割
然後初始狀態results[0] = true
	 */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] results = new boolean[s.length() + 1]; 
        results[0] = true; //第一個結果必為true,因為需要一個初始狀態
        
        //子串開頭指針
        for(int start = 0; start < s.length(); start ++) {
            
            if(results[start] == false) {
                continue;
            }
                
            for(String cur_word : wordDict) {
            	//子串結尾指針，
                int end = start + cur_word.length();
                if(end > s.length()) {
                    continue;
                }
                
                if(results[end] == true) {
                    continue;
                }
                
                //若這個子串為字典中某個字
                if(s.substring(start, end).equals(cur_word)) {
                    results[end] = true;
                }
            }
        }
        return results[s.length()];
        
    }
}