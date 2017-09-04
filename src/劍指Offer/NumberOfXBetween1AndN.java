package 劍指Offer;

public class NumberOfXBetween1AndN {
	public static void main(String[] args) {
		System.err.println(numberOfXBetween1AndN_2(255, 4));
		System.err.println(numberOfXBetween1AndN_1(255, 4));

	}
	
	public static int numberOfXBetween1AndN_2(int n, int x) {
		int count = 0;
		for (int i = 1; i <= n; i *= 10) {
	        int a = n / i;
	        int b = n % i;
	        //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
	        //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
	        count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
	    }
		
		return count;
	}
	
	public static int numberOfXBetween1AndN_1(int n, int x) {
	    int count = 0;
	    for(int i=0; i<=n; i++){
	        int temp = i;
	        //如果temp的任意位为1则count++
	        while(temp!=0){
	            if(temp%10 == 1){
	                count++;
	            }
	            temp /= 10;
	        }
	    }
	    return count;
	}
}
