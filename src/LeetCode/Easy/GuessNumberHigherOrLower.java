package src.LeetCode.Easy;

import src.LeetCode.Dependencies.GuessGame;

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

//猜1~n中任一個數字
public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        //若n為0就沒有必要猜了
        if(guess(n) == 0)
            return n;
        
        //利用二分搜尋法猜
        int left = 1;
        int right = n;
        
        while(left < right) {
            //取得中間
            int mid = left + (right - left) / 2;
            
            //guess可以判斷猜到的數是否正確(或是比較大、比較小)
            int t = guess(mid);
            
            //若猜中t=0則返回答案
            if(t == 0) {
                return mid;
                
            //若猜的數比較大則從左邊開始猜
            } else if(t == 1) {
                left = mid;
            
            //若猜的數比較小則從右邊開始猜
            } else {
                right = mid;
            }
        }
        
        return right;
    }
}