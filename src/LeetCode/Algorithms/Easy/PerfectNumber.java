package src.LeetCode.Algorithms.Easy;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num == 1)
            return false;
        
        int sum = 0;
        for(int i = 2; i * i <= num; i ++) {
            if(num % i == 0)
                sum += i + num / i;
        }
        
        sum ++;
        
        if(sum != num)
            return false;

        return true;
    }
}