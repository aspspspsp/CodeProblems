package LeetCode.Medium;

public class GasStation {
    /*
    這題的意思就是求出從哪一個加油站開始，能走完整個旅程，並且這個結果是唯一的。
    首先，我們可以得到所有加油站的油量的totalGas，以及總里程需要消耗的油量totalCost，
    如果totalCost大於totalGas，那麼鐵定不能夠走完整個旅程。
    如果totalGas大於TotalCost，那麼就能走完整個旅程了，假設現在我們到達了第i個加油站
    ，這時候還剩餘的油量為sum，如果sum + gas[i] - cost[i]小於0，我們則無法走到下一個
    加油站，所以起點一定不在第i個以及之前的加油站裡面(都鐵定走不到第i + 1號加油站)，起
    點只能在i + 1後者的後面。
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int k = 0;
        
        for(int i = 0; i < gas.length; i ++) {
            sum += gas[i] - cost[i];
            //小於0就只可能在i + 1之後了
            if(sum < 0) {
                k = i + 1;
                sum = 0;
            }
            total += gas[i] - cost[i];
        }
        
        if(total < 0) {
            return -1;
        } else {
            return k;
        }
    }
}