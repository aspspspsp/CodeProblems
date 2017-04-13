package LeetCode.Medium;
/*
 * �o�� [1,2,3,4], ݔ�� [24,12,8,6].
 * �����ó���߀Ҫ��O(n)�ķ���
 * ˼·:�֞�ɂ���(n1�cn2)���
 * 
 * �غ�		n1					*	n2					=	��
 * --------------------------------------------------------------
 * 0		1(1)				*	1*a4*a3*a2(1*4*3*2)	=	24
 * 1		1*a1(1*1)			*	1*a4*a3(1*4*2)		=	12
 * 2		1*a1*a2(1*1*2)		*	1*a4(1*4)			=	8
 * 3		1*a1*a2*a3(1*1*2*3)	*	1(1)				=	6
*/

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        
        //����ɂ������
        int [] n1 = new int[length];
        int [] n2 = new int[length];
        
        //�_ʼ����n1
        n1[0] = 1;
        for(int i = 1; i < length; i ++) {
        	n1[i] = nums[i - 1] * n1[i - 1];
        }
        
        //�_ʼ����n2
        n2[length - 1] = 1;
        for(int i = length - 2; i > -1; i --) {
        	n2[i] = n2[i + 1] * nums[i + 1];
        }
        
        //ʹ�ɂ������
        for(int i = 0; i < length; i ++) {
        	n1[i] = n1[i] * n2[i];
        }
        
        //���ش�
        return n1;
    }
}
