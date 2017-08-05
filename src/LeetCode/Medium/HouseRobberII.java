package LeetCode.Medium;

public class HouseRobberII {
    public int rob(int[] nums) {
       if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        
        if(n == 1)
            return nums[0];
        
        //分兩種情況討論，搶房子0與不搶房子0
        
        //** House(0) is robbed **
        int[] results_1 = new int[n + 1];
        //定義初始狀態
        results_1[0] = nums[0];
        results_1[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i ++) {
            int rob_house_1 = results_1[i - 2] + nums[i]; //搶前面第二個+目前這個
            int rob_house_2 = results_1[i - 1]; //搶前面一個

            results_1[i] = Math.max(rob_house_1, rob_house_2); //比較兩者誰較大
        }
        //但最終結果為results_1[n - 2] (因為搶了最後一間房子並不能搶第一間房子)
        
        //** House(0) is not robbed **
        int[] results_2 = new int[n + 1];
        //定義初始狀態
        results_2[0] = 0; //房子0並不搶
        results_2[1] = nums[1];
        for(int i = 2; i < n; i ++) {
            int rob_house_1 = results_2[i - 2] + nums[i]; //搶前面第二個+目前這個
            int rob_house_2 = results_2[i - 1]; //搶前面一個
            
            results_2[i] = Math.max(rob_house_1, rob_house_2); //比較兩者誰較大
        }
        
        //比較兩個結果誰比較大
        int result = Math.max(results_1[n - 2], results_2[n - 1]);
        
        return result;
    }
}