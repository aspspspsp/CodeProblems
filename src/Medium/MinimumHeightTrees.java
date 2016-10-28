package Medium;
/* ex:
 *　　１
 *　　｜
 *　　２
 *　　｜
 *　　３
 *　　｜
 *　　 ４
 *　／ ｜＼
 *５　６　７
 * 
 * 鄰接表:
 * 1   2   3   4   5   6   7
 * --------------------------
 * 2   1   2   3   4   4   4
 *     2   4   5
 *             6
 *             7
 *             
 * 1.先找出高度為1的節點 1 5 6 7
 * 2.從高度為1的節點中(1 5 6 7)將與之連接的點刪去自己
 * 3.在root
 *刪除後的鄰接表:
 * 1   2   3   4   5   6   7
 * --------------------------
 * 2   1   2   3   4   4   4
 *     *   4   *
 * 得出的節點是 2 4(result)
 *             
*/

import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		// 若只有輸入一個數(n = 1)則沒有所謂的最小高度元素
		if (n == 1) {
			List<Integer> result = new ArrayList<Integer>();
			result.add(0);
			return result;
		}

		// 先建立一個關於所有節點的鄰接表
		List[] adjacencyList = new List[n];
		for (int i = 0; i < n; i++) {
			adjacencyList[i] = new ArrayList<Integer>();
		}
		
		// 根據所有的邊來將鄰接表填入
		for (int[] edge : edges) {

			// n0 -> n1
			int node_from = edge[0];
			int node_to = edge[1];

			adjacencyList[node_from].add(node_to);

			// n1 -> n0
			node_from = edge[1];
			node_to = edge[0];
			adjacencyList[node_from].add(node_to);
		}

		// 先填入可能的root節點至rootList
		List<Integer> highest1List = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {

			// 高度(size)為則為root節點
			if (adjacencyList[i].size() == 1) {
				highest1List.add(i);
			}
		}

		while (n > 2) {
			n = n - highest1List.size();
			
			//最小高度節點列表
			List<Integer> minimumHighList = new ArrayList<Integer>();

			// 從ootList裡面拜訪所有的點
			for (Integer i : highest1List) {

				// 點j為點i的最後一個鄰接點(i->j)
				int j = (int) adjacencyList[i].iterator().next();
				// 將點j到點i的路徑刪除(i-j)
				adjacencyList[j].remove(i);
				
				//若刪除此點的後的高度為1,則加入最小高度節點列表
				if (adjacencyList[j].size() == 1) {
					minimumHighList.add(j);
				}
			}
			highest1List = minimumHighList;
		}
		return highest1List;
	}
}
