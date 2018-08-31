package src.LeetCode.Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // this section is handle edge cases
        if(nums == null || nums.length == 0 || k == 0) {
            int [] res = {};
            
            return res;
        }
        

        // declare a result array list which can store result of this problem
        ArrayList<Integer> res = new ArrayList<>();
        
        // declare a window queue
        PriorityQueue<Integer> window = new LinkedList<Integer>();
        
        // add k elements of array to window queue
        for(int i = 0; i < k; i ++) {
            window.offer(nums[i]);      
        }
        res.add(findMaxium(window));
        
        for(int i = k; i < nums.length; i ++) {
            // remove the first element
            window.poll();
             // add element to window
            window.offer(nums[i]);
            
            // find the maxium element of window queue
            res.add(findMaxium(window));
        }
        
        // convert array list to array
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i ++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
    
    public int findMaxium(Queue<Integer> window) {
        int max = Integer.MIN_VALUE;
        
        for(Integer num: window) {
            if(max < num) 
                max = num;
        }
        
        return max;
    }
}
