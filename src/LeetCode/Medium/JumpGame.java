package src.LeetCode.Medium;

public class JumpGame {
/*
̰���㷨���ɡ�
����ά��һ������right����ʾ��ǰ���Ե��������λ�ã�Ȼ��������鴦�����������
    1�����ֵ�ǰ���Ե��������λ��rightС�ڵ�ǰλ�ã���ʾ�޷�������λ�ã�ֱ�ӷ���false��
    2������right��ֵ��
    3��������º��right��ֵ���ڵ������һ��Ԫ�ص���������ʾ�ӵ�ǰλ�þͿ��Ե���ĩβ��ֱ�ӷ���true��
�㷨��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)��
*/
    public boolean canJump(int[] nums) {
        int right = 0; // ���Ե��_������߅λ��
        for(int i = 0; i < nums.length; i ++) {
            if(right < i) {
                return false;
            }
            
            right = Math.max(right, i + nums[i]);
            if(right >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}