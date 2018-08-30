package src.LeetCode.Medium;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 先将']' 之前的信息（要重复的部分及重复次数）压到stack里，
 * 等到了']'再一个一个推出还原。思路非常清晰，但是实现起来并
 * 不简单。得注意细节及其处理方式，比如数字可能出现两位及以上
 * ; 并列关系［］,［］和包含关系［［］］如何巧妙区分。另外发
 * 现大循环用while而不是for可能更方便一些。
 */
public class DecodeString {
	public static String decodeString(String s) {
		Stack<Integer> count = new Stack<>();
		Stack<String> result = new Stack<>(); //用Stack处理包含关系
	
		result.push("");
		int i = 0;
		
		while(i < s.length()) {
			char a = s.charAt(i);
			if(a >= '0' && a <= '9') {
				int p1 = i;
				while(Character.isDigit(s.charAt(i + 1))) {
					i ++;
				}
				count.push(Integer.parseInt(s.substring(p1,  i + 1)));
			} else if(a == '[') {
				result.push(""); //用初始化空字符串处理并列关系
			} else if(a == ']') {
				String temp = new String(result.pop());
				StringBuilder sb = new StringBuilder();
				int nLoop = count.pop();
				for(int j = 0; j < nLoop; j ++) {
					sb.append(temp);
				}
				result.push(result.pop() + sb.toString());
			} else {
			    result.push(result.pop() + a);
            }
            i ++;
		}
		return result.pop();
	}
}
