package Medium;

/*
题意：
给定一串字符串，让你判断是否可以按顺序划分成诺干个数（三个以上），其中前面的两个数和等于第三个数。
如112358划分为1，1，2，3，5，8恰好满足。
注意，划分的数字不能有前导0
*/

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        /*
        對num逐一切分為兩分=>
        ex:123456
        1(從0~i), 2(從i+1~j) .....(其他)
        */
        for(int i = 1; i < num.length(); i ++) {
            //若此數為0開頭卻大於0的數 ex:010，則略過
            if(num.charAt(0) == '0' && i > 1)
                continue;
            
            for(int j = i + 1; j < num.length(); j ++) {
                //若此數為0開頭卻大於0的數 ex:010，則略過
                if(num.charAt(i) == '0' && j - i > 1)
                    continue;
                //對num逐一切分為兩分=>ex: 1(從0~i), 2(從i+1~j) .....(其他)
                if(dfs(num, 0, i, j) == true)
                    return true;
            }
        }
        return false;
    }
    
    // 判断从 [i, j) 和 [j, k) 出发,能否走到尽头
    boolean dfs(String num, int i, int j, int k) {
        //[i, j)
        long num1 = Long.parseLong(num.substring(i, j));
        //[j, k)
        long num2 = Long.parseLong(num.substring(j, k));
        
        //儲存加法後的結果，並以字串方式呈現
        String addition = String.valueOf(num1 + num2);
        
        //num.substring(k)顯示由k開始至結尾的文字
        //num.startsWith(addition) num是否有包含為addition的前綴
        
        //檢查前面兩個數的和是否等於第三個數
        if(num.substring(k).startsWith(addition) == false)
            return false;
        
        //已經完成條件
        if(k + addition.length() == num.length())
            return true;
        
        //繼續向下搜索(由j~k, k~之後，開始)
        return dfs(num, j, k, k + addition.length());
    }
}