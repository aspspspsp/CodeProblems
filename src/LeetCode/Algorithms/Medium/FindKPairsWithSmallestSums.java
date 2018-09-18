package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKPairsWithSmallestSums {
	//nums1 = [row, row] nums2 = [column, column]
	final int [][] neighbor = {
		{0, 1}, //column��1
		{1, 0} //row��1
	};
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		ArrayList<int[]> result = new ArrayList<int[]>();

		//��ɂ����M����һ����գ�����ָ����kֵ����t����
		if(nums1 == null || nums1.length == 0 || nums2.length == 0 || nums2 == null || k == 0) {
			return result;
		}
		
		//����һ����С��(���Ã������)
		Queue<Pair> minQueue = new PriorityQueue<Pair>();
		
		//�o䛰��L�^���c
		boolean [][] visited = new boolean[nums1.length][nums2.length];
		
		//������Ԕ��M�����������򣬹���ǰ��Ĕ���һ������С�ģ�����Ҳ����С��
		visited[0][0] = true;
		minQueue.offer(new Pair(0, 0, nums1[0] + nums2[0]));
		
		int i = k;
		while(i > 0 && !minQueue.isEmpty()) {
			i --;
			//���ӿ���С�ĽM���ų�(����С�����|)
			Pair min = minQueue.poll();
			
			//����Y������
			result.add(new int[] {nums1[min.row], nums2[min.column]});
			
			//��һ���L��С�ĽM�������Ĕ��ֽM��
			for(int j = 0; j < neighbor.length; j ++) {
				int row = min.row + neighbor[j][0];
				int column = min.column + neighbor[j][1];
				
				//�������߅������Ǵ��c�ѽ����L�^�t���^
				if(row >= nums1.length || column >= nums2.length || i < 0 || visited[row][column] == true) 
					continue;
				
				//�����L�^���c������С��
				minQueue.offer(new Pair(row, column, nums1[row] + nums2[column]));
				visited[row][column] = true;
			}
				
		}
		return result;
	}

	class Pair implements Comparable<Pair> {
		public int row; //行
		public int column; //列
		public int value; //ֵ值

		public Pair(int row, int column, int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}

		@Override
		public int compareTo(Pair other) {
			return this.value - other.value;
		}
	}
}
