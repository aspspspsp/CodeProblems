package src.LeetCode.Algorithms.Medium;

import java.util.List;

public class KeysAndRooms {
/*
�o�D�u�n�Q��key�P�ж������Y�Ӷi����X�A���n�ˬd�C�өж��O�_���Q���}�L(�|�W��)�A�M����X��
���ɡA�b�N�Ҿߨ쪺key�i���L�ж������X(dfs)�A�̫��ˬd�w���X���ж��ƶq�O�_����Ҧ��ж���
�q�A�O�h��^true�A�_�hfalse
*/
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // ���N0�H�~���Ҧ��ж������A�]��false�A��ܨS���Q���X
        boolean[] visited = new boolean[rooms.size()];
        for(int i = 0; i < rooms.size(); i ++)
            visited[i] = false;

        // �i��ж������X
        dfs(rooms, 0, visited);

        // �ˬd���X�L���ж��ƶq
        int visitedRooms = 0;
        for(int i = 0; i < visited.length; i ++) {
            if(visited[i] == true)
                visitedRooms ++;
        }

        // �Y���X�L���ж��P�Ҧ��ж����ƶq�ۦP�A�h��ܩҦ��ж����Q���}
        if(visitedRooms == rooms.size())
            return true;

        // �Ϥ��h���O
        return false;
    }

    void dfs(List<List<Integer>> rooms, int curRoomNo, boolean[] visited) {
        // �]�m�o�өж��w�g�Q���X�L
        visited[curRoomNo] = true;

        // �Q�γo�өж��Ҧ���key�i���L�ж������X
        List<Integer> keys = rooms.get(curRoomNo);
        for(int key : keys) {
            // �Y�o�өж��S�Q���X�L�A�h�}��i�h
            if(visited[key] == false)
                dfs(rooms, key, visited);
        }
    }
}
