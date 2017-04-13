package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
    /*
     * 
Hint:
1.The naive approach is to call isUgly for every number until you reach the nth one. 
  Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
2.An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
3.The key is how to maintain the order of the ugly numbers. Try a similar approach of 
  merging from three sorted lists: L1, L2, and L3.
4.Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
     */
    public int nthUglyNumber(int n) {
        if(n<=0)
            return 0;
     
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
     
        int i = 0;
        int j = 0;
        int k = 0;
        
     
        while(list.size() < n){
            int m2 = list.get(i) * 2;
            int m3 = list.get(j) * 3;
            int m5 = list.get(k) * 5;
     
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
     
            if(min == m2)
                i ++;
     
            if(min == m3)
                j ++;
      
            if(min == m5)
                k ++;
        }
     
        return list.get(list.size() - 1);
    }
}
