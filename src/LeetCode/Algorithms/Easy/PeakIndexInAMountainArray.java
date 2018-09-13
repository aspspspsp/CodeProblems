package src.LeetCode.Algorithms.Easy;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int peak_ele = Integer.MIN_VALUE;
        int peak_pos = -1;

        for(int i = 0; i < A.length; i ++) {
            if(A[i] > peak_ele) {
                peak_ele = A[i];
                peak_pos = i;
            }
        }

        return peak_pos;
    }
}
