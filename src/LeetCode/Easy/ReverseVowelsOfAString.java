package LeetCode.Easy;

import java.util.HashSet;

public class ReverseVowelsOfAString {
    /*
    hint:產生一組一模一樣的數據以供交換
    */
    public String reverseVowels(String s) {
        //紀錄母音的HashSet
        HashSet<Character> vowels = new HashSet<>();
        
        //小寫的母音
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        //大寫的母音
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        //紀錄要交換的母音位置
        int[] position = new int[s.length()];
        int counter = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(vowels.contains(s.charAt(i))) {
                position[counter] = i;
                counter ++;
            }
        }
        
        //answer是紀錄答案的char
        char[] answer = new char[s.length()];
        
        //先將s轉成char數組並放入answer(產生與s一樣的數據)
        answer = s.toCharArray();
        //交換母音
        for(int i = 0; i < counter; i ++) {
            answer[position[i]] = s.charAt(position[counter - i - 1]);
        }
        
        //將char數組轉成string
        return String.valueOf(answer);
    }
}