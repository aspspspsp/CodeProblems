package src.LeetCode.Algorithms.Easy;

import java.util.HashMap;
import java.util.Map;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        if(candies == null || candies.length == 0)
            return 0;
            
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int kindOfCandies = 0;
        for(int candy : candies) {
            if(map.containsKey(candy) == false) {
                map.put(candy, 1);
                kindOfCandies ++;
            } 
            
            sum ++;
        }
        
        //哥哥姊姊糖果要分一半
        sum = sum / 2;
        
        if(sum >= kindOfCandies)
            return kindOfCandies;
        else
            return sum;
    }
}