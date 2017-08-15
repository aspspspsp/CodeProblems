package LeetCode.Medium;

import java.util.LinkedList;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        
        int[] result = new int[numCourses];
        
        //若沒有預修課程的列表時，則直接返回所有課程
        if(len == 0) {
            for(int i = 0; i < numCourses; i ++) {
                result[i] = i;
            }
            
            return result;
        }
        
        //記錄所有每個課程的需要預修的課程總數
        int[] pCounter = new int[numCourses];
        for(int i = 0; i < len; i ++) {
            pCounter[prerequisites[i][0]] ++;
        }
        
        //存儲沒不需要預修課程就可以上的課程
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++) {
            if(pCounter[i] == 0) {
                queue.add(i);
            }
        }
        
        int numNoPre = queue.size(); //並不需要預修課程就可以上的課程數量
        
        int counter = 0;
        while(queue.isEmpty() == false) {
            int c = queue.remove();
            result[counter] = c;
            counter ++;
            
            for(int i = 0; i < len; i ++) {
                if(prerequisites[i][1] == c) {
                    pCounter[prerequisites[i][0]] --;
                    if(pCounter[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                        numNoPre ++;
                    }
                }
            }
        }
        
        //返回結果
        if(numNoPre == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
