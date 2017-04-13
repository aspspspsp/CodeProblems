package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
            
        int n = matrix.length;
        int m = matrix[0].length;
        
        int beginX = 0;
        int endX = m - 1;
        
        int beginY = 0;
        int endY = n - 1;
        
        while(true) {
            //����
            for(int x = beginX; x <= endX; x ++)
                res.add(matrix[beginY][x]);
            beginY ++;
            if(beginY > endY)
                break;
            
            //�ϵ���
            for(int y = beginY; y <= endY; y ++)
                res.add(matrix[y][endX]);
            endX --;
            if(beginX > endX)
                break;
            
            //�ҵ���
            for(int x = endX; x >= beginX; x --)
                res.add(matrix[endY][x]);
            endY --;
            if(beginY > endY)
                break;
            
            //�µ���
            for(int y = endY; y >= beginY; y --)
                res.add(matrix[y][beginX]);
            beginX ++;
            if(beginX > endX)
                break;
        }
        
        return res;
    }
}