package src.LeetCode.Algorithms.Medium;
/*
��̬�滮����
Ϊ�˽���ʱ�临�Ӷȣ�������Ҫ��������ķ������Աȸ�����ʾ��:
F(0)��F(1)�����𣬾���
F(0)�г���A[i-1]֮�⣬���������ֶ�������һ�������һ�Ҫ�ټ�ȥ(i-1)*A[i-1]
F(1)����������4��3��2��Ȼ���ټ�ȥ��36��F(1)=F(0)+4+3+2-36=16��
������ǿ����������һ����ʽ��
F(i)=F(i-1)+(sum-A[sumIndex])-(A.length-1)*A[sumIndex]������
sumIndex=-i+A.length
����תʱҪ������i-1�ƶ���0���Ǹ�ֵ��
sumΪ����A������ֵ�ĺͣ�
��(sum - A[sumIndex]) ��Ȼ��������A�г�������ΪsumIndex֮����������ֵ�ĺ͡�
���ֽⷨ��ʱ�临�Ӷ���O(n)��
*/

public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        // 计算出sum
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
    
        int base = 0;
        // 计算出F[0]的值ֵ
        for (int i = 0; i < A.length; i++) {
            base += i * A[i];
        }
    
        int max = base;
        for (int i = 1; i < A.length; i++) {
            int sumIndex = A.length - i;
            // 公式展开后，得出如下
            base += sum - A.length * A[sumIndex];   // base += (sum - A[sumIndex]) - (A.length - 1) * A[sumIndex]; 
            max = Math.max(max, base);
        }
        return max;
    }
}