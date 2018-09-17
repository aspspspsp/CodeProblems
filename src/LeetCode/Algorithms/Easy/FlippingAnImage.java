package src.LeetCode.Algorithms.Easy;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null)
            return A;

        int n = A.length;
        int m = A[0].length;

        if(n == 0 || m == 0)
            return A;

        // Β½Βΰ
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m / 2; j ++) {
                int tmp = A[i][j];
                A[i][j] = A[i][m - j - 1];
                A[i][m - j - 1] = tmp;
            }
        }

        // 0Εά1 1Εά0
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {

                if(A[i][j] == 0)
                    A[i][j] = 1;
                else
                    A[i][j] = 0;
            }
        }

        return A;
    }
}
