package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseOnlyLetters {
    class CharPos {
        // 記錄字符
        public char c;
        // 記錄特殊字符位置
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

        // 把所有非特殊字符加進字串當中
        for(int i = 0; i < cs.length; i ++) {
            char c = cs[i];
            if(isVaild(c) == true) {
                sb.append(c + "");

                // 若為特殊字符，則放進arrayList裡面以待處理
            } else {
                CharPos cPos = new CharPos(c, i);
                specChars.add(cPos);
            }
        }

        // 倒轉
        sb.reverse();

        // 再依序放入特殊符號
        for(CharPos p : specChars) {
            sb.insert(p.pos, p.c + "");
        }


        return sb.toString();
    }

    // 檢查是否為特殊字符
    boolean isVaild(char c) {
        if(c >= 65 && c <= 90)
            return true;

        if(c >= 97 && c <= 122)
            return true;

        return false;
    }
}
