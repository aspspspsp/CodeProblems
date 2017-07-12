package LeetCode.Easy;

//strstr()函数用来检索子串在字符串中首次出现的位置，其原型为：
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        //haystack(被查找的字符串)的大小
        int length1 = haystack.length();
        //needle(要查找的字符串)的大小
        int length2 = needle.length();
        
        //haystack的長度小於needle的長度表示haystack決不可能包含needle
        if(length1 < length2)
            return -1;
        //若needle的長度為0，可以表示在一開始就匹配
        else if(length2 == 0)
            return 0;
        
        //開始匹配字符串
        
        //避免匹配超過haystack的長度導致錯誤
        int matching_threshold = length1 - length2;
        
        for(int i = 0; i <= matching_threshold; i ++) {
            //逐步匹配
            if(haystack.substring(i, i + length2).equals(needle))
                return i;
        }
        
        //匹配不到則返回-1
        return -1;
    }
}