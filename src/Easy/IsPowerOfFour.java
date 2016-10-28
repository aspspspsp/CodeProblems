package Easy;
/*
 * 換底公式 loga b = lognb / logn a
 */
public class IsPowerOfFour {
	 public boolean isPowerOfFour(int num) {
	        if(num < 0)
	            return false;
	        
	        //log4 Num(將num以4為底)
	        //再進行換底
	        
	        //log4 Num 不帶小數點後位
	        double integerLog = (int)(Math.log10(num) / Math.log10(4));
	        
	        //log4 Num 帶小數點後位
	        double log = Math.log10(num) / Math.log10(4);
	        
	        //若帶小數點的減去不帶小數點的為0表示此數4的次方數
	        if(integerLog - log == 0)
	        	return true;
	        //否則並不是
	        else 
	        	return false;
	 }
}
