package LeetCode.Hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
    /**
     * http://blog.csdn.net/doc_sgl/article/details/11805519
     * 
     * 这道题关键是要连续上升的形状，还有注意len的计算位置
     * */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int max_area = 0;
        int currentHeight;
        int lastIndex;
        int len;
        for(int i = 0; i < heights.length; i ++){
            currentHeight = heights[i];
            //保持升序
            if(stack.isEmpty() || heights[stack.peek()] <= currentHeight){
                stack.push(i);
                continue;
            }
            
            //到了这里，就是不满足升序，需要弹出，注意当前len的判断方式
            while(stack.isEmpty() == false && heights[stack.peek()] > currentHeight){
                lastIndex = stack.pop();
                if(stack.isEmpty() == true) {
                    len = i;
                } else {
                    len = i - stack.peek() - 1;
                }
                
                if(stack.isEmpty() == true) {
                    len = i;
                } else {
                    len = i - stack.peek() - 1;
                }
                
                max_area=Math.max(max_area, len * heights[lastIndex]);
            }
            stack.push(i);
        }
        
        //最后需要多处理一次
        while(stack.isEmpty()==false){
            lastIndex = stack.pop();
            if(stack.isEmpty() == true) {
                len = heights.length;
            } else {
                len = heights.length - stack.peek() - 1;
            }
            
            max_area = Math.max(max_area, len * heights[lastIndex]);
        }
        return max_area;

    }
}