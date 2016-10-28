package Easy;
public  class UglyNumber {
	public boolean isUgly(int num) {
	    
	    //若num>=2則繼續除，直到num < 2
	    while(num >= 2) {
	        //若此數除2餘數為0
	        if(num % 2 == 0) {
	            //將此數除2
	            num = num / 2;
	        }
	        //若此數除3餘數為0
	        else if(num % 3 == 0) {
	            //將此數除3
	            num = num / 3;
	        }
	        //若此數除5餘數為0
	        else if(num % 5 == 0) {
	            //將此數除3
	            num = num / 5;
	        }
	        //若此數除以以上三個數餘數皆不為0(表示可被其他數整除)則不是ugly number
	        else {
	            return false;
	        }
	    }
	    
	    //若此數完整被整除則為true
	    if(num == 1) {
	        return true;
	    } 
	    //考慮若為其他質數時(或是負數時，因為ugly number只為正數)
	    else {
	    	return false;
	    }
	}
}
