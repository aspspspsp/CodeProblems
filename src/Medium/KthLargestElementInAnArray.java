package Medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    /*
    PriorityQueue會按照自然法則來排序，頂層的元素則為最大元素
    故只要維護大小為k的PriorityQueue，只要超過k便排出，再取出最上層的元素就是第k大的元素
    Ex: 8 5 6 7 2 3 4, k = 4
    2 3 4 5 6 7 8
    1.queue 8
    2.queue 6 8
    3.queue 5 6 8
    4.queue 5 6 7 8 
    5.queue 4 5 6 7 排出 8
    6.queue 2 4 5 6 排出 7
    7.queue 2 3 4 5 排出 6
    最頂層元素為 5，即為答案
    */
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pQueue = new PriorityQueue<Integer>();
        for(int i = 0; i < nums.length; i ++) {
            pQueue.add(nums[i]);
            if(pQueue.size() > k)
                pQueue.poll();
        }
        
        return pQueue.poll();
    }
}