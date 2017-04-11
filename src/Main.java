import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n_input = in.nextInt();
		for(long inputs = 0; inputs < n_input; n_input ++) {
			String s = in.next();
			char[] chars = s.toCharArray();
			boolean isRC = false;
			if(chars[0] == 'R' && chars[1] >= '1' && chars[1] <= '9') {
				for(int i = 0; i < chars.length; i ++) {
					if(chars[i] == 'C' && chars[i + 1] >= '1' && chars[i + 1] <= '9') {
						isRC = true;
					}
				}
			}
			
			if(isRC == true) {
				int c_start = -1, c_end = chars.length - 1;
				int r_start = 1, r_end = -1;
				
				for(int i = 1; i < chars.length; i ++) {
					if(chars[i] == 'C') {
						r_end = i - 1;
						c_start = i + 1;
						break;
					}
				}
				long column_number = Long.parseLong(s.substring(c_start, c_end + 1));
				String column = getStrRow(column_number);
				String row_number = s.substring(r_start, r_end + 1);
				System.out.println(column + row_number);
			} else {
				int c_start = 0, c_end = -1;
				int r_start = -1, r_end = chars.length - 1;
				for(int i = 0; i < chars.length; i ++) {
					if(chars[i] <= '9' && chars[i] >= '0') {
						c_end = i - 1;
						r_start = i;
						break;
					}
				}
				String cloumn = s.substring(c_start, c_end + 1);
				long column_number = getIntRow(cloumn);
				String row_number = s.substring(r_start, r_end + 1);
				System.out.println("R" + row_number + "C" + column_number);
			}
		}
		in.close();
	}
	
	public static int getIntRow(String str) {
		char[] chars = str.toCharArray();
		int ans = 0;
		for(int i = chars.length - 1; i >= 0; i --) {
			long cur = (long)chars[chars.length - i - 1] - 64;
			ans += Math.pow(26, i) * cur;
		}
		
		return ans;
	}
	
	public static String getStrRow(long n) {
		if(n <= 26) {
			return getAlphabet((int)(n % 26)) + "";
		}
		
		String ans = "";
		while(n > 26) {
			ans = getAlphabet((int)(n % 26)) + ans;
			n = (n - (n % 26)) / 26;
		}
		ans = getAlphabet((int)(n % 26)) + ans;
		return ans;
	}
	
	public static char getAlphabet(int a) {
		return (char)(a + 64);
	}
}
