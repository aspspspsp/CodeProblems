package LeetCode.Easy;

import java.util.LinkedList;

/*
���һ���㷨���ж�һ�������Ƿ񡰿��֡���
���������Ա��������̶��壺
һ�������������������λ���ֵ�ƽ���ͣ��õ�һ���µ����֣�
�ٶ�����µ������ظ���һ���̣�ֱ�����õ�:
1.����1
2.����ĳ�������ֵ�����ѭ��(����옷��)��
����Щ�����У������������������ܵõ�����1�����֣�����Ϊ������������
*/
public class HappyNumber {
    public boolean isHappy(int n) {
        int temp = n;
        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(n);
        while(true) {
            temp = getNextNumber(temp);
            if(temp == 1) {
                return true;
            } else if(nums.contains(temp)) {
                return false;
            }
            nums.add(temp);
        }
    }
    
    int getNextNumber(int num) {
        int result = 0;
        while(num > 0) {
            result = result + (num % 10) * (num % 10);
            num = num / 10;
        }
        
        return result;
    }
}