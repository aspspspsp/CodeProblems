package src.LeetCode.Algorithms.Easy;
/*
 * 輸出兩個數組之間重疊的元素
 * ex:1 2 2 3 4 5, 2 3 5
 * output 2 3 5
 */

import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 對num1與num2兩個數組進行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        
        //�Y������
        int[] temp = new int[nums1.length];
        
        int index = 0;
        
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
            //��ɂ����MĿǰ��Ԫ��һ�ӕr
            	
            	//�������}�Ĵ𰸷��땺��Y������
                if(index == 0 || nums1[i] != temp[index - 1]) {
                    temp[index] = nums1[i];
                    index ++;
                }
                
                //nums1�cnums2Ŀǰ�ɂ�Ԫ��һ�ӕr���tnums1�cnums2��ָ�˶�����1
                i ++;
                j ++;
            } else if(nums1[i] < nums2[j]) {
            	//nums1Ŀǰ��Ԫ�ر�nums2Ŀǰ��Ԫ��С�r���tnums1��ָ��+1(����ʹnums1�cnums2��Ԫ��һ�ӵĿ�����׃��)
                i ++;
            } else if(nums1[i] > nums2[j]) {
            	//nums1Ŀǰ��Ԫ�ر�nums2Ŀǰ��Ԫ�ش�r���tnums2��ָ��+1(����ʹnums1�cnums2��Ԫ��һ�ӵĿ�����׃��)
                j ++;
            }
        }
        
        int[] result = new int[index];
        
        //������Y��ݔ������ʽ�Y��
        for(int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        
        return result;
    }
}
