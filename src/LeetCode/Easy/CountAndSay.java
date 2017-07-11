package LeetCode.Easy;
/*
1, 11, 21, 1211, 111221, ...

n = 1时，打印一个1
n = 2时，看n=1那一行，念：1个1，所以打印：11
n = 3时，看n=2那一行，念：2个1，所以打印：21
n = 4时，看n=3那一行，念：1个2, 1个1，所以打印：1211
     以此类推。(注意这里n是从1开始的）
     
    所以构建当前行的字符串要依据上一行的字符串。
“小陷阱就是跑完循环之后记得把最后一个字符也加上，因为之前
   只是计数而已。”
   
   比如我们再扫描1211的时候，看1后面是2，则1的count = 1，
   则将count + 1写入字符串中，2也一样，2后面的1,1后面还是1，
   则count++，第二个1后面没有了，则将count+1写入字符串，
   输入完毕。
   因此打印的就是11+12+21即111221。
*/
public class CountAndSay {
    public String countAndSay(int n) {
        if(n <= 0)
            return "";
        
        String curResult = "1";
        
        //start = 1 從1開始算
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
