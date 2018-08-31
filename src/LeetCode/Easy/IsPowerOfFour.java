package src.LeetCode.Easy;
/*
 * �Q�׹�ʽ loga b = lognb / logn a
 */
public class IsPowerOfFour {
	 public boolean isPowerOfFour(int num) {
	        if(num < 0)
	            return false;
	        
	        //log4 Num(��num��4���)
	        //���M�ГQ��
	        
	        //log4 Num ����С���c��λ
	        double integerLog = (int)(Math.log10(num) / Math.log10(4));
	        
	        //log4 Num ��С���c��λ
	        double log = Math.log10(num) / Math.log10(4);
	        
	        //��С���c�Ĝpȥ����С���c�Ğ�0��ʾ�˔�4�Ĵη���
	        if(integerLog - log == 0)
	        	return true;
	        //��t�K����
	        else 
	        	return false;
	 }
}
