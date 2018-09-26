package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();

        // �B�z�ҥ~���p
        if(S == null || S.length() == 0) {
            result.add("");
            return result;
        }

        // �r���ഫ��char�ƲաA��K�B�z
        char[] cs = S.toCharArray();

        // �q�r�ꪺ��0�Ӧr�ťX�o�A�i��DFS
        dfs(cs, 0, result);

        return result;
    }

    void dfs(char[]cs, int pos, List<String> result) {
        // ���F�n�K�[�r���b�r��̫᪺���G�A�������ަp�󳣭n�K�[�o�ӵ��G
        result.add(new String(cs));

        // �Y���M������A�O�o���}
        if(pos == cs.length)
            return;

        // ���M�q�}�l��m�쵲������m
        for(int i = pos; i < cs.length; i ++) {
            // �J��r���~�i��U�@�B
            // �B�z�j�g����
            if(cs[i] >= 65 && cs[i] <= 90) {
                cs[i] += 32;
                dfs(cs, i + 1, result);
                cs[i] -= 32; // �O�o�٭즨�쥻�����A(DFS�M��)
                // �B�z�p�g����
            } else if(cs[i] >= 97 && cs[i] <= 122) {
                cs[i] -= 32;
                dfs(cs, i + 1, result);
                cs[i] += 32; // �O�o�٭즨�쥻�����A(DFS�M��)
            }
        }
    }
}
