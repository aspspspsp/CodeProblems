package src.LeetCode.Algorithms.Easy;
/**
 * ���������λ��������
 * �������ͬΪ0����ͬΪ1��
 * ���Զ�������������򣬵ó����Ǹ�������single number��
 * ��ʼʱ����һ������0���Ȼ���ٶ�ʣ�¶���������������������õ��������ʣ������κ���x������x^x=0��x^0=x
 * 
 *  ͬʱ��������ʣ�
 ������ A XOR B = B XOR A
 ����� A XOR B XOR C = A XOR (B XOR C) = (A XOR B) XOR C
 �Է��� A XOR B XOR B = A XOR 0 = A
 
���Զ������������˵����Ϊֻ��һ��������single�ģ�����������Ա�ʾΪ a a b b c c d d e�� ��ô�����������ɿ��������Ϊ 0 0 0 0 e��
**/

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i ++) {
            result = result ^ nums[i];
        }
        
        return result;
    }
}