package src.LeetCode.Algorithms.Easy;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // handle the exception situation
        if(newColor == image[sr][sc])
            return image;

        dfs(image, image[sr][sc], newColor, sr, sc);
        return image;
    }

    void dfs(int[][] image, int oldColor, int newColor, int i, int j) {
        // change oringle color to new color
        image[i][j] = newColor;

        // up
        if(i - 1 >= 0 && image[i - 1][j] == oldColor)
            dfs(image, oldColor, newColor, i - 1, j);

        // down
        if(i + 1 < image.length && image[i + 1][j] == oldColor)
            dfs(image, oldColor, newColor, i + 1, j);

        // left
        if(j - 1 >= 0 && image[i][j - 1] == oldColor)
            dfs(image, oldColor, newColor, i, j - 1);

        // right
        if(j + 1 < image[0].length && image[i][j + 1] == oldColor)
            dfs(image, oldColor, newColor, i, j + 1);
    }
}
