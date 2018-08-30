package src.LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
/*
這題可以用鄰接表來建立所有課程的修課圖。鄰接表為下面結構:
課程1:預修課程0,預修課程1,預修課程2...
課程2:預修課程3,預修課程4,預修課程5...
然後歷遍這個圖，若歷遍到重複的點則為無法修得所有課程(不能有環)。
下面我們則會簡介我們的解題過程:
歷遍給定的課程及預修課程對，建立鄰接表
拜訪課程圖中的所有課程，對該課程的預修課程進行dfs，若該點已經拜訪過則返回false
若完整拜訪所有點並不重複時，說明這些課程都是可以完整修得，則返回true
*/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //用來儲存存放課程的圖
    	Map<Integer, List<Integer>> courseGraph = new HashMap<>();
    	
    	//歷遍所有課程的邊，並建立圖
        for(int[] edge : prerequisites) {
            int index = edge[0]; //課程編號
            int pre = edge[1]; //要修習該課程必須要先修的課程
            
            //若圖中不包含該課程，則建立一個
            if(courseGraph.containsKey(index) == false) {
                List<Integer> edges = new ArrayList<>();
                //添加該課程的邊
                edges.add(pre);
                courseGraph.put(index, edges);
            
            //若圖中有包含該課程，則將該預修課程添加至該課程的邊
            } else {
                List<Integer> edges = courseGraph.get(index);
                edges.add(pre);
                courseGraph.put(index, edges);
            }
        }
        
        //對所有課程進行dfs
        for(int i = 0; i < courseGraph.size(); i ++) {
        	//紀錄圖的拜訪情況，true已拜訪，false未拜訪
            boolean[] visited = new boolean[numCourses];
            
            //若出現有重複拜訪的課程(有環)，則返回false
            if(dfs(courseGraph, i, visited) == false)
                return false;
        }
        
        //若歷遍完整個課程圖，則返回true
        return true;
    }
    
    boolean dfs(Map<Integer, List<Integer>> courseGraph, int course, boolean[] visited) {
        //若已經拜訪過了，表示拜訪的重複的點(有環)
    	if(visited[course] == true)
            return false;
        
        //標記為已拜訪
        visited[course] = true;
        
        //歷遍該課程所有的邊，然後再進行dfs
        if(courseGraph.containsKey(course) == true) {
            List<Integer> edges = courseGraph.get(course);
            for(int i = 0; i < edges.size(); i ++) {
               if(dfs(courseGraph, edges.get(i), visited) == false)
                   return false;
            }
        }
        
        //dfs都要將狀態回復
        visited[course] = false;
        
        //若都拜訪完都不出現重複，則返回true
        return true;
    }
}