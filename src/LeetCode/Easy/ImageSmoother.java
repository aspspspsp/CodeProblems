package LeetCode.Easy;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0)
            return M;
        
        int m = M.length;
        int n = M[0].length;
        
        int[][] newM = new int[m][n];
        
        //                右              下              上                左                 左下           右上          右下           左上
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0 , -1}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
        
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                int smoother = 0;
                int valid = 0;
                for(int[] dir : dirs) {          
                    int y = i + dir[0];
                    int x = j + dir[1];
                    if(y >= 0 && y < m && x >= 0 && x < n) {
                        smoother += M[y][x];
                        valid ++;
                    }
                }
                
                //別忘記還要加上自己喔
                smoother += M[i][j];
                valid ++;
                                
                newM[i][j] = (int)Math.floor(smoother / valid);
            }
        }
        
        return newM;
    }
}