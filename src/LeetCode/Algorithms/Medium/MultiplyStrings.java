package src.LeetCode.Algorithms.Medium;
/*
ֱ�ӳ˻����������ÿ�ζ�Ҫ����single digit��ˣ����81�����������
����385 * 97, ���Ǹ�λ=5 * 7��ʮλ=8 * 7 + 5 * 9 ����λ=3 * 7 + 8 * 9 ��
����ÿһλ��һ��Int��ʾ������һ��int[]���档
���������󳤶���num1.len + num2.len������99 * 99����󲻻ᳬ��10000������4λ�͹��ˡ�
���ָ�λ�ں���ģ���������10��0�η�����ϧ��Ӧλ������index����0����n-1����
���Ըɴ��Ȱ�string reverse�˴���������öࡣ
�����ǰ���0Ҫ�����
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
			
			//進行進位
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
			//刪除最前面的char
			ans.deleteCharAt(0);
		}
		
		if(ans.length() == 0)
			return "0";

		return ans.toString();

	}

}
