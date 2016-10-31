package Easy;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length; //���ݿ���
        
        if(n == 0)
            return 0;
        
        if(n == 1)
            return nums[0];
            
        int [] ansTable = new int[n];
        
        ansTable[0] = nums[0];
        
        ansTable[1] = Math.max(nums[0], nums[1]);
        
        
        //�ĵ������_ʼ����(������|߅��)
        for(int i = 2; i < n; i ++) {
            //��ǰ�� = max(��ǰ2���� + ��ǰ���݃rֵ, ��ǰ1����)       
            ansTable[i] = Math.max(ansTable[i - 2] + nums[i], ansTable[i - 1]);
            //                     ͵ǰ2�� + ��ǰ�@��, ͵ǰ1�� + ��͵��ǰ
        }
        
        return ansTable[n - 1];
    }

}