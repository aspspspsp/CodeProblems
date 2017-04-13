package LeetCode.Medium;
/*
 * ���ٌ�N��֞�ɂ������Kʹ֮�˷e���
 * Ex 7 = 3 + 4 -> 3 * 4 = 12
 * 
 * ˼·:
 * n  ���					�н�					���˷e
 * ===============================================================
 * 2 = 1 + 1				x						1
 * 3 = 1 + 2				x						2
 * 4 = 2 + 2				x						4
 * -----���˷e��Ni = 3 * N(i-1)---------------------------------
 * 5 = 3 + 2				x						6
 * 6 = 3 + 3				x						9
 * 7 = 3 + 4				x						12
 * -----���˷e��Ni = N(i-3) * 3---------------------------------
 * 8 = 3 + 5				3 + (3 + 2)				18
 * 9 = 3 + 6				3 + (3 + 3)				27
 * 10= 3 + 7				3 + (3 + 4)				36
 * 11= 3 + 8				3 + (3 + 3 + 2)			54
 * ...						...						...
 */

public class IntegerBreak {
	public int integerBreak(int n) {
		
		//n < 5̎��
		if(n == 0)
			return 0;
		else if(n == 1 || n == 2)
			return 1;
		else if(n == 3)
			return 2;
		else if(n == 4)
			return 4;
		
		int[] result = new int [n + 1];
		
		//n > 5̎��
        for(int i = 5; i <= n; i ++) {
        	//��i <= 7�t���˷e��Ni = 3 * N(i-1)
        	if(i <= 7) {
        		int a = 3;
        		int b = i - 3;
        		result[i] = a * b;
        	//��i <= 7�t���˷e��Ni = N(i-3) * 3
        	} else {
        		result[i] = result[i - 3] * 3;
        	}
        }
        
        return result[n];
    }
}
