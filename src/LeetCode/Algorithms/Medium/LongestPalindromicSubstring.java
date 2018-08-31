package src.LeetCode.Algorithms.Medium;

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
    	//長度為零的情況下
    	if(s == null || s.length() == 0)
    		return "";
    	    	
    	
    	//初始最大回文字串(Ex: abc => a)
    	String longestPalindrome = s.substring(0, 1);
    	
    	//對每一個字符掃描
    	for(int i = 0; i < s.length(); i ++) {
    		//考慮中間只有一個字母，例如(abcba)的狀況
    		String tmp = getPalindrome(s, i, i);
    		if(tmp.length() > longestPalindrome.length()) {
    			longestPalindrome = tmp;
    		}
    		
    		//考慮中間有兩個字母一樣，例如(abccba)的狀況
    		tmp = getPalindrome(s, i, i + 1);
    		if(tmp.length() > longestPalindrome.length()) {
    			longestPalindrome = tmp;
    		}
    	}
    	
    	return longestPalindrome;
    }
    
    //�˷���ȡ�û����ִ�
    String getPalindrome(String s, int begin, int end) {
    	//不讓擷取的字符超過字串本身，然後儘量讓頭尾的字串一樣(達到回文的效果)
    	while(begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
    		
    		//字串逐漸往兩邊蔓延開
    		begin --;
    		end ++;
    	}
    	
    	//回傳目前回文的字串
    	return s.substring(begin + 1, end);
    }
}
