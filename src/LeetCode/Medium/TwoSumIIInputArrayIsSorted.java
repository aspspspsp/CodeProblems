package LeetCode.Medium;
/*
����˫ָ��

��ʼ����ʱ���һ��ָ��left���±�Ϊ0��λ�ã�
�ڶ���ָ��right���±�Ϊn - 1��λ�á�
ͨ���Ƚϼ���ĺ���target���ƶ�ָ�룬��С���ҷ�Χ��

���磬һ��ʼ��ʱ��left = 0, right = n - 1��
�����ʱ�ĺ� sum = numbers[left] + numbers[right]��

�����ʱ�ĺ� > target��˵���ұ�̫���ˣ�right �C-��
��� �� < target, ˵�����̫С�ˣ�left ++��
����պõ��ڣ����ش�ʱ��left, right��
*/
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        if(numbers == null || numbers.length == 0)
            return indices;
        
        //���x���Ҷ�ָ�
        int left = 0, right = numbers.length - 1;
        
        //ʹ�Ã�ָ����ҊA�Ƶķ�ʽ���ҳ��ɂ�index
        while(left >= 0 && right <= numbers.length - 1 && right > left) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                //ݔ���Ĵ���Ҫ����1�_ʼ����Ҫ + 1
                indices[0] = left + 1;
                indices[1] = right + 1;
                break;
            //��߅̫���ˣ�����߅ָ�������
            } else if(sum > target) {
                right --;
            //��߅̫С�ˣ�����߅ָ������� 
            } else {
                left ++;
            }
        }
        return indices;
    }
}