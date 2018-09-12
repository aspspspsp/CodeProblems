package src.LeetCode.Algorithms.Easy;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        // 例外情況
        if(A == null || A.length < 3)
            return true;

        // 可以判斷單調上升與下降
        boolean down = false;
        boolean up = false;

        for(int i = 1; i < A.length; i ++) {
            // 判斷當前為單調下降
            if(A[i - 1] > A[i])
                down = true;

            // 判斷當前為單調上升
            if(A[i - 1] < A[i])
                up = true;

            // 若為單調下降時，但當前是單調上升，則返回false
            if(A[i - 1] < A[i] && down == true)
                return false;

            // 若為單調上升時，但當前是單調下降，則返回false
            if(A[i - 1] > A[i] && up == true)
                return false;
        }

        // 全部檢查完之後，返回true
        return true;
    }
}
