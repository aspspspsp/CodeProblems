package LeetCode.Easy;
/*
 * �ȿ��]�ɂ��L���β����B����r��ֻҪ�μ���Ӌ����e��Ӽ���
 * AB,EF�քe��������c��CD,GH�քe��������c�����A>=G��ʾ��һ���L�����ڵڶ����L�����҂ȶ�����e���دB
 * ͬ�ӷ������Д��ɂ��L�������������c�Ƿ��н��B����r
 * ����н��B����r�l����ʹ��max(A,E)�����ҳ����B�����ε�������c��ͬ�ӷ��������ҳ����B���������_λ�ÁKӋ����e
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //��һ���L���ε���eABCD
        int rectangleAArea = Math.abs(A - C) * Math.abs(B - D);
        //�ڶ����L���ε���eEGFH
        int rectangleBArea = Math.abs(E - G) * Math.abs(F - H);
        
        // ���ABCD�cEGFH�]�دB�������e�t�ǃɂ��L���ε���e
        if(A >= G || B >= H || C <= E || D <= F) {
            return rectangleAArea + rectangleBArea;
        }
        
        // Ӌ���دB�Ĳ���
        int overlapping = 
            Math.abs((Math.max(A, E) - Math.min(C, G)) * (Math.max(B, F) - Math.min(D, H)));
        
        // ��һ���L����+�ڶ����L����-�دB�t�������e
        return rectangleAArea + rectangleBArea - overlapping;
    }
}