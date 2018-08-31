package src.LeetCode.Easy;

public class CountAndSay {
    /*
     n = 1时，打印一个1
     n = 2时，看n=1那一行，念：1个1，所以打印：11
     n = 3时，看n=2那一行，念：2个1，所以打印：21
     n = 4时，看n=3那一行，念：一个2一个1，所以打印：1211
     以此类推。(注意这里n是从1开始的）
    */
    public String countAndSay(int n) {
        if(n <= 0)
            return "";
        String curResult = "1";
        for(int start = 1; start < n; start ++) {
            StringBuilder result = new StringBuilder();
            
            int count = 1;
            for(int j = 1; j < curResult.length(); j ++) {
                if(curResult.charAt(j) == curResult.charAt(j - 1)) {
                    count ++;
                } else {
                    result.append(count);
                    result.append(curResult.charAt(j - 1));
                    count = 1;
                }
            }
            result.append(count);
            result.append(curResult.charAt(curResult.length() - 1));
            curResult = result.toString();
        }
        
        return curResult;
    }
}