package src.LeetCode.Easy;

public class AddBinary {
    public String addBinary(String a, String b) {
    	//讓a長度始終大於b，確保以下處理是正確的
        if(a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        
        int pos_a = a.length() - 1; //a的指針
        int pos_b = b.length() - 1; //b的指針
        int carries = 0; //進位符，1要進位，0不進位
        String result = "";
        
        //處理a與b相加，a與b都有數字的部分，將他們在a上進行相加
        while(pos_b >= 0) {
            int sum = 
                (int)(a.charAt(pos_a) - '0') 
                + (int)(b.charAt(pos_b) - '0') + carries;
            result = String.valueOf(sum % 2) + result;
            carries = sum / 2;
            pos_a --;
            pos_b --;
        }
        
        //處理a剩下需要進位的部分
        while(pos_a >= 0) {
            int sum = (int)(a.charAt(pos_a) - '0') + carries;
            result = String.valueOf(sum % 2) + result;
            carries = sum / 2;
            pos_a --;
        }
        
        //若進位符為1，表示最前面還有二進位數字要進位，故在二進位數字的最前面加上1
        if(carries == 1)
            result = "1" + result;
        
        return result;
    }
}