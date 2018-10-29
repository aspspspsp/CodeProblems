package src.LeetCode.Algorithms.Easy;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 記錄前進方向的座標       方向  順序
        int[][] dirs = {{0, 1},  // 東  0
                {1, 0},   // 北  1
                {0, -1},  // 西  2
                {-1, 0}}; // 南  3

        // 當前座標
        int x = 0; int y = 0;

        // 當前方向
        int now_dir = 0;

        // 記錄結果(最大歐式距離)
        int result = 0;

        // 將障礙物以HashSet記錄起來，方便查找
        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle: obstacles) {
            long o_x = (long)obstacle[0];
            long o_y = (long)obstacle[1];

            // 進行編碼，前16位元是記錄x座標，後16位元是記錄y座標
            obstacleSet.add((o_x << 16) + o_y);
        }

        // 歷遍每個指令
        for(int cmd : commands) {
            // 指令為-2 順時針旋轉90度
            if(cmd == -2)
                now_dir = (now_dir - 1 + 4) % 4;
                // 指令為-1 逆時針旋轉90度
            else if(cmd == -1)
                now_dir = (now_dir + 1) % 4;
                // 其他指令則進行移動
            else {
                for(int k = 0; k < cmd; k ++) {
                    // 下一個位置
                    int new_x = x + dirs[now_dir][0];
                    int new_y = y + dirs[now_dir][1];

                    // 將下一個位置進行編碼，以查詢是否有到障礙物
                    long code = ((long)new_x << 16) + (long)new_y;

                    // 若沒有前進至障礙物，則進行下一步
                    if (obstacleSet.contains(code) == false) {
                        x = new_x;
                        y = new_y;

                        // 更新最大歐式距離
                        result = Math.max(result, x * x + y * y);
                    }
                }
            }
        }

        // 返回答案
        return result;
    }
}
