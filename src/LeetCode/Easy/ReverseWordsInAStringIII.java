package LeetCode.Easy;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0 || s.equals("") == true)
            return s;
        
        String[] ns = s.split(" ");
        if(ns.length == 0)
            return s;
        
        if(ns.length == 1) {
            StringBuilder result = new StringBuilder(s);
            return result.reverse().toString();
        }
        
        //使用StringBuilder可以方便的使用reverse，且比StringBuffer快，但StringBuilder線程不安全
        StringBuilder result = new StringBuilder("");
        for(String ss : ns) {
            StringBuilder sb = new StringBuilder(ss);
            result.append(" ");
            result.append(sb.reverse());
        }
        
        return result.substring(1);
    }

}