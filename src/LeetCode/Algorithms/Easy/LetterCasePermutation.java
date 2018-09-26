package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();

        // 處理例外情況
        if(S == null || S.length() == 0) {
            result.add("");
            return result;
        }

        // 字串轉換成char數組，方便處理
        char[] cs = S.toCharArray();

        // 從字串的第0個字符出發，進行DFS
        dfs(cs, 0, result);

        return result;
    }

    void dfs(char[]cs, int pos, List<String> result) {
        // 為了要添加字母在字串最後的結果，必須不管如何都要添加這個結果
        result.add(new String(cs));

        // 若歷遍完成後，記得離開
        if(pos == cs.length)
            return;

        // 歷遍從開始位置到結束的位置
        for(int i = pos; i < cs.length; i ++) {
            // 遇到字母才進行下一步
            // 處理大寫部分
            if(cs[i] >= 65 && cs[i] <= 90) {
                cs[i] += 32;
                dfs(cs, i + 1, result);
                cs[i] -= 32; // 記得還原成原本的狀態(DFS套路)
                // 處理小寫部分
            } else if(cs[i] >= 97 && cs[i] <= 122) {
                cs[i] -= 32;
                dfs(cs, i + 1, result);
                cs[i] += 32; // 記得還原成原本的狀態(DFS套路)
            }
        }
    }
}
