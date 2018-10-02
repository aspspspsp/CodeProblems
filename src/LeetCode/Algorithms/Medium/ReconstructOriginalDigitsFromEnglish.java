package src.LeetCode.Algorithms.Medium;

import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        char[] cs = s.toCharArray();

        // 建立字母表
        Map<Character, Integer> map = new HashMap<>();
        for(char c : cs) {
            if(map.containsKey(c) == false)
                map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }

        // 用以存儲數字的數量，以方便輸出答案
        Map<Integer, Integer> resultMap = new HashMap<>();
        /************************************
         * 解決第一重特徵 0->z, 2->w, 4->u, 6->x, 8->g
         */
        // 解決0的部分
        if(map.containsKey('z') && map.get('z') > 0) {
            int zeros = map.get('z');
            map.put('z', 0);
            map.put('e', map.get('e') - zeros);
            map.put('r', map.get('r') - zeros);
            map.put('o', map.get('o') - zeros);

            resultMap.put(0, zeros);
        }

        // 解決2的部分
        if(map.containsKey('w') && map.get('w') > 0) {
            int twos = map.get('w');
            map.put('t', map.get('t') - twos);
            map.put('w', 0);
            map.put('o', map.get('o') - twos);

            resultMap.put(2, twos);
        }

        // 解決4的部分
        if(map.containsKey('u') && map.get('u') > 0) {
            int fours = map.get('u');
            map.put('f', map.get('f') - fours);
            map.put('o', map.get('o') - fours);
            map.put('u', 0);
            map.put('r', map.get('r') - fours);

            resultMap.put(4, fours);
        }

        // 解決6的部分
        if(map.containsKey('x') && map.get('x') > 0) {
            int sixes = map.get('x');
            map.put('s', map.get('s') - sixes);
            map.put('i', map.get('i') - sixes);
            map.put('x', 0);

            resultMap.put(6, sixes);
        }

        // 解決8的部分
        if(map.containsKey('g') && map.get('g') > 0) {
            int eights = map.get('g');
            map.put('e', map.get('e') - eights);
            map.put('i', map.get('i') - eights);
            map.put('g', 0);
            map.put('h', map.get('h') - eights);
            map.put('t', map.get('t') - eights);

            resultMap.put(8, eights);
        }

        /************************************
         * 刪除完第一重特徵後，即可進行第二重特徵的解析
         * 解決第二重特徵 1->o, 3->t, 5->f, 7->s
         */
        // 解決1的部分
        if(map.containsKey('o') && map.get('o') > 0) {
            int ones = map.get('o');
            map.put('o', 0);
            map.put('n', map.get('n') - ones);
            map.put('e', map.get('e') - ones);

            resultMap.put(1, ones);
        }

        // 解決3部分
        if(map.containsKey('t') && map.get('t') > 0) {
            int threes = map.get('t');
            map.put('t', 0);
            map.put('h', map.get('h') - threes);
            map.put('r', map.get('r') - threes);
            map.put('e', map.get('e') - threes);
            map.put('e', map.get('e') - threes);

            resultMap.put(3, threes);
        }

        // 解決5部分
        if(map.containsKey('f') && map.get('f') > 0) {
            int fives = map.get('f');
            map.put('f', 0);
            map.put('i', map.get('i') - fives);
            map.put('v', map.get('v') - fives);
            map.put('e', map.get('e') - fives);

            resultMap.put(5, fives);
        }

        // 解決7部分
        if(map.containsKey('s') && map.get('s') > 0) {
            int sevens = map.get('s');
            map.put('s', 0);
            map.put('e', map.get('e') - sevens);
            map.put('v', map.get('v') - sevens);
            map.put('e', map.get('e') - sevens);
            map.put('n', map.get('n') - sevens);

            resultMap.put(7, sevens);
        }

        /************************************
         * 刪除完第二重特徵後，即可進行第三重特徵的解析
         * 解決第三重特徵 9->i
         */
        // 解決9的部分
        if(map.containsKey('i') && map.get('i') > 0) {
            int nines = map.get('i');
            map.put('n', map.get('n') - nines);
            map.put('i', 0);
            map.put('n', map.get('n') - nines);
            map.put('e', map.get('e') - nines);

            resultMap.put(9, nines);
        }

        // 利用StringBuilder有效提升速度
        StringBuilder result = new StringBuilder();
        for(int i = 0; i <= 9; i ++) {
            if(resultMap.containsKey(i) == true && resultMap.get(i) > 0) {
                for(int j = 0; j < resultMap.get(i); j ++) {
                    result.append(i);
                }
            }
        }

        return result.toString();
    }
}
