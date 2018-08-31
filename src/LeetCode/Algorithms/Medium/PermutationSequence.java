package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        //初始化所有數字
        List<Integer> numberList = new ArrayList<>();
        for(int i = 1; i <= n; i ++) {
            numberList.add(i);
        }
        
        //將k變為index
        k --;
        
        //設mod為n的階乘
        int mod = 1;
        for(int i = 1; i <= n; i ++) {
            mod = mod * i;
        }
        
        //找到該排列(第k個)
        String result = "";
        for(int i = 0; i < n; i ++) {
            mod = mod / (n - i);
            
            //
            int curIndex = k / mod;
            
            //更新k
            k = k % mod;
            
            //將結果加入result
            result += numberList.get(curIndex);
            
            //刪除這個
            numberList.remove(curIndex);
        }
        
        return result;
    }
}