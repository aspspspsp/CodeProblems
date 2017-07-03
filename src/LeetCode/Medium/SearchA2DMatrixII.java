package LeetCode.Medium;
public class SearchA2DMatrixII {
/*
��� - �����϶�����
���O��������Ͻǿ�ʼ����������Ԫ������Ϊ�������Һ����϶��£�������target���ڵ�ǰ����Ԫ��ʱ��������������Ҫ��������̫���ʡ�
��������Ͻǿ�ʼ������������ߵ�Ԫ��һ�������ڵ�ǰԪ�أ��������Ԫ��һ����С�ڵ�ǰԪ�أ����ÿ�αȽ�ʱ�����ų�һ�л���һ��Ԫ�أ����ڵ�ǰԪ�����ų���ǰ�У�С�ڵ�ǰԪ�����ų���ǰ�У��ɾ����ص��֪�����ɴﵽ��ĿҪ��ĸ��Ӷȡ�
*/
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        
        if(matrix == null || matrix[0].length == 0)
            return false;
        
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        //��ָ�������ϣ���ָ�������£���u�A��
        int index_row = 0, index_col = col;
        
        //��Ŀ�˔����ڹ����Ȅt����flase
        if(target < matrix[0][0] || target > matrix[row][col])
            return false;
        
        //�_ʼ����
        while(index_row < row + 1 && index_col + 1 > 0) {
            int cur_num = matrix[index_row][index_col];
            //������Ŀ��
            if(target == cur_num) 
                return true;
            //��Ŀ�˔�С�Ŀǰ�������Ĕ��t��ָ������һ��
            else if(target < cur_num)
                index_col --;
            //��Ŀ�˔����Ŀǰ�������Ĕ��t��ָ������һ��
            else if(target > cur_num)
                index_row ++;
        }
        
        //�����Y������o�Y��
        return false;
    }
}