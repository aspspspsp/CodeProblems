package LeetCode.Easy;

public class RotateArray {
/*
ÿ�ν���range=n-k��Χ�ڵ�����
��[1,2,3,4,5,6,7] k = 3�� ���������� [7, 5, 6, 1, 2, 3, 4]
��ʱn = k_last, k = n- (range%k_last) = 2
�����[6, 5, 7], ��������ȥ��ֱ��k = 0 or n<=1
ע���ǴӺ���ǰ����
*/
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //(k = k % n)�Ǳ���Ӻ���ǰ�����Ć��}
        while((k = k % n) > 0 && n > 1) {
            //���Qrange = n-k��Χ�ڵĔ���
            int range = n - k;
            for(int i = 1; i <= range; i ++) {
                int temp = nums[n - i];
                nums[n - i] = nums[n - i - k];
                nums[n - i - k] = temp;
            }
            
            //����Ӻ���ǰ�����Ć��}
            n = k;
            k = n - (range % k);
        }
        
    }
}