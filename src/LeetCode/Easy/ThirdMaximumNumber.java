package LeetCode.Easy;
/*
���֪����ô��ڶ����������ô������������˼·����һ���ġ�
��ô��������������
first, second,third���ֱ𱣴��һ�󣬵ڶ��󣬺͵��������
Ȼ�����Ǳ������飬��������������ִ��ڵ�ǰ��һ�����first
��ô�����������Դ�λ��ֵ�������ǰ���ִ���second��С��first
��ô�͸���second��third�������ǰ���ִ���third��С��second�Ǿ�ֻ����third
ע�������и��ӣ����ǳ�ʼ��Ҫ�ó�����long����Сֵ��������������MIN_VALUE
����ʱ������Ͳ�֪���÷���MIN_VALUE�������ֵfirst��
*/
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if(nums[i] > second && nums[i] < first) {
                third = second;
                second = nums[i];
            } else if(nums[i] > third && nums[i] < second) {
                third = nums[i];
            }
        }
        
        if(second == Long.MIN_VALUE || third == Long.MIN_VALUE)
            return (int)first;
        return (int)third;
    }
}