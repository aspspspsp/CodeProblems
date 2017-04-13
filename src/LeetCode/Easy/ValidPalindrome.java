package LeetCode.Easy;
/*
�@�}����ИO����ַ�������Ҫʹ��ǰ��ָᘵķ�ʽ��ֹ�\�Еr�g�^�L
*/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        
        //����ָ��M���ַ���ǰ����^
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end) {
            //ǰ��ָ����������Է����ǿհׄt���^
            while(start < s.length() && isValid(s.charAt(start)) == false) {
                start ++;
            }
            
            if(start == s.length()) {
                return true;
            }
            
            //����ָ����������Է����ǿհׄt���^
            while(end >= 0 && isValid(s.charAt(end)) == false) {
                end --;
            }
            
            //�M���ַ����^������ǰ�Է���һ�ӄt����false
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            //һ�ӄtǰ��ָ����ᣬ����ָ���ǰ
            } else {
                start ++;
                end --;
            }
        }
        
        return true;
    }
    
    //�z��ԓ�ַ��Ƿ�锵�ֻ�����ĸ
    boolean isValid(char c) {
        if(Character.isLetter(c))
            return true;
        if(Character.isDigit(c))
            return true;
            
        return false;
    }
}