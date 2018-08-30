package src.LeetCode.Medium;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * �Ƚ�']' ֮ǰ����Ϣ��Ҫ�ظ��Ĳ��ּ��ظ�������ѹ��stack�
 * �ȵ���']'��һ��һ���Ƴ���ԭ��˼·�ǳ�����������ʵ��������
 * ���򵥡���ע��ϸ�ڼ��䴦��ʽ���������ֿ��ܳ�����λ������
 * ; ���й�ϵ�ۣ�,�ۣݺͰ�����ϵ�ۣۣݣ�����������֡����ⷢ
 * �ִ�ѭ����while������for���ܸ�����һЩ��
 */
public class DecodeString {
	public static String decodeString(String s) {
		Stack<Integer> count = new Stack<>();
		Stack<String> result = new Stack<>(); //��Stack���������ϵ
	
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
				result.push(""); //�ó�ʼ�����ַ��������й�ϵ
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
