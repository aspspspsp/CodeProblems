package src.LeetCode.Algorithms.Easy;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int i = 1;
        while(n >= 0) {
            n -= i;
            i ++;
        }
        
        return i - 2;
    }
}