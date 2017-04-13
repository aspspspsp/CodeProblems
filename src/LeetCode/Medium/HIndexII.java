package LeetCode.Medium;

public class HIndexII {
    /*
    ��275����������274�����һ�£�ֻ�Ƕ��ṩ��һ��������
    ������������������еġ��������Ȼ����ʹ������ķ�������Hָ������������ʡ�Զ���������ֹ�����Ĳ��衣
    */
    public int hIndex(int[] citations) {
        if(citations.length == 0 || citations == null)
            return 0;
        
        int result = 0;
        for(int i = citations.length - 1; i >= 0 ; i --) {
            if(result >= citations[i])
                break;
            result ++;
        }
        
        return result;
    }
}