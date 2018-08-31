package src.LeetCode.Easy;
/*
    f(0) = 1
    f(1) = 1:1
    f(2) = 2:1+1,2
    f(3) = 3:1+1+1,2+1,1+2
    f(4) = 5:1+1+1+1,2+2,1+2+1,1+1+2,2+1+1
    f(6) = 8:1+1+1+1+1+1,1+1+1+1+2....
  結果類似於費伯納西數列(費氏數列): ways[i] = ways[i-1] + ways[i-2]
*/
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] ways = new int[n + 1];
        
        ways[0] = 1; //爬0階只有一種方式
        ways[1] = 1;

        for(int i = 2; i <= n; i ++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        
        return ways[n];
    }
}