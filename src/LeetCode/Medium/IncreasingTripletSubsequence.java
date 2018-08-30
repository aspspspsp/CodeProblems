package src.LeetCode.Medium;
/*
 ˼·��

�� x1Ϊ��ĿǰΪֹ����Сֵ ��  x2Ϊ��ĿǰΪֹ������һ������x2С����С������

��ʼʱ����x1 = x2 = INT_MAX ��Ȼ���������,���ϵĸ���x1��x2 ��������

num <= x1,  ��ʱ��x1����Ϊnum
�� x1 < num <= x2���� ��x2 ����Ϊnum
x2 < num  ˵���н⣬����true����
�򵥵�˵�������Ĺ��̾��ǲ��ϵ���Сx1��x2�������Ƿ��е������� ��x2��

������ֵ������� num > x2����֮ǰ�ض����и���x С��x2������˵���� x < x2 < num������˵�д�����
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
    	int x1 = 0x7fffffff; //����x1 = INT_MAX
    	int x2 = 0x7fffffff; //����x2 = INT_MAX
    	
        for(int num : nums) {
        	if(num <= x1) //���@�����ȵ�һ����С�t����x1
        		x1 = num; //���µ�һ����
        	else if(num <= x2) //���@�����ȵڶ�����С�t����x2
        		x2 = num; //���µڶ�����
        	else  //���@������ǰ��ɂ�������t�� x1 < x2 < x3
        		return true; //Ȼ�᷵��true
        }
        return false;
    }
}
