package src.LeetCode.Algorithms.Easy;

import java.util.HashMap;

//当字符串 s 中的字符可以被替换得到另一个字符串 t , 则表示字符串 s 和 t 是同构。
/* ex:
    apple  a對應到a,p對應到b,l對應到c,e對應到c
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
                //當前字符是否s->t與t->s是否相同
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