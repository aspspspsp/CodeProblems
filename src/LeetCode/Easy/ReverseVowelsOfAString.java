package LeetCode.Easy;

import java.util.HashSet;

public class ReverseVowelsOfAString {
    /*
    hint:�a��һ�Mһģһ�ӵĔ����Թ����Q
    */
    public String reverseVowels(String s) {
        //�o�ĸ����HashSet
        HashSet<Character> vowels = new HashSet<>();
        
        //С����ĸ��
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        //�󌑵�ĸ��
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        //�o�Ҫ���Q��ĸ��λ��
        int[] position = new int[s.length()];
        int counter = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(vowels.contains(s.charAt(i))) {
                position[counter] = i;
                counter ++;
            }
        }
        
        //answer�Ǽo䛴𰸵�char
        char[] answer = new char[s.length()];
        
        //�Ȍ�s�D��char���M�K����answer(�a���csһ�ӵĔ���)
        answer = s.toCharArray();
        //���Qĸ����λ��
        for(int i = 0; i < counter; i ++) {
            answer[position[i]] = s.charAt(position[counter - i - 1]);
        }
        
        //��char���M�D��string
        return String.valueOf(answer);
    }
}