package LeetCode.Medium;
/**
 * 
 * @author zihanxu
题解：声明一个visited，用于记录遍历过的结点。
每次dfs找到一个原矩阵为1的位置（除了对角线），
就把这个位置的列数变成行数再dfs，如果是在同一
个圈里，最终会绕回已经遍历过的行，visited为true
，return 0；如果不是同一个圈，则增加1。
（M[i][j]==1这个判断相当于i的邻接点，深度优先遍历）
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        
        int n = M.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        //如果dfs大於0，說明有未歷遍的節點
        //只需要歷遍所有節點
        for(int i = 0; i < n; i ++) {
            if(dfs(M, i, visited) > 0) {
                count ++;
            }
        }
        
        return count;
    }
    
    int dfs(int[][] M, int i, boolean[] visited) {
        if(visited[i] == true) {
            return 0;
        }
        
        visited[i] = true;
        int count = 1;
        for(int j = 0; j < visited.length; j ++) {
            if(i != j && M[i][j] == 1) {
                count += dfs(M, j, visited);
            }
        }
        
        return count;
    }
}