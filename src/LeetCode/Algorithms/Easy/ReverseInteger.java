package src.LeetCode.Algorithms.Easy;

public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegivate = false;
        int startAt = 0;
        String ans = "";

        //檢查是否有負號，若有負號，則將負號後開始，並記錄下來
        if(x < 0) {
            isNegivate = true;
            startAt = 1;
        } else if(x == 0) {
            return 0;
        }
        
        String stringX = x + "";
        //將數字做倒轉
        for(int i = startAt; i < stringX.length(); i ++) {
            ans = stringX.substring(i, i + 1) + ans;
        }

        //若有負號，則在數字字串前面加上負號
        if(isNegivate == true) {
            ans = "-" + ans;
        }
        
        //我們利用Long來轉換字串，避免溢位
        long tmp = Long.parseLong(ans);

        //若答案超過Integer範圍，我們則返回0
        if(tmp < Integer.MIN_VALUE || tmp > Integer.MAX_VALUE)
        {
            return 0;
        }
        
        //將答案轉換為Integer型別
        return Integer.parseInt(ans);
    }
}