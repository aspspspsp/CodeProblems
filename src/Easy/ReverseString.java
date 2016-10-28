package Easy;
/*

	直接歷遍整個字串方式太慢，
	故可以將字串轉為char並將頭與尾相互交換 ex abcd 
	1.a與d交換
	2.b與c交換
	這樣只要做"字串的一半"

*/
public class ReverseString {
    public String reverseString(String s) {

        char[] ch = s.toCharArray(); //轉為char
        int halfLenfth = s.length() / 2; //歷遍字串的一半
        for(int i = 0; i < halfLenfth; i ++) {
        	//交換頭一個與最後一個
            char temp = ch[i];
            ch[i] = ch[s.length() - 1 - i];
        	ch[s.length() - 1 - i] = temp;
        }
        return new String(ch);
    }
}