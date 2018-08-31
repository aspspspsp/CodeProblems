package src.LeetCode.Algorithms.Easy;

public class Base7 {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        
        String result = "";
      
        boolean isNeg = false;
        if(num < 0)
            isNeg = true;
        
        num = Math.abs(num);
        
        while(num > 0) {
            int remider = num % 7;
            num = num / 7;
            result = remider + result;
            
        }
        
        if(isNeg == true)
            result = "-" + result;
        
        return result;
    }
}