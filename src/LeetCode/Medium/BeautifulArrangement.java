package src.LeetCode.Medium;

public class BeautifulArrangement {
	/*
	 * 1 2 3 *
	 * 1 3 2
	 * 2 1 3
	 * 2 3 1
	 * 3 1 2
	 * 3 2 1
	 */
    public int countArrangement(int N) {
        if(N < 1)
            return 0;
        
        boolean[] used = new boolean[N + 1];
        
        int result = helper(1, N, used);
        
        return result;
    }
    
    int helper(int start, int n, boolean[] used) {
        if(start > n)
            return 1;
        
        int result = 0;
        //產生所有的排列
        for(int i = 1; i <= n; i ++) {
            if(used[i] == true)
                continue;
            
            if(start % i != 0 && i % start != 0)
                continue;
            
            used[i] = true;
            result += helper(start + 1, n, used);
            used[i] = false;
        }
        
        return result;
    }
}