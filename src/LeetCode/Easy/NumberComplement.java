package src.LeetCode.Easy;

public class NumberComplement {
    public int findComplement(int num) {
        int n = num;
        int all = 1; //存儲掩碼(遮罩) ex:0000001111 遮罩第0~3位
        
        //求掩碼
        while(n > 1) {
            n >>= 1;
            all = (all << 1) | 1;
        }
        
        int complement = num ^ all; //補數即為目前數字^掩碼
        return complement;
    }
}
