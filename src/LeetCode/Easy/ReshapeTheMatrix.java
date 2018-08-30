package src.LeetCode.Easy;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        //排除其他情況
        if(nums == null || nums.length == 0 || nums[0].length == 0)
            return nums;
        
        if(r <= 0 || c <= 0)
            return nums;
        
        int m = nums.length;
        int n = nums[0].length;
        
        //兩個矩陣形狀無法進行轉換
        if(r * c != m * n)
            return nums;
        
        //若兩個矩陣長寬都一樣就不用變形了
        if(r == m && c == n)
            return nums;
        
        //正式開始進行矩陣的reshape
        
        //先將矩陣變成一維
        int[] temp = new int[m * n];
        int cnt = 0;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                temp[cnt] = nums[i][j];
                cnt ++;
            }
        }
        
        //再將一維矩陣轉換為r*c的矩陣
        int[][] ans = new int[r][c];
        cnt = 0;
        for(int i = 0; i < r; i ++) {
            for(int j = 0; j < c; j ++) {
                ans[i][j] = temp[cnt];
                cnt ++;
            }
        }
        
        return ans;
    }
}