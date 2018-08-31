package src.LeetCode.Easy;

public class SumOfSquareNumbers {
    /*
    c = a^2 + b^2
    b = (c - a^2)^0.5
    */
    public boolean judgeSquareSum(int c) {
        for(long a = 0; a * a <= c; a ++) {
            double b = Math.sqrt(c - a * a);
            if(b == (int)b)
                return true;
        }
        
        return false;
    }
}