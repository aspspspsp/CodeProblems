package src.LeetCode.Algorithms.Easy;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int result = 0;

        for(int i = L; i <= R; i ++) {
            int ones = getNumOfOnes(i);
            if(isPrime(ones) == true)
                result ++;
        }

        return result;
    }

    boolean isPrime(int n) {
        // 1不是質數
        if(n == 1)
            return false;

        int m = (int)Math.sqrt(n);

        for(int i = 2; i <= m; i ++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }

    int getNumOfOnes(int n) {
        int ones = 0;
        while(n > 0) {
            if(n % 2 == 1)
                ones ++;
            n = n / 2;
        }
        return ones;
    }
}
