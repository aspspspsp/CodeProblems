package LeetCode.Medium;

import java.util.Arrays;

/*
����һ�������¼һ���о��߸�ƪ���µ���������дһ��������������о��ߵ�Hָ��

���ⷽ��
Hָ����һ��2005����Jorge E. Hirsch��������������о���Ա��ѧ������������ѧ������ˮƽ��ָ�ꡣ
����ϸ����Ϣ���Բο�h-index��ά���ٿ�ҳ�档
����:�o�����Ô��M��=[3,0,6,1,5]����������ĳ���о��T������ƪՓ�ģ���ÿƪՓ�ĵ����Ô������3��0��6��2�c5��
��ԓ�о��T����ƪՓ�����Ô�������3�Σ���ʣ��ƪՓ�����Ô��t����3�Σ����@���о��T��h-index��3��
(��һ������������ѧ����������Nƪ���ķֱ�����������N�Σ�����Hָ������N��)
������Ү����W���ߌW����졤�����ְl���900ƪ�����У���107ƪ��������107�����ϣ�����Hָ����107��

���Ȳ���һ����ʵ��
h-index������L����h-index <= L��L��citations���鳤�ȣ���
��h-index == Lʱ��citations����ֵ����С��L��
*/
public class HIndex {
    public int hIndex(int[] citations) {
        if(citations.length == 0 || citations == null)
            return 0;
        
        //����Ԫ�ؽ�������
        Arrays.sort(citations);

        //����Hָ��
        int result = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            if(result >= citations[i])
                break;
            result ++;
        }
        return result;
    }
}