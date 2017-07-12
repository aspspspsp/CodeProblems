package LeetCode.Hard;

public class RegularExpressionMatching {
    /**
        @para s: �ַ���
        @para p: ��Ҏ���_ʽ
    */
    public boolean isMatch(String s, String p) {
        // ����Ҏ���_ʽ�L�Ȟ�0�r
        if(p.length() == 0) {
            if(s.length() == 0)
                return true;
            else
                return false;
        }
        
        // ����Ҏ���_ʽ�L�Ȟ�1�r(special case)
        if(p.length() == 1) {
            // �ַ����L�Ȟ�0�r����false
            if(s.length() < 1)
                return false;
            // ����һ���ַ�����������Ҏ���_ʽ�ĕr�򷵻�false
            else if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))
                return false;
            // ���^ʣ�µ��ַ����c��Ҏ���_ʽ
            else
                return isMatch(s.substring(1), p.substring(1));
        }
        
        // ����Ҏ���_ʽ�ĵڶ�����Ԫ����'*'�r(case 1)
        if(p.charAt(1) != '*') {
            // �ַ����L�Ȟ�0�r����false
            if(s.length() < 1)
                return false;
             // ����һ���ַ�����������Ҏ���_ʽ�ĕr�򷵻�false
            else if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))
                return false;
            // ���^ʣ�µ��ַ����c��Ҏ���_ʽ
            else
                return isMatch(s.substring(1), p.substring(1));
        } 
        // ����Ҏ���_ʽ�ĵڶ�����Ԫ��'*'�r(case 2)������r����}�s
        else {
            // 
            if(isMatch(s, p.substring(2)) == true)
                return true;
            
            //
            int i = 0;
            while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if(isMatch(s.substring(i + 1), p.substring(2)))
                    return true;
                i ++;
            }
            
            return false;
        }
    }
}