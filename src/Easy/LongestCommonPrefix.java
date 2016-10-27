public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        
        String lcp = strs[0];
        
        if(lcp.equals("") == true)
                return "";      
                
        for(int i = 1; i < strs.length; i ++) {
            lcp = findCommonPrefix(strs[i], lcp);
            if(lcp.equals("") == true)
                return "";
        }
        
        return lcp;
    }
    
    String findCommonPrefix(String str, String commonPrefix) {
        for(int i = 0; i <= commonPrefix.length(); i ++) {
            String prefix_common = commonPrefix.substring(0, i);
            
            if(i > str.length()) {
                if(i == 0)
                    return "";
                return str.substring(0, i - 1);
            }
            
            String prefix_current = str.substring(0, i);
            if(prefix_common.equals(prefix_current) == false) {
                if(i == 0)
                    return "";
                return str.substring(0, i - 1);
            }
        }
        
        return commonPrefix;
    }
}