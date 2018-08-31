package src.LeetCode.Easy;
import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        if(n <= 0)
            return result;
        
        for(int i = 1; i <= n; i ++) {
            String temp;
            if(i % 15 == 0)
                temp = "FizzBuzz";
            else if(i % 3 == 0)
                temp = "Fizz";
            else if(i % 5 == 0)
                temp = "Buzz";
            else
                temp = i + "";
            result.add(temp);
        }
        
        return result;
    }
}