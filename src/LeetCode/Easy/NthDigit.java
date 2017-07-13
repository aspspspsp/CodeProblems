package LeetCode.Easy;
/*
解法：这里有这样一个规律，从1到9，有9个只占1个位数的数字，数字个数为10 - 1 + 1；从10到99，有90个占2个位数的数字，数字个数为99 - 10 + 1，因此可以得到这样的规律：

范围	    占位	个数	        共占位
1——9	    1	    9-1+1 = 9       9*1=9
10——99	    2	    99-10+1=90	    90*2=180
100——999	3	    999-100+1=900	900*3=2700
……			
因此，如果要超照第n个单数字，首先要算出这个数字在哪个区间范围，在该范围内每个实际的数字占几个位，这个范围内第一个实际数字前已经占用了多少个单数字。然后，根据这些数据求出具体的值。
*/
public class NthDigit {
    public int findNthDigit(int n) {
        // 该范围内所有实际数字都占用了digit个单数字
        int digit = 1;
        // 该范围之前的所有实际数字已经占用了totalDigit个单数字
        long totalDigit = 0;
        // 先查出区间范围
        while(true) {
            //算出下一個總佔位
            long top = totalDigit + digit * 9 * (long)Math.pow(10, digit - 1);
            //若n在區間內則跳出
            if(n >= totalDigit && n <= top) {
                break;
            }
            totalDigit = top;
            digit ++;
        }
        
        // 根据范围算出具体的值
        int start = (int) Math.pow(10, digit - 1);
        int ret = 0;
        totalDigit += 1;
        
        // 第n个digit在哪个具体的实际数字上
        int value = start + (n - (int)totalDigit) / digit;
        
        //取得第n位數
        ret = Integer.toString((int)value).charAt(((int)(n - totalDigit) % digit)) - '0';
        return ret;
    }
}