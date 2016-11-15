package Easy;
/*
利用异或(XOR)运算，分別對s與t中的對每個char進行xor，就可找出多出一個不一樣的char
*/

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char difference = 0;
        if(s == null || s == "") {
            return t.charAt(t.length() - 1);
        }
        
        for(int i = 0; i < s.length(); i ++) {
            difference ^= s.charAt(i);
        }
        
        for(int i = 0; i < t.length(); i ++) {
            difference ^= t.charAt(i);
        }
        
        return difference;
        
    }
}