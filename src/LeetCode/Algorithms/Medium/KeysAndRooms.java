package src.LeetCode.Algorithms.Medium;

import java.util.List;

public class KeysAndRooms {
/*
這題只要利用key與房間的關係來進行拜訪，不要檢查每個房間是否都被打開過(會超時)，然後拜訪房
間時，在將所撿到的key進行其他房間的拜訪(dfs)，最後檢查已拜訪的房間數量是否等於所有房間數
量，是則返回true，否則false
*/
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 先將0以外的所有房間的狀態設為false，表示沒有被拜訪
        boolean[] visited = new boolean[rooms.size()];
        for(int i = 0; i < rooms.size(); i ++)
            visited[i] = false;

        // 進行房間的走訪
        dfs(rooms, 0, visited);

        // 檢查拜訪過的房間數量
        int visitedRooms = 0;
        for(int i = 0; i < visited.length; i ++) {
            if(visited[i] == true)
                visitedRooms ++;
        }

        // 若拜訪過的房間與所有房間的數量相同，則表示所有房間都被打開
        if(visitedRooms == rooms.size())
            return true;

        // 反之則不是
        return false;
    }

    void dfs(List<List<Integer>> rooms, int curRoomNo, boolean[] visited) {
        // 設置這個房間已經被拜訪過
        visited[curRoomNo] = true;

        // 利用這個房間所有的key進行其他房間的拜訪
        List<Integer> keys = rooms.get(curRoomNo);
        for(int key : keys) {
            // 若這個房間沒被拜訪過，則開鎖進去
            if(visited[key] == false)
                dfs(rooms, key, visited);
        }
    }
}
