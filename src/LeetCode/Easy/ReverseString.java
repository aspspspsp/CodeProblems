package LeetCode.Easy;
/*
	這題就是將字串做翻轉
	首先我們將字串轉換為char數組，然後歷遍數組長度的一半
	例如abcd:
	* 1 2 3 4 動作
	1 d b c a a與d交換位置
	2 d c b a c與b交換位置
	返回char轉換String的結果
*/
public class ReverseString {
    public String reverseString(String s) {

        //將所有字串轉為char陣列
        char[] ch = s.toCharArray();

        //計算字串的長度，並除以2
        int halfLenfth = s.length() / 2;

        //從1歷遍到字串長度的一半
        for(int i = 0; i < halfLenfth; i ++) {

        	//將從前面數的第i個字元與後面數的第i個字元做交換
            char temp = ch[i];
            ch[i] = ch[s.length() - 1 - i];
        	ch[s.length() - 1 - i] = temp;
        }
        return new String(ch);
    }
}