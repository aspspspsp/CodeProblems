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
		// ��ֻ��ݔ��һ����(n = 1)�t�]�����^����С�߶�Ԫ��
		if (n == 1) {
			List<Integer> result = new ArrayList<Integer>();
			result.add(0);
			return result;
		}

		// �Ƚ���һ���P����й��c�����ӱ�
		List[] adjacencyList = new List[n];
		for (int i = 0; i < n; i++) {
			adjacencyList[i] = new ArrayList<Integer>();
		}
		
		// �������е�߅�팢���ӱ�����
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

		// ��������ܵ�root���c��rootList
		List<Integer> highest1List = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {

			// �߶�(size)��t��root���c
			if (adjacencyList[i].size() == 1) {
				highest1List.add(i);
			}
		}

		while (n > 2) {
			n = n - highest1List.size();
			
			//��С�߶ȹ��c�б�
			List<Integer> minimumHighList = new ArrayList<Integer>();

			// ��ootList�e����L���е��c
			for (Integer i : highest1List) {

				// �cj���ci������һ�������c(i->j)
				int j = (int) adjacencyList[i].iterator().next();
				// ���cj���ci��·���h��(i-j)
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
