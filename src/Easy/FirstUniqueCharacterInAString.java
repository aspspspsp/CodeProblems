package Easy;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < s.length(); i ++) {
            String cur = s.substring(i, i + 1);
            
            if(map.containsKey(cur) == false)
                map.put(cur, 1);
            else {
                int stringLeng = map.get(cur);
                map.put(cur, stringLeng + 1);
            }
        }
        
        for(int i = 0; i < s.length(); i ++) {
            String cur = s.substring(i, i + 1);
            int stringLeng = map.get(cur);
            if(stringLeng == 1) {
                return i;
            }
        }
        
        return -1;
    }
    
}