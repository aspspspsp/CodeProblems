package Easy;

public class SumOfTwoIntegers {	
	// a ^ b 直接算出a + b 每位上mod 2後的结果， 进位的话可以直接 (a & b)<<1得到（只有两个位均为1才会进位嘛，左移表示进到下一位啊）
	//這題就是用二進位的方式來進行運算
	public int getSum(int a, int b) {
		
		//運行到b == 0 為止(以二進制方式依序對每一位數進行加減)
		while(b != 0) {
			//a mod b(進位後的數)
			int c = a & b; 
			
			//對a與b進行xor運算(加法)
			a = a ^ b;
			
			//將a mod b 的結果左移一位(進位)，若a mod b的結果為0則不進位
			b = c << 1;
		}
		
		return a;
	}
}
