package src.LeetCode.Algorithms.Easy;

/*
问题：找出所有小于 n 的素数。
题目很简洁，但是算法实现的优化层次有很多层。其中最主要思想的是采用 Sieve of Eratosthenes 算法来解答。
大思路为：
1.找出n范围内所有合数，并做标记。(2<=i<=n)
2.未做标记的即为素数，统计未做标记的数个数即为原题目解。
(先用2去篩，即把2留下，把2的倍數剔除掉；
再用下一個質數，也就是3篩，把3留下，把3的倍數剔除掉；
接下去用下一個質數5篩，把5留下，把5的倍數剔除掉；不斷重複下去......。)
*/

public class CountPrimes {
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }
        
        //有n個prime的記號
        boolean[] prime = new boolean[n];
        
        /////假設n以下的所有數都是素數
        for(int i = 2; i < n; i ++) {
            prime[i] = true;
        }
        
        /////找到不是素數的數
        //歷遍2~(n-1)^0.5
        for(int i = 2; i <= Math.sqrt(n - 1); i ++) { // or for(int i = 2; i <= n - 1; i ++)
            //標記i的倍數不是素數(範圍:i*2~i<n)，其中i本身為素數
            if(prime[i] == true) {
                for(int j = i * 2; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }
        
        /////統計從1~(n-1)所有的素數
        int count = 0;
        for(int i = 2; i < n; i ++) {
            if(prime[i] == true) {
                count ++;
            }
        }
        
        return count;
    }
}