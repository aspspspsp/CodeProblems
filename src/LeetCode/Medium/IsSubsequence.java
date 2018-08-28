class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.equals(""))
            return true;
        
        if(t == null || t.equals(""))
            return false;
        
        
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        
        int j = 0;
        for(int i = 0; i < tt.length; i ++) {
            if(tt[i] == ss[j]) {
                j ++;
            }
            if(j == ss.length)
                return true;
        }
        
        if(j == ss.length)
            return true;
        
        return false;
    }
}
