//移位練習
public class ShiftingBits {
	public static void main(String args[]) {
		System.err.println(rightArthmeticShifting(-8, 3));
		System.err.println(rightLogicalShifting(-4, 1));
		
		System.err.println(leftArthmeticShifting(8, 1));
	}
	
	//算術移位，對n向右移動i位(移動一位就是除2，二位除4)，正負不變
	static int rightArthmeticShifting(int n, int i) {
		return n >> i;
	}
	
	//算術移位，對n向右移動i位，正不變，負變正(移動時，對第1位補0)
	static int rightLogicalShifting(int n, int i) {
		return n >>> i;
	}
	
	//算術移位，對n向左移動i位(移動一位就是乘2，二位乘4)，正負不變
	static int leftArthmeticShifting(int n, int i) {
		return n << i;
	}
		
	//並沒有對n向左移動(邏輯移位)
}
