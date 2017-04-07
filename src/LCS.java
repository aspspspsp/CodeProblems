
public class LCS {
	public static void main(String[] args) {
		int res = longestCommonSubsequence("ABC", "BCD");
		System.err.println(res);
	}
	
	static int longestCommonSubsequence(String A, String B) {
		if(A == null || B == null)
			return 0;
		
		int lenA = A.length();
		int lenB = B.length();
		int [][] D = new int[lenA + 1][lenB + 1];
		
		for(int i = 0; i <= lenA; i ++) {
			for(int j = 0; j <= lenB; j ++) {
				if(i == 0 || j == 0) {
					D[i][j] = 0;
				} else {
					if(A.charAt(i - 1) == B.charAt(j - 1))
						D[i][j] = D[i - 1][j - 1] + 1;
					else 
						D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
				}
			}
		}
		
		return D[lenA][lenB];
	}
}
