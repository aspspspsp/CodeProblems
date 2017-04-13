package LeetCode.Medium;

public class MinimumSizeSubarraySum {
    /*
    �������ǲ��û������ڵ�˼�룬���£�
    target:7
     2  3  1  2  4  3
    [2]                +
    [2  3]             +
    [2  3  1]          +
    [2  3  1  2]       +
       [3  1  2]       -
          [1  2  4]    *
          [1  2  4  3] +
             [2  4  3] -
                [4  3] *
    �������� [left, right] ��ʼ��СΪ0�������Ĺ������£�
    1.��Ԫ��֮�� < s�������ұ����������죬ֱ�� Ԫ��֮�͡�s Ϊֹ��
    2.��Ԫ��֮�� �� s��������С���ȡ�Ȼ�󴰿����������һλ�����Ƴ������е�һ��Ԫ�أ����ظ���1����
    */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int left = 0; //�o䛻�����߅��
        int right = 0; //�o䛻�����߅��
        
        int result = nums.length + 1; //�o䛽Y��(ԽСԽ��)
        int sum = 0;
        
        int length = nums.length;
        
        while(right < length) { //��׌�һ������^���M����
            sum = sum + nums[right]; //�һ���ؓ؟�Ӕ�(�����Ĺ����Ӵ�)
            
            //���˹����Ĕ��M֮���ѽ��ƽ��s�r���_ʼ��խ����
            while(sum >= s) {
                //������ֻ��һ�����ĕr������С��(Ҳ혱�̎���󻬴�Ҫ���^�һ�������r)
                if(right - left + 1 == 1)
                    return 1;
                
                //�o���С��
                result = Math.min(result, right - left + 1);
                
                sum = sum - nums[left]; //�󻬴�ؓ؟�p��(�����Ĺ����pС)
                
                //�Ƅ��󻬴�
                left = left + 1;
            }
            
            //�Ƅ��һ���
            right = right + 1;
        }
        
        //̎��]�д𰸵���r
        if(result == length + 1)
            return 0;
            
        return result;
    }
}