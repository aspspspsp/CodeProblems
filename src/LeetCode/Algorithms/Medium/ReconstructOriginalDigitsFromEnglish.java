package src.LeetCode.Algorithms.Medium;

import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        char[] cs = s.toCharArray();

        // �إߦr����
        Map<Character, Integer> map = new HashMap<>();
        for(char c : cs) {
            if(map.containsKey(c) == false)
                map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }

        // �ΥH�s�x�Ʀr���ƶq�A�H��K��X����
        Map<Integer, Integer> resultMap = new HashMap<>();
        /************************************
         * �ѨM�Ĥ@���S�x 0->z, 2->w, 4->u, 6->x, 8->g
         */
        // �ѨM0������
        if(map.containsKey('z') && map.get('z') > 0) {
            int zeros = map.get('z');
            map.put('z', 0);
            map.put('e', map.get('e') - zeros);
            map.put('r', map.get('r') - zeros);
            map.put('o', map.get('o') - zeros);

            resultMap.put(0, zeros);
        }

        // �ѨM2������
        if(map.containsKey('w') && map.get('w') > 0) {
            int twos = map.get('w');
            map.put('t', map.get('t') - twos);
            map.put('w', 0);
            map.put('o', map.get('o') - twos);

            resultMap.put(2, twos);
        }

        // �ѨM4������
        if(map.containsKey('u') && map.get('u') > 0) {
            int fours = map.get('u');
            map.put('f', map.get('f') - fours);
            map.put('o', map.get('o') - fours);
            map.put('u', 0);
            map.put('r', map.get('r') - fours);

            resultMap.put(4, fours);
        }

        // �ѨM6������
        if(map.containsKey('x') && map.get('x') > 0) {
            int sixes = map.get('x');
            map.put('s', map.get('s') - sixes);
            map.put('i', map.get('i') - sixes);
            map.put('x', 0);

            resultMap.put(6, sixes);
        }

        // �ѨM8������
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
         * �R�����Ĥ@���S�x��A�Y�i�i��ĤG���S�x���ѪR
         * �ѨM�ĤG���S�x 1->o, 3->t, 5->f, 7->s
         */
        // �ѨM1������
        if(map.containsKey('o') && map.get('o') > 0) {
            int ones = map.get('o');
            map.put('o', 0);
            map.put('n', map.get('n') - ones);
            map.put('e', map.get('e') - ones);

            resultMap.put(1, ones);
        }

        // �ѨM3����
        if(map.containsKey('t') && map.get('t') > 0) {
            int threes = map.get('t');
            map.put('t', 0);
            map.put('h', map.get('h') - threes);
            map.put('r', map.get('r') - threes);
            map.put('e', map.get('e') - threes);
            map.put('e', map.get('e') - threes);

            resultMap.put(3, threes);
        }

        // �ѨM5����
        if(map.containsKey('f') && map.get('f') > 0) {
            int fives = map.get('f');
            map.put('f', 0);
            map.put('i', map.get('i') - fives);
            map.put('v', map.get('v') - fives);
            map.put('e', map.get('e') - fives);

            resultMap.put(5, fives);
        }

        // �ѨM7����
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
         * �R�����ĤG���S�x��A�Y�i�i��ĤT���S�x���ѪR
         * �ѨM�ĤT���S�x 9->i
         */
        // �ѨM9������
        if(map.containsKey('i') && map.get('i') > 0) {
            int nines = map.get('i');
            map.put('n', map.get('n') - nines);
            map.put('i', 0);
            map.put('n', map.get('n') - nines);
            map.put('e', map.get('e') - nines);

            resultMap.put(9, nines);
        }

        // �Q��StringBuilder���Ĵ��ɳt��
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
