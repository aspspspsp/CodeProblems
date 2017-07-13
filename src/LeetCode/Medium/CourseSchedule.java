package LeetCode.Medium;
/*
先修课问题本质上是一个有向图
如果这个图无环:我们可以根据拓扑排序遍历到所有节点
如果这个图有环:则拓扑排序无法完成，遍历到的节点将少于总节点数，因为有的节点是孤岛。

步驟:
1.先根据边的关系，建一个图，并计算每个节点的入度，这里用的是数组来建图。
2.从入度为0的节点，也就是入口开始广度优先搜索，按照拓扑排序的顺序遍历
3.看遍历过的节点数和总节点数的关系就行了。
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	//欲修課程(prerequisites[i][0])
    //欲修課程的先修課程(prerequisites[i][1])
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	//圖
        ArrayList[] graph = new ArrayList[numCourses];
        //入度指有向图中某点作为图中边的终点的次数之和。
        //(將某點作為終點的次數之和)
        //入度數組
        int[] inDegrees = new int[numCourses];
        
        //先初始化圖，每個賦予空列表
        for(int i = 0; i < numCourses; i ++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        //根據邊建立圖，並計算每個欲修課程的入度
        for(int i = 0; i < prerequisites.length; i ++) {
            //將欲修課程的先修課程與欲修課程連接起來
            //[0,1]要上0必須先上1，故1->0
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            
            //計算每個欲修課程的入度
            //因為:1->0，故
            //0入度: 1(作為終點)
            //1入度: 0
            inDegrees[prerequisites[i][0]] ++;
        }
        
      //找到有向圖的入口(會有很多入口)，而圖中的每個點對(pair)不一定相連
        Queue<Integer> entrances = new LinkedList<Integer>();
        for(int i = 0; i < inDegrees.length; i ++) {
        	//入度为0指有向图中的点不作为任何边的终点，
            //也就是说，这一点所连接的边都把这一点作为起点。
            if(inDegrees[i] == 0) {
                entrances.add(i);
            }
        }
        
        //拓樸排序方法:
        /*
        1.从 DAG 图中选择一个 没有前驱（即入度为0）的顶点并输出。
        2.从图中删除该顶点和所有以它为起点的有向边。
        3.重复 1. 和 2. 直到当前的 DAG 图为空或当前图中不存在无前驱的顶点为止。
        后一种情况说明有向图中必然存在环。
        
        * 根据上面讲的方法，我们关键是要维护一个入度为0的顶点的集合。
        */
        
        //按照拓扑排序的顺序，进行广度优先搜索
        int counter = 0;
        while(entrances.isEmpty() == false) {
            //从 DAG 图中选择一个 没有前驱（即入度为0）的顶点
            Integer cur = entrances.poll();
            counter ++;
            
            //从图中删除该顶点和所有以它为起点的有向边。
            ArrayList<Integer> nexts = graph[cur];
            for(int i = 0; i < nexts.size(); i ++) {
                // 将所有cur指向的所有顶点的入度减1
                int next = nexts.get(i);
                inDegrees[next] --;
                
                // 并将入度减为0的顶点入栈
                //(因為要確保圖中不存在无前驱的顶点，故將該點入棧進行下一次的歷遍)
                if(inDegrees[next] == 0) {
                    entrances.offer(next);
                }
            }
        }
        
        // 没有输出全部顶点，有向图中有回路
        if(numCourses > counter) {
            return false;
            
        // 拓扑排序成功
        } else {
            return true;
        }
    }
}