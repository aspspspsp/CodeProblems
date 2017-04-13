package LeetCode.Easy;
/*

	ֱ�Ӛv�������ִ���ʽ̫����
	�ʿ��Ԍ��ִ��D��char�K���^�cβ�໥���Q ex abcd 
	1.a�cd���Q
	2.b�cc���Q
	�@��ֻҪ��"�ִ���һ��"

*/
public class ReverseString {
    public String reverseString(String s) {

        char[] ch = s.toCharArray(); //�D��char
        int halfLenfth = s.length() / 2; //�v���ִ���һ��
        for(int i = 0; i < halfLenfth; i ++) {
        	//���Q�^һ���c����һ��
            char temp = ch[i];
            ch[i] = ch[s.length() - 1 - i];
        	ch[s.length() - 1 - i] = temp;
        }
        return new String(ch);
    }
}