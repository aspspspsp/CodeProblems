package Easy;

import java.util.HashMap;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
            
        HashMap<Character, Integer> alphabetMap = new HashMap<>();
        
        //建立字母查找表
        char alphabet = 'A';
        for(int i = 1; i <= 26; i ++) {
            alphabetMap.put(alphabet, i);
            
            //對char + 1，可以讓字母"增加" ex:A->B
            alphabet += 1;
        }
        
        int number = 0;
        int d = 0;
        for(int i = s.length() - 1; i >= 0; i --) {
            char cur_alphabet = s.charAt(i);
            
            //利用字母查找表找到該字母對應的值
            int char_id = alphabetMap.get(cur_alphabet);
            number = number + char_id * (int)Math.pow(26, d);
            
            d ++;
        }
        
        return number;
    }
}