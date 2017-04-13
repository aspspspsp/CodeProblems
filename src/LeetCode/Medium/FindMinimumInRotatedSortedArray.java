package LeetCode.Medium;

public class FindMinimumInRotatedSortedArray {
    //�@�}ʹ���޸��^�Ķ��ֲ��ҷ�
    public int findMin(int[] nums) {
        //̎�픵�M��յ���r
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        //̎�픵�Mֻ��һ��Ԫ�ص���r
        if(nums.length == 1) {
            return nums[0];
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        /*�����M�]�б����D�^��ֱ�ӷ��ص�һ��
        �����D�^��Ĕ��M������߅�Ĕ��^��������С�����߅
        ex:
         0 1 2 3 4  0 < 4
         ---------
         4 0 1 2 3  4 > 3
         3 4 0 1 2  3 > 2
         2 3 4 0 1  2 > 1
         1 2 3 4 0  1 > 0
        */
        if(nums[low] < nums[high]) {
            return nums[0];
        }
        
        /*
                0 1 2 3 4 5 6
                ---------------
        ԭ���飺*0 1 2 4 5 6 7
        ���1�� 6 7 *0 1 2 4 5   //��߅һ������
        ���2�� 2 4 5 6 7 *0 1   //��߅һ������
        
        �������������ô������С������ߵ�һ��Ԫ�أ����Ժ͵�ǰ��С���ȡС�ģ�Ȼ�������Ұ�ߡ�
        ������ô�����Ұ��ߵ�һ��Ԫ�أ�Ȼ���������ߡ�
        */
        while(low < high) {
            //������߅��̖-����߅��̖��1�r����ʾ�ѽ���������Сֵ(��high)
            if(high - low == 1) {
                return nums[high];
            }
            
            int mid = (low + high) / 2;
            
            //�����gԪ�ر���߅Ԫ�ش�(��߅һ������ASD)��������߅
            if(nums[mid] > nums[low]) {
                low = mid;
            //��֮(��߅һ������ASD)��������߅
            } else {
                high = mid;
            }
        }
        
        //�]���ҵ���Сֵ
        return -1;
    }
}