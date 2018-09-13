package src.LeetCode.Algorithms.Easy;

public class TransposeMatrix {
    /*
    Âà¸m¯x°}:
    1 2 3      1 4
    4 5 6  =>  2 5
               3 6
    */
    public int[][] transpose(int[][] A) {

        int[][] result = new int[A[0].length][A.length];

        for(int i = 0; i < A.length; i ++) {
            for(int j = 0; j < A[0].length; j ++) {
                result[j][i] = A[i][j];
            }
        }

        return result;
    }
}
