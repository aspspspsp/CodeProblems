package LeetCode.Medium;
/*
�����������ͣ���������͵����ֵ

�������Ƚ���һ�������̰���㷨��
localSum[i]��ʾ��ǰ�������
globalSum[i],��ʾ��õ�����������
��localSum[i] <= 0ʱ���ۼ������е�Ԫ��ֻ��ʹ�õ��ĺ͸�С���ʴ�ʱӦ���˲��ֺͶ���
��ʹ�ô�ʱ������������Ԫ�������

˼��:
 1,2,-3,4
 �v�鵽-4�r
 �Q���Ƿ�Ҫ�G��1,2,-3�Ŀ���
 
*/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int [] globalSum = new int[nums.length + 1];
        int [] localSum = new int[nums.length + 1];
        
        //��ʼ��
        localSum[0] = nums[0];
        globalSum[0] = nums[0];
        
        for(int i = 1; i < nums.length; i ++) {
            //��localSum�Ȯ�ǰ�v��Ĕ��MС�r�t����(�ஔ춒Η�֮ǰ�����к�)
            localSum[i] = Math.max(nums[i], localSum[i - 1] + nums[i]);
            //��global�M�и���
            globalSum[i] = Math.max(globalSum[i - 1], localSum[i]);
        }
        
        return globalSum[nums.length - 1];
    }
}