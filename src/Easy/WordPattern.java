package Easy;
import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<String, String> key = new HashMap<String, String>();
        
        String[] strs = str.split(" ");
        
        if(strs.length == pattern.length() && strs.length == 1) {
            return true;
        }
        
        if(strs.length != pattern.length()) {
            return false;
        }
        
        for(int i = 0; i < strs.length; i ++) {
            String pat = pattern.substring(i, i + 1);
            String str_word = strs[i];
            String key_word;
            
            if(key.containsValue(strs[i]) == false) {
            	if(key.containsKey(pat)) {
            		return false;
            	} else {
            		key.put(pat, str_word);
            	}
            }
            
            key_word = key.get(pat);
            
            if(key_word == null) {
                return false;
            }
            
            if(key_word.equals(str_word) == false) {
                return false;
            }
        }
        
        return true;
    }
}