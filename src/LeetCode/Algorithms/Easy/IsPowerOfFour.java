package src.LeetCode.Algorithms.Easy;
/*
 *首先先利用這個公式log(a,b) = log(n,b) / log(n,a)
 */
public class IsPowerOfFour {
	 public boolean isPowerOfFour(int num) {
	        if(num < 0)
	            return false;
	        
	        /*
	        因為log(10, 4)/log(10,4)若是整數的話，表示該數可以被4整除
	        所以我們利用這個性質，先取得整數，再取得小數，相減為0表示
	        log(10, 4)/log(10,4)為整數，即可被4整除，反之則無法被4整
	        除
		 	*/
	        
	        //log4 Num 取得 log(10,4) / log(10,4) 整數
	        double integerLog = (int)(Math.log10(num) / Math.log10(4));
	        
	        //log4 Num 取得 log(10,4) / log(10,4) 小數
	        double log = Math.log10(num) / Math.log10(4);
	        
	        //可被4整除的情況[log(10, 4)/log(10,4)為整數]
	        if(integerLog - log == 0)
	        	return true;
	        //無法被4整除的情況[log(10, 4)/log(10,4)為小數]
	        else 
	        	return false;
	 }
}
