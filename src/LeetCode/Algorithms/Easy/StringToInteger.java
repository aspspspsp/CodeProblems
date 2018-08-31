package src.LeetCode.Algorithms.Easy;

/*
atoi 字串轉整形
*/
public class StringToInteger {
    public int myAtoi(String str) {
        //1. 空字串 或 null 為結束
        if(str == null || str.length() == 0) {
            return 0;
        }
        
        //2. 去除空白
        str = str.trim();
        
        //3.對於正負號的處理
        boolean positive = true; //此數是否為正數
        int index = 0;
        if(str.charAt(0) == '+') {
            index = index + 1;
        } else if(str.charAt(0) == '-') {
            positive = false;
            index = index + 1;
        }
        
        //4. 開始真正的數字轉換
        
        //因為double的範圍比int更大，故使用他來做暫存
        double resultForDouble = 0;
        
        //分別對每一位數進行處理
        for(int i = index; i < str.length(); i ++) {
            int cur_digi = str.charAt(i) - '0'; //將char轉換為int
            
            if(cur_digi < 0 || cur_digi > 9) {
                break;
            }
            
            //處理正數或負數的問題
            //正數的處理
            if(positive == true) {
                //一位一位的加上去
                //123 = 100 + 20 + 3
                resultForDouble = resultForDouble * 10 + cur_digi;
                
                //若此數超過了int最大值則返回最大值
                if(resultForDouble > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                    
            //負數的處理
            } else {
                //一位一位的減下去
                //-123 = -100 - 20 - 3
                resultForDouble = resultForDouble * 10 - cur_digi;
                
                //若此數超過了int最小值則返回最小值
                if(resultForDouble < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
        }
        
        int result = (int)resultForDouble;
        
        return result;
    }
}