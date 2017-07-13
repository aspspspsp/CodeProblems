package LeetCode.Easy;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //最简单的做法，原数不断右移取出最低位，赋给新数的最低位后新数再不断左移。
        int reversed = 0;
        for(int i = 0; i < 32; i ++) {
            //赋给新数的最低位后新数再不断左移。
            reversed = (reversed << 1) | (n & 1);
            //赋给新数的最低位后新数再不断左移。
            n = (n >> 1);
        }
        
        return reversed;
 
    }
}