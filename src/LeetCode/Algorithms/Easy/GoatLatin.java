package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class GoatLatin {
    public String toGoatLatin(String S) {
        String [] words = S.split(" ");

        List<String> vowels = new ArrayList<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        for(int i = 0; i < words.length; i ++) {
            boolean isVowel = false;

            // 檢查該單詞的頭字符是否為母音，是的話則為vowel
            for(int j = 0; j < vowels.size(); j ++) {
                if(words[i].toLowerCase()
                        .substring(0, 1)
                        .equals(vowels.get(j)) == true) {
                    isVowel = true;
                    break;
                }
            }

            // 若是vowel則將該單詞進行變化 ex: Goat => oatG
            if(isVowel == false) {
                if(words[i].length() > 1)
                    words[i] = words[i].substring(1, words[i].length()) +
                            words[i].substring(0, 1);
            }

            // 在單詞後面加上ma
            words[i] += "ma";

            // 再依照當前的單詞順序加上a
            for(int j = 1; j <= i + 1; j ++) {
                words[i] += "a";
            }
        }

        // 將答案句子做整理
        String result = "";
        for(int i = 0; i < words.length; i ++) {
            if(i != words.length - 1)
                result += words[i] + " ";
            else
                result += words[i];
        }

        // 輸出
        return result;
    }
}
