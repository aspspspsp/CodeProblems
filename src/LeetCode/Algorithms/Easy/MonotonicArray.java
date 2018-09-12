package src.LeetCode.Algorithms.Easy;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        // �ҥ~���p
        if(A == null || A.length < 3)
            return true;

        // �i�H�P�_��դW�ɻP�U��
        boolean down = false;
        boolean up = false;

        for(int i = 1; i < A.length; i ++) {
            // �P�_��e����դU��
            if(A[i - 1] > A[i])
                down = true;

            // �P�_��e����դW��
            if(A[i - 1] < A[i])
                up = true;

            // �Y����դU���ɡA����e�O��դW�ɡA�h��^false
            if(A[i - 1] < A[i] && down == true)
                return false;

            // �Y����դW�ɮɡA����e�O��դU���A�h��^false
            if(A[i - 1] > A[i] && up == true)
                return false;
        }

        // �����ˬd������A��^true
        return true;
    }
}
