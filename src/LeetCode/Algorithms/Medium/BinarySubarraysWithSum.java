package src.LeetCode.Algorithms.Medium;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int result = 0;
        for(int i = 0; i < A.length; i ++) {
            int sub = 0;
            for(int j = i; j < A.length; j ++) {
                sub += A[j];
                if(sub == S)
                    result ++;
                if(sub > S)
                    break;
            }
        }

        return result;
    }
}
