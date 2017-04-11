package BasicAlg;

import Dependencies.ListNode;

public class MinHeap {
	/* 1 2 3 4 5 6 
	 * ----------------
	 * 0 2 1 5 3 4
	 * 
	 *          0(1)
	 *         / \
	 *     (2)1   2(3)
	 *       / \  /
	 *      3   45 (6)
	 *     (4) (5)
	 */     
	public static void main(String[] args) {
		MinHeap heap = new MinHeap(15);
		for(int i = 5; i >= 0; i --) {
			heap.put(new ListNode(i));
		}
		
		for(int i = 1; i <= heap.count; i ++) {
			System.err.print(heap.h[i].val + ",");
		}
		System.err.println("");
		while(heap.count > 0) {
			ListNode node = heap.top();
			System.err.print(node.val + ",");
		}
	}
	
	
	ListNode[] h;
	int count = 0;
	public MinHeap(int size) {
		this.h = new ListNode[size + 1];
	}
	
	public ListNode top() {
		if(count == 0)
			return null;
		
		ListNode node = this.h[1];
		this.h[1] = this.h[count];
		
		count --;
		siftDown(1);
		return node;
	}
	
	private void siftDown(int k) {
		int left = k * 2;
		int right = left + 1;
		
		if(left > this.count)
			return;
		
		//找出兩個兒子中最小的
		int smallest;
		if(right > this.count) {
			smallest = left;
		} else {
			if(h[left].val > h[right].val)
				smallest = right;
			else
				smallest = left;
		}
		
		//若兒子節點比父節點小則兒子往上浮，再進入下一個節點
		if(this.h[k].val > this.h[smallest].val) {
			swap(k, smallest);
			siftDown(smallest);
		}
	}
	
	public void put(ListNode node) {
		if(node == null)
			return;
		this.count ++;
		this.h[count] = node;
		siftUp(this.count);
	}
	
	private void siftUp(int k) {
		if(k < 2)
			return;
		
		int parent = k / 2;
		
		if(this.h[parent].val > this.h[k].val) {
			swap(parent, k);
			siftUp(parent);
		}
	}
	
	private void swap(int index1, int index2) {
		ListNode temp = this.h[index1];
		this.h[index1] = this.h[index2];
		this.h[index2] = temp;
	}
}
