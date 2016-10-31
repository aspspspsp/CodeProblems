package Easy;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length; //房屋總數
        
        if(n == 0)
            return 0;
        
        if(n == 1)
            return nums[0];
            
        int [] ansTable = new int[n];
        
        ansTable[0] = nums[0];
        
        ansTable[1] = Math.max(nums[0], nums[1]);
        
        
        //從第三個開始尋找(避免接觸邊界)
        for(int i = 2; i < n; i ++) {
            //當前答案 = max(第前2個答案 + 當前房屋價值, 第前1個答案)       
            ansTable[i] = Math.max(ansTable[i - 2] + nums[i], ansTable[i - 1]);
            //                     偷前2家 + 當前這家, 偷前1家 + 不偷當前
        }
        
        return ansTable[n - 1];
    }

}