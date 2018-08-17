class Solution {
    public String licenseKeyFormatting(String S, int K) {
        
        char[] cs = S.toCharArray();
        
        // 利用StringBuffer是為了自符串操作不耗時
        StringBuffer result = new StringBuffer("");
        
        // 由後往前做
        int counter = 0;
        for(int i = cs.length; i >= 1; i --) {
            char cur = cs[i - 1];
            if(cur == '-')
                continue;
            
            if(cur - 'a' >= 0)
                cur = (char)(cur - 32);
                
            result.append(cur);
            counter ++;
            if(counter == K) {
                result = result.append('-');
                counter = 0;
            }
        }
        
        if(result.length() > 0 && result.charAt(result.length() - 1) == '-')
            result.delete(result.length() - 1, result.length());
        
        return result.reverse().toString();
    }
}
