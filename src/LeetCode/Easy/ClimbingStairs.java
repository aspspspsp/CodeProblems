package LeetCode.Easy;
/*
    f(0) = 1
    f(1) = 1:1
    f(2) = 2:1+1,2
    f(3) = 3:1+1+1,2+1,1+2
    f(4) = 5:1+1+1+1,2+2,1+2+1,1+1+2,2+1+1
    f(6) = 8:1+1+1+1+1+1,1+1+1+1+2....
    �ó���ʽ�Ӿ���:ways[i] = ways[i-1] + ways[i-2]
*/
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] ways = new int[n + 1];
        
        ways[0] = 1; //��0�Aֻ��һ�N��ʽ
        ways[1] = 1;

        for(int i = 2; i <= n; i ++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        
        return ways[n];
    }
}