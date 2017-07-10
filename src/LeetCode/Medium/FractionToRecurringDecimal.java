package LeetCode.Medium;

import java.util.HashMap;

public class FractionToRecurringDecimal {
	/* Given numerator = 1, denominator = 2, return "0.5".
       Given numerator = 2, denominator = 1, return "2".
       Given numerator = 2, denominator = 3, return "0.(6)". 
               將循環的部分括號起來
	 */
    public String fractionToDecimal(int numerator, int denominator) {
        //被除數為0直接返回0
        if(numerator == 0)
            return "0";
        
        //除數為0則沒有結果
        if(denominator == 0)
            return "";
        
        String result = "";
        //處理結果為負數的情況
        if((numerator < 0) ^ (denominator < 0))
            result += "-";
        
        //將int型別轉換為long，並將他們全部以正數來處理
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        
        //求商
        long res = num / den;
        result += String.valueOf(res);
        
        //求餘數
        long remainder = (num % den) * 10;
        
        //若餘數為0可以直接返回結果
        if(remainder == 0)
            return result;
        
        //進行小數的部分
        HashMap<Long, Integer> map = new HashMap<>();
        result += ".";
        while(remainder > 0) {
            //若有循環小數
            if(map.containsKey(remainder)) {
            	//取得循環小數的位數
                int beg = map.get(remainder);
                
                //將循環小數與非循環的部分拼接起來
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }
            
            //若沒有則繼續，且餘數不為零則繼續
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }
        
        return result;
    }
}