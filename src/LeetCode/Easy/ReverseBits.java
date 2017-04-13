package LeetCode.Easy;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //��򵥵�������ԭ����������ȡ�����λ���������������λ�������ٲ������ơ�
        int reversed = 0;
        for(int i = 0; i < 32; i ++) {
            //�������������λ�������ٲ������ơ�
            reversed = (reversed << 1) | (n & 1);
            //ԭ����������ȡ�����λ
            n = (n >> 1);
        }
        
        return reversed;
 
    }
}