package src.LeetCode.Algorithms.Easy;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        // �O���e�i��V���y��       ��V  ����
        int[][] dirs = {{0, 1},  // �F  0
                {1, 0},   // �_  1
                {0, -1},  // ��  2
                {-1, 0}}; // �n  3

        // ��e�y��
        int x = 0; int y = 0;

        // ��e��V
        int now_dir = 0;

        // �O�����G(�̤j�ڦ��Z��)
        int result = 0;

        // �N��ê���HHashSet�O���_�ӡA��K�d��
        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle: obstacles) {
            long o_x = (long)obstacle[0];
            long o_y = (long)obstacle[1];

            // �i��s�X�A�e16�줸�O�O��x�y�СA��16�줸�O�O��y�y��
            obstacleSet.add((o_x << 16) + o_y);
        }

        // ���M�C�ӫ��O
        for(int cmd : commands) {
            // ���O��-2 ���ɰw����90��
            if(cmd == -2)
                now_dir = (now_dir - 1 + 4) % 4;
                // ���O��-1 �f�ɰw����90��
            else if(cmd == -1)
                now_dir = (now_dir + 1) % 4;
                // ��L���O�h�i�沾��
            else {
                for(int k = 0; k < cmd; k ++) {
                    // �U�@�Ӧ�m
                    int new_x = x + dirs[now_dir][0];
                    int new_y = y + dirs[now_dir][1];

                    // �N�U�@�Ӧ�m�i��s�X�A�H�d�߬O�_�����ê��
                    long code = ((long)new_x << 16) + (long)new_y;

                    // �Y�S���e�i�ܻ�ê���A�h�i��U�@�B
                    if (obstacleSet.contains(code) == false) {
                        x = new_x;
                        y = new_y;

                        // ��s�̤j�ڦ��Z��
                        result = Math.max(result, x * x + y * y);
                    }
                }
            }
        }

        // ��^����
        return result;
    }
}
