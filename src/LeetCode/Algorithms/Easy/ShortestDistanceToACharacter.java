package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        char[] c = S.toCharArray();

        // �����C�Ӧr�ŻPC�������̵u�Z��
        int[] r = new int[c.length];

        // ���r�Ŧꤤ�Ҧ���C�A�ðO���L�̪���m�A�Y���O�Ӧ�m���OC�ɡA�h�O�����L���j
        List<Integer> c_pos = new ArrayList<>();
        for(int i = 0; i < c.length; i ++) {
            if(c[i] == C) {
                r[i] = 0;
                c_pos.add(i);
            } else
                r[i] = Integer.MAX_VALUE;
        }

        // ���M�C�Ӧr��
        int cur_c_pos = 0;
        for(int i = 0; i < r.length; i ++) {
            // �Y��e�r�Ť���C
            if(r[i] == Integer.MAX_VALUE) {
                // �q2��C�������̵u�Z��(��eC��m�H�ΤW�@��C��m)
                if(cur_c_pos < c_pos.size()) {
                    int tmp = Math.abs(i - c_pos.get(cur_c_pos));
                    r[i] = Math.min(r[i], tmp);
                }

                if(cur_c_pos - 1 >= 0) {
                    int tmp = Math.abs(i - c_pos.get(cur_c_pos - 1));
                    r[i] = Math.min(r[i], tmp);
                }

            // �Y��C�A�h���ʫ��w(�w��s�x�Ҧ�C��m�}�C�����w)
            } else if(r[i] == 0) {
                cur_c_pos ++;
            }
        }

        return r;
    }
}
