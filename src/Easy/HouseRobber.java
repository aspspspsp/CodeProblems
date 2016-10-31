package Easy;
/*
 * 思路分析：典型的动态规划，和求最大和子数组有点类似，
 * ansTable[i] 表示num[0...i]之间的最优解，那么DP方程可以写作
 * ansTable[i] = Max(global[i-2] +  num[i], global[i-1])
 * ,分别对应于取num[i]（此时不能取num[i-1]）和不取num[i]的最优
 * 解，然后取max即可。是一个一维DP，时间和空间复杂度都是O（n）。
 */
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