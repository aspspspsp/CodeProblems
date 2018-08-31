package src.LeetCode.Easy;

import java.util.HashMap;

public class ReverseStringII {
    public String reverseStr(String s, int k) {
        /*
         k(需要翻轉)    + 2k(不需翻轉)   + 3k(需要翻轉)   + 4k(不需翻轉)
        _______________+_______________+_______________+_______________
        
        */
        if(s == null || s.length() == 0)
            return s;
        
        int n = s.length();
        if(k >= n) {
            StringBuffer sb = new StringBuffer(s);
            return sb.reverse().toString();
        }
        
        char[] cs = s.toCharArray();
        
        HashMap<Integer, StringBuffer> sbs = new HashMap<>();
        
        for(int i = 0; i < n; i ++) {
            if(sbs.containsKey(i / k) == false) {
                sbs.put(i / k, new StringBuffer(cs[i] + ""));
            } else {
                StringBuffer sb = sbs.get(i / k);
                sb.append(cs[i] + "");
                sbs.put(i / k, sb);
            }
        }
        
        StringBuffer result = new StringBuffer("");

        for(int i = 0; i < n; i ++) {
            if(sbs.containsKey(i) == false)
                break;
            
            if(i % 2 == 0)
                result.append(sbs.get(i).reverse());
            else
                result.append(sbs.get(i));
        }
        
        return result.toString();
    }
}
