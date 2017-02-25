package Easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        
        int pos_a = a.length() - 1;
        int pos_b = b.length() - 1;
        int carries = 0;
        String result = "";
        
        //處理位元較少的數
        while(pos_b >= 0) {
            int sum = 
                (int)(a.charAt(pos_a) - '0') 
                + (int)(b.charAt(pos_b) - '0') + carries;
            result = String.valueOf(sum % 2) + result;
            carries = sum / 2;
            pos_a --;
            pos_b --;
        }
        
        //處理位元較多的數
        while(pos_a >= 0) {
            int sum = (int)(a.charAt(pos_a) - '0') + carries;
            result = String.valueOf(sum % 2) + result;
            carries = sum / 2;
            pos_a --;
        }
        
        //處理最後需要進1
        if(carries == 1)
            result = "1" + result;
        
        return result;
    }
}