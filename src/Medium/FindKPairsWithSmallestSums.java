package Medium;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKPairsWithSmallestSums {
	//nums1 = [row, row] nums2 = [column, column]
	final int [][] neighbor = {
		{0, 1}, //column加1
		{1, 0} //row加1
	};
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		ArrayList<int[]> result = new ArrayList<int[]>();

		//若兩個數組其中一個為空，或是指定的k值為零則跳出
		if(nums1 == null || nums1.length == 0 || nums2.length == 0 || nums2 == null || k == 0) {
			return result;
		}
		
		//新增一個最小堆(利用優先隊列)
		Queue<Pair> minQueue = new PriorityQueue<Pair>();
		
		//紀錄拜訪過的點
		boolean [][] visited = new boolean[nums1.length][nums2.length];
		
		//因為是以數組是以生序排序，故最前面的數字一定是最小的，總和也是最小的
		visited[0][0] = true;
		minQueue.offer(new Pair(0, 0, nums1[0] + nums2[0]));
		
		int i = k;
		while(i > 0 && !minQueue.isEmpty()) {
			i --;
			//將加總最小的組合排出(以最小堆性質)
			Pair min = minQueue.poll();
			
			//放入結果當中
			result.add(new int[] {nums1[min.row], nums2[min.column]});
			
			//逐一拜訪最小的組合鄰近的數字組合
			for(int j = 0; j < neighbor.length; j ++) {
				int row = min.row + neighbor[j][0];
				int column = min.column + neighbor[j][1];
				
				//若到陣列邊界外或是此點已經拜訪過則略過
				if(row >= nums1.length || column >= nums2.length || i < 0 || visited[row][column] == true) 
					continue;
				
				//將拜訪過的點放入最小堆
				minQueue.offer(new Pair(row, column, nums1[row] + nums2[column]));
				visited[row][column] = true;
			}
				
		}
		return result;
	}
}

class Pair implements Comparable<Pair> {
	int row; // 行
	int column; //列
	int value; //值
	
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
