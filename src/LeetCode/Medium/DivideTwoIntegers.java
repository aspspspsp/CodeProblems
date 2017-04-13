package LeetCode.Medium;
public class DivideTwoIntegers {
    /*
    �@�}������λ�\�����}
    
    �ˆ��}�ɱ��ֽ��������ʽ:
    num = (a_0 * 2^0) + (a_1 * 2^1) + (a_2 * 2^2) + ... + (a_n * 2^n)
    */
    public int divide(int dividend, int divisor) {
        //�������c����������r
        if(dividend == 0 || divisor == 0)
            return 0;
        
        //�Д��Ƿ��ؓ��
        boolean isNegative = false;
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
            isNegative = true;
        
        //�D�Q�̈́e�ɞ��L���Σ��K���D�Q������
        long abs_dividend = Math.abs((long)dividend);
        long abs_divisor = Math.abs((long)divisor);
        
        //�𰸞�С���Ġ�rһ�ɷ���0(���Integer�̈́e)
        if(abs_divisor > abs_dividend) 
            return 0;
            
        //̎��O�ˠ�r
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
            
        //�_ʼ���Üp���������
        int result = 0;
        while(abs_dividend >= abs_divisor) {
            //������Ҫ������λ��
            int num_shift = 0;
            while(abs_dividend >= (abs_divisor << num_shift)) {
                num_shift ++;
            }
            
            abs_dividend = 
                abs_dividend - (abs_divisor << (num_shift - 1));
            result = 
                result + (1 << (num_shift - 1));
        }
        
        if(isNegative == false)
            return result;
        else
            return -result;
    }
}