package LeetCode.Medium;

/*
 * ����ÿ���Ӵ������ģ�������һ���ַ��������������ַ��ļ�϶���紮abc,���Ŀ�����
 * a,b,c,������ab�ļ�϶��bc�ļ�϶������aba�ǻ��ģ�
 * abbaҲ�ǻ��ģ����������Ҫ��������ǣ�������ͬʱ�� ��ɨ�裬ֱ�����ǻ�
 * �Ĵ�Ϊֹ��
 * �����ַ����ĳ���Ϊn,��ô���ĵĸ���Ϊ2*n-1(�ַ���Ϊ������n������϶��n-1������
 * ����ÿ������������ɨ��ĸ��� ��ΪO(n),����ʱ�临�Ӷ�ΪO((2*n-1)*n)=O(n^2)
 * ,�ռ临�Ӷ�ΪO(1)��
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	//�L�Ȟ������r��
    	if(s == null || s.length() == 0)
    		return "";
    	    	
    	
    	//��ʼ�������ִ�(Ex: abc => a) �Ϊ�һ����ĸҲ�����
    	String longestPalindrome = s.substring(0, 1);
    	
    	//��ÿһ���ַ�����
    	for(int i = 0; i < s.length(); i ++) {
    		//���]���gֻ��һ����ĸ������(abcba)�Ġ�r
    		String tmp = getPalindrome(s, i, i);
    		if(tmp.length() > longestPalindrome.length()) {
    			longestPalindrome = tmp;
    		}
    		
    		//���]���g�Ѓɂ���ĸһ�ӣ�����(abccba)�Ġ�r
    		tmp = getPalindrome(s, i, i + 1);
    		if(tmp.length() > longestPalindrome.length()) {
    			longestPalindrome = tmp;
    		}
    	}
    	
    	return longestPalindrome;
    }
    
    //�˷���ȡ�û����ִ�
    String getPalindrome(String s, int begin, int end) {
    	//��׌�Xȡ���ַ����^�ִ�����Ȼ�Ⴭ��׌�^β���ִ�һ��(�_�����ĵ�Ч��)�����^β��һ�ӄt���ǻ��Ąt����
    	while(begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
    		
    		//�ִ���u����߅�����_
    		begin --;
    		end ++;
    	}
    	
    	//�؂�Ŀǰ���ĵ��ִ�
    	return s.substring(begin + 1, end);
    }
}
