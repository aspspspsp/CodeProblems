package LeetCode.Medium;
/* ex:
 *������
 *������
 *������
 *������
 *������
 *������
 *���� ��
 *���� ����
 *����������
 * 
 * ���ӱ�:
 * 1   2   3   4   5   6   7
 * --------------------------
 * 2   1   2   3   4   4   4
 *     2   4   5
 *             6
 *             7
 *             
 * 1.���ҳ��߶Ȟ�1�Ĺ��c 1 5 6 7
 * 2.�ĸ߶Ȟ�1�Ĺ��c��(1 5 6 7)���c֮�B�ӵ��c�hȥ�Լ�
 * 3.��root
 *�h��������ӱ�:
 * 1   2   3   4   5   6   7
 * --------------------------
 * 2   1   2   3   4   4   4
 *     *   4   *
 * �ó��Ĺ��c�� 2 4(result)
 *             
*/

import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		//若只有輸入一個數(n = 1)則沒有所謂的最小高度元素
		if (n == 1) {
			List<Integer> result = new ArrayList<Integer>();
			result.add(0);
			return result;
		}

		//先建立一個關於所有節點的鄰接表
		List[] adjacencyList = new List[n];
		for (int i = 0; i < n; i++) {
			adjacencyList[i] = new ArrayList<Integer>();
		}
		
		//根據所有的邊來將鄰接表填入
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

		//先填入可能的root節點至rootList
		List<Integer> highest1List = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {

			//高度(size)為則為root節點
			if (adjacencyList[i].size() == 1) {
				highest1List.add(i);
			}
		}

		while (n > 2) {
			n = n - highest1List.size();
			
			//��С�߶ȹ��c�б�
			List<Integer> minimumHighList = new ArrayList<Integer>();

			//從ootList裡面拜訪所有的點
			for (Integer i : highest1List) {

				//點j為點i的最後一個鄰接點(i->j)
				int j = (int) adjacencyList[i].iterator().next();
				//將點j到點i的路徑刪除(i-j)
				adjacencyList[j].remove(i);
				
				//��h�����c����ĸ߶Ȟ�1,�t������С�߶ȹ��c�б�
				if (adjacencyList[j].size() == 1) {
					minimumHighList.add(j);
				}
			}
			highest1List = minimumHighList;
		}
		return highest1List;
	}
}
