package Easy;
/*
 * 先考慮兩個長方形不交疊的情況，只要單純的計算面積相加即可
 * AB,EF分別為左下頂點，CD,GH分別為右上頂點，如果A>=G表示第一個長方形在第二個長方形右側而且面積不重疊
 * 同樣方法可判斷兩個長方形其他三個點是否有交疊的情況
 * 如果有交疊的情況發生，使用max(A,E)可以找出交疊正方形的左下頂點，同樣方法可以找出交疊正方形正確位置並計算面積
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