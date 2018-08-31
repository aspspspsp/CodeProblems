package src.LeetCode.Easy;

public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }
        
        final int MAX = 32;
        boolean isNeg = false;
        
        int[] bits = new int[MAX];
        
        if(num < 0) {
            isNeg = true;
            bits[MAX - 1] = 1;
            num = Math.abs(num);
        }
        
        int i = 0;
        //轉化為二進制的原碼
        while(num > 0) {
            bits[i] = num % 2;
            num = num / 2;
            i ++;
        }
        
        //如果是負數，需要取反並且+1從而得到補碼
        if(isNeg == true) {
            //取反
            for(int j = 0; j < bits.length - 1; j ++) {
                bits[j] = (bits[j] + 1) % 2;
            }
            
            //+ 1
            int digit = 1;
            int res = 0;
            for(int j = 0; j < bits.length - 1; j ++) {
                res = bits[j] + digit;
                bits[j] = res % 2;
                digit = res / 2;
            }
        }
        
        //二進制轉化為十六進制
        String result = "";
        for(int j = 0; j < bits.length; j = j + 4) {
            int data = 0;
            for(int k = 0; k < 4; k ++) {
                data += bits[j + k] * (1 << k);
            }
            result = String.format("%x", data) + result;
        }
        
        //去掉字符串前面多餘的0
        for(int j = 0; j < result.length(); j ++) {
            if(result.charAt(j) != '0') {
                result = result.substring(j);
                break;
            }
        }
        
        return result;
    }
}