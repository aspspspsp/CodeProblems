package LeetCode.Medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    /*
    PriorityQueue��������Ȼ���t������플ӵ�Ԫ�؄t�����Ԫ��
    ��ֻҪ�S�o��С��k��PriorityQueue��ֻҪ���^k���ų�����ȡ�����όӵ�Ԫ�ؾ��ǵ�k���Ԫ��
    Ex: 8 5 6 7 2 3 4, k = 4
    2 3 4 5 6 7 8
    1.queue 8
    2.queue 6 8
    3.queue 5 6 8
    4.queue 5 6 7 8 
    5.queue 4 5 6 7 �ų� 8
    6.queue 2 4 5 6 �ų� 7
    7.queue 2 3 4 5 �ų� 6
    ��플�Ԫ�؞� 5�������
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