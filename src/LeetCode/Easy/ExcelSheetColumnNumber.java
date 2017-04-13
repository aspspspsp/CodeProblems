package LeetCode.Easy;

import java.util.HashMap;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
            
        HashMap<Character, Integer> alphabetMap = new HashMap<>();
        
        //������ĸ���ұ�
        char alphabet = 'A';
        for(int i = 1; i <= 26; i ++) {
            alphabetMap.put(alphabet, i);
            
            //��char + 1������׌��ĸ"����" ex:A->B
            alphabet += 1;
        }
        
        int number = 0;
        int d = 0;
        for(int i = s.length() - 1; i >= 0; i --) {
            char cur_alphabet = s.charAt(i);
            
            //������ĸ���ұ��ҵ�ԓ��ĸ������ֵ
            int char_id = alphabetMap.get(cur_alphabet);
            number = number + char_id * (int)Math.pow(26, d);
            
            d ++;
        }
        
        return number;
    }
}