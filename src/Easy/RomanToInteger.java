public class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        
        int perv = 0;
        int cur = 0;
        for(int i = 0; i < s.length(); i ++) {
            String curRoman = s.substring(i, i + 1);

            switch(curRoman) {
                case "M":
                    cur = 1000;
                    break;
                case "D":
                    cur = 500;
                    break;
                case "C":
                    cur = 100;
                    break;
                case "L":
                    cur = 50;
                    break;
                case "X":
                    cur = 10;
                    break;
                case "V":
                    cur = 5;
                    break;
                case "I":
                    cur = 1;
                    break;
            }
            
            if(perv < cur) {
                ans = ans - perv - perv;
            }
            ans = ans + cur;
            perv = cur;
        }
        
        return ans;
    }
}