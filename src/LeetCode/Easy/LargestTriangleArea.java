package src.LeetCode.Easy;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double max = 0;

        for(int i = 0; i < points.length; i ++) {
            for(int j = i + 1; j < points.length; j ++) {
                for(int k = j + 1; k < points.length; k ++) {
                    //取得3點的x與y
                    double x1 = points[i][0];
                    double x2 = points[j][0];
                    double x3 = points[k][0];

                    double y1 = points[i][1];
                    double y2 = points[j][1];
                    double y3 = points[k][1];

                    // 公式解
                    double triangle = Math.abs(0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
                    max = Math.max(triangle, max);
                }
            }
        }

        return max;
    }
}