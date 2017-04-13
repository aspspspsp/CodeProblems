package LeetCode.Medium;

/*
���˷eҪ���]��ؓ���Ć��}����ʹ�Ãɂ����M��ӛ䛄ӑBҎ���ĽY��
���B�����M�r��ÿ��Ԫ���ЃɷN����:������ؓ��
���Ԯ���ǰ��ؓ���r����Ҫ׷ۙÿ�΄ӑBҎ������Сֵ�������������ҵ����ֵ
�҂����x�ɂ�����׃����һ��׷ۙ���ֵ����һ��׷ۙ��Сֵ
*/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int [] maxResult = new int[nums.length];
        int [] minResult = new int[nums.length];
        
        //���x��ʼֵ
        maxResult[0] = nums[0];
        minResult[0] = nums[0];
        
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i ++) {
            //����ǳ˷�����Ҫ���]�ɷN��r
            if(nums[i] > 0) {
                //�ӑBҎ��
                //֮����Ҫ����nums[i]�cmaxResult[i - 1]���^���ǿ��]��*0����r
                maxResult[i] = Math.max(nums[i], maxResult[i - 1] * nums[i]);
                minResult[i] = Math.min(nums[i], minResult[i - 1] * nums[i]);
            } else {
                //�ӑBҎ��
                maxResult[i] = Math.max(nums[i], minResult[i - 1] * nums[i]);
                minResult[i] = Math.min(nums[i], maxResult[i - 1] * nums[i]);
            }
            //�ڽY�����xһ������
            result = Math.max(result, maxResult[i]);
        }
        
        return result;
    }
}