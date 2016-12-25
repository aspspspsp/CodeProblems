package Easy;

import java.util.HashMap;

//当字符串 s 中的字符可以被替换得到另一个字符串 t , 则表示字符串 s 和 t 是同构。
/* ex:
    Apple  每個字都有對應的一個字符
    |||||
    abbcd
*/
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        
        //紀錄s->t對應的字符
        HashMap<Character, Character> s_t = new HashMap<Character, Character>();
        //紀錄t->s對應的字符
        HashMap<Character, Character> t_s = new HashMap<Character, Character>();
        
        int length = s.length();
        for(int i = 0; i < length; i ++) {
            Character ss = s.charAt(i); //s當前字串
            Character tt = t.charAt(i); //t當前字串
            
            //若s->t或t->s有當前字符的消息
            if(s_t.containsKey(ss) == true || t_s.containsKey(tt) == true) {
                //則比較s->t == tt && t->s == ss
                if(s_t.get(ss) == tt && t_s.get(tt) == ss) {
                    continue;
                } else {
                    return false;
                }
            } else {
                //紀錄s->t對應的字符
                s_t.put(ss, tt);
                //紀錄t->s對應的字符
                t_s.put(tt, ss);
            }
        }
        
        return true;
    }
}