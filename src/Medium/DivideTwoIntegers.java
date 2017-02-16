package Medium;
public class DivideTwoIntegers {
    /*
    這題是用移位運算來解題
    
    此問題可被分解為下列形式:
    num = (a_0 * 2^0) + (a_1 * 2^1) + (a_2 * 2^2) + ... + (a_n * 2^n)
    */
    public int divide(int dividend, int divisor) {
        //若除數與被除數為零時
        if(dividend == 0 || divisor == 0)
            return 0;
        
        //判斷是否為負數
        boolean isNegative = false;
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
            isNegative = true;
        
        //轉換型別成為長整形，並都轉換為正數
        long abs_dividend = Math.abs((long)dividend);
        long abs_divisor = Math.abs((long)divisor);
        
        //答案為小數的狀況一律返回0(配合Integer型別)
        if(abs_divisor > abs_dividend) 
            return 0;
            
        //處理極端狀況
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
            
        //開始利用減法代替除法
        int result = 0;
        while(abs_dividend >= abs_divisor) {
            //计算需要的左移位数
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