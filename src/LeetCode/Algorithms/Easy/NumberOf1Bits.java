package src.LeetCode.Algorithms.Easy;
/*
 * 通过与运算符判断最低位是否是1，然后再右移。
 * 重复此步骤直到原数归零。
 */
public class NumberOf1Bits {	
    public int hammingWeight(int n) {
        int one_count = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                one_count ++;
            }
            
            // >>  :右移运算符，num >> 1,相当于num除以2
            // >>> :无符号右移，忽略符号位，空位都以0补齐
            n >>>= 1; //向右移一位(除以2，並忽略符号位(有負號的問題))
        }
        
        return one_count;
    }
}