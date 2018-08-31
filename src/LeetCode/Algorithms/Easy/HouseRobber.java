package src.LeetCode.Algorithms.Easy;

public class HouseRobber {
    /*
    這題可以用動態規劃來解題，遞歸式如下：
    results[0] = nums[0]
    results[0] = max(nums[0], nums[1])
    results[i] = max(results[i - 1], results[i - 2] + nums[i])    if  i >= 2
                       往前第一個        往前第二個  +  目前

    例如：
    step      0 1 2 3 4
    ====================
    nums    = 1 2 3 4 5
    results = 1 2 4 6 9
    
    */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        
        if(n == 1)
            return nums[0];
        
        //存儲結果
        int[] results = new int[n + 1];
        
        //定義初始狀態
        results[0] = nums[0];
        results[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < n; i ++) {
            int rob_house_1 = results[i - 2] + nums[i]; //搶前面第二個+目前這個
            int rob_house_2 = results[i - 1]; //搶前面一個

            results[i] = Math.max(rob_house_1, rob_house_2); //比較兩者誰較大
        }
        
        return results[n - 1];
    }
}