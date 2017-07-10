package LeetCode.Medium;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecodeString {
	public static String decodeString(String s) {
		Stack<Integer> count = new Stack<>();
		Stack<String> result = new Stack<>();
	
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
