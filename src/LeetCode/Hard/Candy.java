package LeetCode.Hard;

import java.util.Arrays;

/*
ratings        candies
===================================
第一次循環  1 2 3 2 1     1 2 3 1 1
第二次循環  1 2 3 2 1     1 2 3 2 1
答案為 1 + 2 + 3 + 2 + 1 = 9
*/
public class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        //紀錄糖果數量
        int[] candies = new int[ratings.length];
        //每個孩子最少得一顆糖果
        Arrays.fill(candies, 1);
        
        //若只有一個孩子，可以直接返回答案
        if(ratings.length < 2)
            return 1;
        
        //第一次循環確定右邊評分比左邊高的孩子的到比左邊的孩子多一顆糖果
        for(int i = 1; i < ratings.length; i ++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        //第二次循環確定左邊評分比右邊高的孩子的到比右邊的邊多一顆糖果
        for(int i = ratings.length - 2; i >= 0; i --) {
                                              //確保不會多拿糖果
            if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        //紀錄答案
        int result = 0;
        //把所有糖果加起來
        for(int i = 0; i < candies.length; i ++) {
            result += candies[i];
        }
        
        //返回答案
        return result;
    }
}