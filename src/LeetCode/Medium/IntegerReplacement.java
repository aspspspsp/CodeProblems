package LeetCode.Medium;

public class IntegerReplacement {
    /*
    利用dfs來解這題，每一個狀態為目前的數，還有目前走的步數
    */
    public int integerReplacement(int n) {
        if(n < 0) {
            return 0;
        }
        
        //避免溢出，故要將int轉為long
        Long cur = new Long(n);
        
        //開始dfs
        helper(cur, 0);
        
        //返回答案
        return min_step;
    }
    
    //紀錄最小值
    int min_step = Integer.MAX_VALUE;
    void helper(long cur, int step) {
        
        //剪枝(若走的步數已經超過最小步數，則不用在走下去了)
        if(step > min_step)
            return;
        
        //剪枝(若小於1時，則不用在走下去了)
        if(cur < 1)
            return;
        
        //若已達到目標，則記錄是否為最小步數
        if(cur == 1) {
            if(min_step > step)
                min_step = step;
            return;
        }
        
        //進行下去
        if(cur % 2 == 0) {
            helper(cur / 2, step + 1);
        } else {
            helper(cur + 1, step + 1);
            helper(cur - 1, step + 1);
        }
    }
}