package LeetCode.Hard;
/*
 *
首先要理解题意:
"a"对应"a", 这种匹配不解释了
任意字母对应".", 这也是正则常见
0到多个相同字符x,对应"x*", 比起普通正则,这个地方多出来一个前缀x. x代表的是 相同的字符中取一个,比如"aaaab"对应是"a*b"
"*"还有一个易于疏忽的地方就是它的"贪婪性"要有一个限度.比如"aaa"对应"a*a", 代码逻辑不能一路贪婪到底
正则表达式如果期望着一个字符一个字符的匹配,是非常不现实的.而"匹配"这个问题,非 常容易转换成"匹配了一部分",整个匹配不匹配,要看"剩下的匹配"情况.这就很好的把 一个大的问题转换成了规模较小的问题:递归
确定了递归以后,使用java来实现这个问题,会遇到很多和c不一样的地方,因为java对字符 的控制不像c语言指针那么灵活charAt一定要确定某个位置存在才可以使用.
如果pattern是"x*"类型的话,那么pattern每次要两个两个的减少.否则,就是一个一个 的减少. 无论怎样减少,都要保证pattern有那么多个.比如s.substring(n), 其中n 最大也就是s.length()
 */
public class RegularExpressionMatching {
    /**
        @para s: 字符串
        @para p: 正規表達式
    */
    public boolean isMatch(String s, String p) {
        // 當正規表達式長度為0時
        if(p.length() == 0) {
            if(s.length() == 0)
                return true;
            else
                return false;
        }
        
        // 當正規表達式長度為1時(special case)
        if(p.length() == 1) {
            // 字符串長度為0時返回false
            if(s.length() < 1)
                return false;
            // 當第一個字符串不符合正規表達式的時候返回false
            else if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))
                return false;
            // 比較剩下的字符串與正規表達式
            else
                return isMatch(s.substring(1), p.substring(1));
        }
        
        // 當正規表達式的第二個字元不為'*'時(case 1)
        if(p.charAt(1) != '*') {
            // 字符串長度為0時返回false
            if(s.length() < 1)
                return false;
             // 當第一個字符串不符合正規表達式的時候返回false
            else if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))
                return false;
            // 比較剩下的字符串與正規表達式
            else
                return isMatch(s.substring(1), p.substring(1));
        } 
        // 當正規表達式的第二個字元為'*'時(case 2)，此情況最為複雜
        else {
            // case 2.1: a char & '*' can stand for 0 element
            if(isMatch(s, p.substring(2)) == true)
                return true;
            
            // case 2.2: a char & '*' can stand for 1 or more preceding element, 
    		// so try every sub string
            int i = 0;
            while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if(isMatch(s.substring(i + 1), p.substring(2)))
                    return true;
                i ++;
            }
            
            return false;
        }
    }
}