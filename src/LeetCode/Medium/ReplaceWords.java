package src.LeetCode.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        if(dict == null || dict.size() == 0 || sentence == null || sentence.equals("") || sentence.length() == 0){
            return "";
        }
        
        //利用HashSet來做辭典，避免超時的問題(效率較高)
        Set<String> dict_set = new HashSet<String>();
        
        //將dict所有結果存入HashSet
        dict_set.addAll(dict);
        
        //以空白來切割
        String[] words = sentence.split(" ");
        
        for(int i = 0; i < words.length; i ++) {
            String word = words[i];
            //將字符串進行縮寫的枚舉(從前面枚舉至後面)
            for(int j = 0; j <= word.length(); j ++) {
                String sub_word = word.substring(0, j);
                //若縮寫有在辭典中則進行替換
                if(dict_set.contains(sub_word) == true) {
                    words[i] = sub_word;
                    break;
                }
            }
        }
        
        //組查答案
        String result = "";
        for(int i = 0; i < words.length; i ++) {
            result += words[i] + " ";
        }
        
        //別忘了最後一個空格要去掉
        return result.substring(0, result.length() - 1);
    }
}
