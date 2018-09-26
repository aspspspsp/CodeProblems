package src.LeetCode.Algorithms.Easy;
/*
先找出所有的不相交的情况:
一个矩形在另一个的上下左右四个位置不重叠，这四种情况下返回两个矩
形面积之和。
其他所有情况下两个矩形是有交集的，这时候我们只要算出长和宽，即可
求出交集区域的大小，然后从两个巨型面积之和中减去交集面积就是最终
答案。
求交集区域的长和宽也不难，由于交集都是在中间，所以横边的左端点是
两个矩形左顶点横坐标的较大值，右端点是两个矩形右顶点的较小值，同
理，竖边的下端点是两个矩形下顶点纵坐标的较大值，上端点是两个矩形
上顶点纵坐标的较小值。
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //第一個長方形的面積ABCD
        int rectangleAArea = Math.abs(A - C) * Math.abs(B - D);
        //第二個長方形的面積EGFH
        int rectangleBArea = Math.abs(E - G) * Math.abs(F - H);
        
        // 如果ABCD與EGFH沒重疊，最大面積則是兩個長方形的面積
        if(A >= G || B >= H || C <= E || D <= F) {
            return rectangleAArea + rectangleBArea;
        }
        
        // 計算重疊的部分
        int overlapping = 
            Math.abs((Math.max(A, E) - Math.min(C, G)) * (Math.max(B, F) - Math.min(D, H)));
        
        // 第一個長方形+第二個長方形-重疊則是最大面積
        return rectangleAArea + rectangleBArea - overlapping;
    }
}