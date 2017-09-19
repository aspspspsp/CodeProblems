package LeetCode.Medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ImplementMagicDictionary {
    private Set<String> set;
    /** Initialize your data structure here. */
    public ImplementMagicDictionary() {
        set = new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s : dict) {
            set.add(s);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        Iterator it = set.iterator();
        while(it.hasNext()) {
            String str = (String)it.next();
            
            //若兩個字串的長度不一樣，就跳過這個
            if(word.length() != str.length())
                continue;
            
            //兩個字都一樣，就跳過這個
            if(word.equals(str) == true)
                continue;
            
            //只有一個字不一樣，則返回true
            if(isMagicWord(word, str) == true)
                return true;
        }
        
        return false;
    }
    
    private boolean isMagicWord(String a, String b) {
        int different = 0;
        
        for(int i = 0; i < a.length(); i ++) {
            if(a.charAt(i) != b.charAt(i))
                different ++;
            
            if(different > 1)
                return false;
            
        }
        
        if(different == 1)
            return true;
        
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */