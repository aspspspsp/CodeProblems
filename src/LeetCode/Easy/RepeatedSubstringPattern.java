package LeetCode.Easy;

public class RepeatedSubstringPattern {
	//利用正則表達式來解題
    public boolean repeatedSubstringPattern(String s) {
        boolean matcher = s.matches("(.+)\\1+");
        return matcher;
    }
}