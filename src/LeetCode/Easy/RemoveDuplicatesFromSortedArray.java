package LeetCode.Easy;
/*
 * �����Ѓɂ����M
 * 
 * ex: 
 *���M1 1223
 *���M2 ____(��δ����ֵ)
 * 
 * step1:
 * ���񔵽M2��׃��
 * 1: 1 ����1
 * 2: 12 ����2
 * 3: 12 ��2����ԭ��ĵط�
 * 4: 123 ����3
 */

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
    	//��ָ�
        int end = 0;
        
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == nums[end]) {
                continue;
            }
            end ++;
            nums[end] = nums[i];
        }
        
        return end + 1;
    }

}