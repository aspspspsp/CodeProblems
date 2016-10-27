package Medium;

/*
 * 对于每个子串的中心（可以是一个字符，或者是两个字符的间隙比如串abc,中心可以是
 * a,b,c,或者是ab的间隙，bc的间隙，例如aba是回文，
 * abba也是回文，这两种情况要分情况考虑）往两边同时进 行扫描，直到不是回
 * 文串为止。
 * 假设字符串的长度为n,那么中心的个数为2*n-1(字符作为中心有n个，间隙有n-1个）。
 * 对于每个中心往两边扫描的复杂 度为O(n),所以时间复杂度为O((2*n-1)*n)=O(n^2)
 * ,空间复杂度为O(1)。
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	//長度為零的情況下
    	if(s == null || s.length() == 0)
    		return "";
    	    	
    	
    	//初始最大回文字串(Ex: abc => a) 單獨一個字母也算回文
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
    
    //此方法取得回文字串
    String getPalindrome(String s, int begin, int end) {
    	//不讓擷取的字符超過字串本身，然後儘量讓頭尾的字串一樣(達到回文的效果)，若頭尾不一樣則不是回文則跳出
    	while(begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
    		
    		//字串逐漸往兩邊蔓延開
    		begin --;
    		end ++;
    	}
    	
    	//回傳目前回文的字串
    	return s.substring(begin + 1, end);
    }
}
