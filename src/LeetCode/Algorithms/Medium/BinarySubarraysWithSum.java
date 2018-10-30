package src.LeetCode.Algorithms.Medium;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] tmp = new int[A.length];
        int result = 0;
        if(A[0] == 1)
            tmp[0] = 1;

        for(int i = 1; i < A.length; i ++) {
            if(A[i] == 1) {
                tmp[i] = tmp[i - 1] + 1;
            } else {
                tmp[i] = tmp[i - 1];
            }

            if(tmp[i] % S == 0)
                result ++;
        }

        return result;
    }
}
