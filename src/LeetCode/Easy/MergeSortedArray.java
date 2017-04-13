package LeetCode.Easy;
/*
nums1��nums2���Ѿ����ź�������飬����ֻ��Ҫ�Ӻ���ǰ�ȽϾͿ����ˡ�

��Ϊnums1���㹻�Ŀռ�����nums1 + nums2������ʹ���α�ָ��m + n - 1
��Ҳ���������ֵ��ŵĵط����Ӻ���ǰ����nums1��nums2��˭��ͷŵ�
m + n - 1���nums1>nums2�ݼ�m��nums1<nums2�ݼ�n��
*/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m > 0 && n > 0) {
            if(nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m --;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n --;
            }
        }
        
        while(n > 0) {
            nums1[m + n - 1] = nums2[n - 1];
            n --;
        }
    
    }
}