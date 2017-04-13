package LeetCode.Easy;

import java.util.HashMap;

//���ַ��� s �е��ַ����Ա��滻�õ���һ���ַ��� t , ���ʾ�ַ��� s �� t ��ͬ����
/* ex:
    Apple  ÿ���ֶ��Ќ�����һ���ַ�
    |||||
    abbcd
*/
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        
        //�o�s->t�������ַ�
        HashMap<Character, Character> s_t = new HashMap<Character, Character>();
        //�o�t->s�������ַ�
        HashMap<Character, Character> t_s = new HashMap<Character, Character>();
        
        int length = s.length();
        for(int i = 0; i < length; i ++) {
            Character ss = s.charAt(i); //s��ǰ�ִ�
            Character tt = t.charAt(i); //t��ǰ�ִ�
            
            //��s->t��t->s�Ю�ǰ�ַ�����Ϣ
            if(s_t.containsKey(ss) == true || t_s.containsKey(tt) == true) {
                //�t���^s->t == tt && t->s == ss
                if(s_t.get(ss) == tt && t_s.get(tt) == ss) {
                    continue;
                } else {
                    return false;
                }
            } else {
                //�o�s->t�������ַ�
                s_t.put(ss, tt);
                //�o�t->s�������ַ�
                t_s.put(tt, ss);
            }
        }
        
        return true;
    }
}