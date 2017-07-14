package LeetCode.Medium;
public class CoinChange {
    /*
    amount = 12
    ex: 2,5
    
    i = 0 d[0] = 0
    i = 1 d[1] = Integer.MAX_VALUE
    i = 2 d[2] = d[i - k] + 1 = d[2 - 2] + 1 = 1
    i = 3 d[3] = Integer.MAX_VALUE
    i = 4 d[4] = d[i - k] + 1 = d[4 - 2] + 1 = 2
    i = 5 d[5] = d[i - k] + 1 = d[5 - 5] + 1 = 1
    i = 6 d[6] = d[i - k] + 1 = d[6 - 2] + 1 = 3
    i = 7 d[7] = Integer.MAX_VALUE
    i = 8 d[8] = d[i - k] + 1 = d[6 - 2] + 1 = 4
    i = 9 d[9] = Integer.MAX_VALUE
    i = 10 d[2] = d[i - k] + 1 = d[10 - 2] + 1 = 5
    i = 11 d[11] = Integer.MAX_VALUE
    i = 12 d[12] = d[i - k] + 1 = d[12 - 2] + 1 = 6
    */
    public int coinChange(int[] coins, int amount) {
        int [] d = new int[amount + 1];
        
        //組成0，只有0種的硬幣選擇
        d[0] = 0;
        
        //1~amount都設為無限大(表示先假設所有的數都是目前的硬幣無法達到的)
        for(int i = 1; i <= amount; i ++) {
            d[i] = Integer.MAX_VALUE;
        }
        
        //從1~amount，將所有的數過一遍
        for(int i = 1; i <= amount; i ++) {
            //每次i循環時，都要將所有的硬幣過一遍
            for(int j = 0; j < coins.length; j ++) {
                //d[i - coins[j]] == Integer.MAX_VALUE 表示該i-coins[j]個數無解
                if(i >= coins[j] && d[i - coins[j]] != Integer.MAX_VALUE) {
                    //比較d[i]無解,與d[i - coins[j]] + 1哪個小
                    d[i] = Math.min(d[i], d[i - coins[j]] + 1);
                }
            }
        }
        
        //若d[amount] == Integer.MAX_VALUE，就是沒有解
        if(d[amount] != Integer.MAX_VALUE)
            return d[amount];
        else
            return -1;
    }
}