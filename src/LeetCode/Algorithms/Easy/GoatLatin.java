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

            // �ˬd�ӳ�����Y�r�ŬO�_�������A�O���ܫh��vowel
            for(int j = 0; j < vowels.size(); j ++) {
                if(words[i].toLowerCase()
                        .substring(0, 1)
                        .equals(vowels.get(j)) == true) {
                    isVowel = true;
                    break;
                }
            }

            // �Y�Ovowel�h�N�ӳ���i���ܤ� ex: Goat => oatG
            if(isVowel == false) {
                if(words[i].length() > 1)
                    words[i] = words[i].substring(1, words[i].length()) +
                            words[i].substring(0, 1);
            }

            // �b����᭱�[�Wma
            words[i] += "ma";

            // �A�̷ӷ�e��������ǥ[�Wa
            for(int j = 1; j <= i + 1; j ++) {
                words[i] += "a";
            }
        }

        // �N���ץy�l����z
        String result = "";
        for(int i = 0; i < words.length; i ++) {
            if(i != words.length - 1)
                result += words[i] + " ";
            else
                result += words[i];
        }

        // ��X
        return result;
    }
}
