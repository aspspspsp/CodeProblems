package Medium;
/*
 * 給定 [1,2,3,4], 輸出 [24,12,8,6].
 * 不能用除法還要用O(n)的方法
 * 思路:分為兩個數(n1與n2)相乘
 * 
 * 回合		n1					*	n2					=	答案
 * --------------------------------------------------------------
 * 0		1(1)				*	1*a4*a3*a2(1*4*3*2)	=	24
 * 1		1*a1(1*1)			*	1*a4*a3(1*4*2)		=	12
 * 2		1*a1*a2(1*1*2)		*	1*a4(1*4)			=	8
 * 3		1*a1*a2*a3(1*1*2*3)	*	1(1)				=	6
*/

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        
        //構造兩個數相乘
        int [] n1 = new int[length];
        int [] n2 = new int[length];
        
        //開始構造n1
        n1[0] = 1;
        for(int i = 1; i < length; i ++) {
        	n1[i] = nums[i - 1] * n1[i - 1];
        }
        
        //開始構造n2
        n2[length - 1] = 1;
        for(int i = length - 2; i > -1; i --) {
        	n2[i] = n2[i + 1] * nums[i + 1];
        }
        
        //使兩個數相乘
        for(int i = 0; i < length; i ++) {
        	n1[i] = n1[i] * n2[i];
        }
        
        //返回答案
        return n1;
    }
}
