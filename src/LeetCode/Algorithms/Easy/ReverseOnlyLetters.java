package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseOnlyLetters {
    class CharPos {
        // �O���r��
        public char c;
        // �O���S��r�Ŧ�m
        public int pos;
        public CharPos(char c, int pos) {
            this.c = c;
            this.pos = pos;
        }
    }

    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder("");
        char[] cs = S.toCharArray();
        List<CharPos> specChars = new ArrayList<>();

        // ��Ҧ��D�S��r�ť[�i�r���
        for(int i = 0; i < cs.length; i ++) {
            char c = cs[i];
            if(isVaild(c) == true) {
                sb.append(c + "");

                // �Y���S��r�šA�h��iarrayList�̭��H�ݳB�z
            } else {
                CharPos cPos = new CharPos(c, i);
                specChars.add(cPos);
            }
        }

        // ����
        sb.reverse();

        // �A�̧ǩ�J�S��Ÿ�
        for(CharPos p : specChars) {
            sb.insert(p.pos, p.c + "");
        }


        return sb.toString();
    }

    // �ˬd�O�_���S��r��
    boolean isVaild(char c) {
        if(c >= 65 && c <= 90)
            return true;

        if(c >= 97 && c <= 122)
            return true;

        return false;
    }
}
