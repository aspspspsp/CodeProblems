package LeetCode.Medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    /*
      利用PriorityQueue(優先隊列)來實現在數組中找到第k大的元素
   在优先队列中，元素被赋予优先级，通常是由小到大。当访问元素时，具有最高优先级的元素最先删除。
   优先队列具有最高级先出 （first in, largest out）的行为特征。
   
    下面就是本代碼運行的過程:
    Ex: 8 5 6 7 2 3 4, k = 4
    2 3 4 5 6 7 8
    1.queue 8
    2.queue 6 8
    3.queue 5 6 8
    4.queue 5 6 7 8 
    5.queue 4 5 6 7 排出 8(維護一個長度固定為4的數組])
    6.queue 2 4 5 6 排出 7
    7.queue 2 3 4 5 排出 6
    而到最終一步，最後一個元素為5，則答案為5
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