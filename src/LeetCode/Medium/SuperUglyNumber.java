package LeetCode.Medium;
/*
与之前的丑数題目不同的是，之前求丑数是从2，3，5中找，而本题是给定的质数，求出他们的倍数的超级丑数
质数集合可以任意给定，由于我们不知道质数的个数，我们可以用一个idx数组来保存当前的位置，然后我们从
每个子链中取出一个数，找出其中最小值，然后更新idx数组对应位置，注意有可能最小值不止一个，要更新所
有最小值的位置
*/
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {        
        int[] dp = new int[n];
        
        //第一個醜數是1
        dp[0] = 1;
                
        int[] idxPrimes = new int[primes.length];
        int counter = 1;
        while(counter < n) {
            //紀錄最小值
            int min = Integer.MAX_VALUE;
            
            for(int i = 0; i < primes.length; i ++) {
                //idxPrimes[i] 代表每個醜數的個數
                //例如:醜數有2,3,5
                //idxPrimes[0] => 2的下標
                //idxPrimes[1] => 3的下標
                //idxPrimes[2] => 5的下標
                int temp = dp[idxPrimes[i]] * primes[i];
                
                //從temp中找到最小數
                if(temp < min)
                    min = temp;
            }
            //如果min == dp[idxPrimes[i]] * primes[i]，則對應其下標
            for(int i = 0; i < primes.length; i ++) {
                if(min == dp[idxPrimes[i]] * primes[i]) {
                    idxPrimes[i] ++;
                }
            }
            dp[counter] = min;
            counter ++;
        }
        return dp[n - 1];
    }
}