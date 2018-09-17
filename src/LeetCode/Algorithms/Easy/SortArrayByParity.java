package src.LeetCode.Algorithms.Easy;

import java.util.Arrays;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        Arrays.sort(A);

        int num_even = 0;
        for(int i = 0; i < A.length; i ++) {
            if(A[i] % 2 == 0)
                num_even ++;
        }

        int[] result = new int[A.length];

        int e_index = 0;
        int o_index = num_even;
        for(int i = 0; i < A.length; i ++) {
            if(A[i] % 2 == 0) {
                result[e_index] = A[i];
                e_index ++;
            } else {
                result[o_index] = A[i];
                o_index ++;
            }
        }

        return result;
    }
}
