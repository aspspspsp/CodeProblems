package src.LeetCode.Algorithms.Easy;
/*
 * �ȿ��]�ɂ��L���β����B����r��ֻҪ�μ���Ӌ����e��Ӽ���
 * AB,EF�քe��������c��CD,GH�քe��������c�����A>=G��ʾ��һ���L�����ڵڶ����L�����҂ȶ�����e���دB
 * ͬ�ӷ������Д��ɂ��L�������������c�Ƿ��н��B����r
 * ����н��B����r�l����ʹ��max(A,E)�����ҳ����B�����ε�������c��ͬ�ӷ��������ҳ����B���������_λ�ÁKӋ����e
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