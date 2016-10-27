package Medium;
/*
直接乘会溢出，所以每次都要两个single digit相乘，最大81，不会溢出。
比如385 * 97, 就是个位=5 * 7，十位=8 * 7 + 5 * 9 ，百位=3 * 7 + 8 * 9 …
可以每一位用一个Int表示，存在一个int[]里面。
这个数组最大长度是num1.len + num2.len，比如99 * 99，最大不会超过10000，所以4位就够了。
这种个位在后面的，不好做（10的0次方，可惜对应位的数组index不是0而是n-1），
所以干脆先把string reverse了代码就清晰好多。
最后结果前面的0要清掉。
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		// 將數字倒反(利用StringBuilder)
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();

		//答案的位數
		int digis[] = new int[num1.length() + num2.length()];

		//分別對每一位相乘
		for (int i = 0; i < num1.length(); i++) {
			//透過減法將char轉換為int(-'0'代表都不減任何數字)
			int n1 = num1.charAt(i) - '0';
			for(int j = 0; j < num2.length(); j ++) {
				//透過減法將char轉換為int(-'0'代表都不減任何數字)
				int n2 = num2.charAt(j) - '0';
				
				//因為已經將數字都倒過來了，所以透過n1與n2目前的位數，可以得到新的數的位數
				digis[i + j] = digis[i + j] + n1 * n2;
				
				//因為是每一位數相乘，故最大的數為81
			}
		}
		
		//答案
		StringBuilder ans = new StringBuilder();
		
		//將數從第0位開始倒回來
		for(int i = 0; i < digis.length; i ++) {
			//得到此位的數
			int digi = digis[i] % 10;
			
			//需要進位的數
			int carry = digis[i] / 10;
			
			//進行進位
			if(i < digis.length - 1) {
				digis[i + 1] = digis[i + 1] + carry; 
			}
			
			//將數字插入答案sb.insert(0(offset), "要插入的東西");
			ans.insert(0, digi);
		}
		
		//將前面多出的0去掉
		while(ans.length() > 0 && ans.charAt(0) == '0') {
			//刪除最前面的cahr
			ans.deleteCharAt(0);
		}
		
		if(ans.length() == 0)
			return "0";

		return ans.toString();

	}

}
