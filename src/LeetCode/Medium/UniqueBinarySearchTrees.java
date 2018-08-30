package src.LeetCode.Medium;
/*
 * 大思想是动态规划。找出递推公式。
 * 思路就是：反正就是BST，每个元素
 * 都做根节点，算出每个元素做根节点
 * 时有几种情况，然后每个节点的几种
 * 情况相加。每个元素有几种情况，根据
 * bst的特性，就是中序便利是排序的。
 * 所以：以n＝3为例。新建一个
 * int res[]= int[3+1]
 * (循环1，2，3，每个数字对应所再index，
 * 而不是1对应0index，2对应1 index...)
 * 1是根节点的时候，1的左子树是0个，右子
 * 树是2，3（两个）。所以是1是根节点的种
 * 类数是：res[0]乘以res[2]情况数。2是
 * 根节点的时候，2的左子树是1（1个），右
 * 子树是1（1个）。所以是2是根节点的种类
 * 数是：res[1]乘以res[1]情况数。3是根
 * 节点的时候，3的左子树是1，2（2个），
 * 右子树是（0个）。所以是2是根节点的种类
 * 数是：res[2]乘以res[0]情况数。
 *
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if(n == 0 || n == 1)
			return 1;

		//result[0]是有0个数的时候
		//result[1]是有1个数的时候
		int[] result = new int[n + 1];

		result[0] = 1;
		for(int i = 1; i <= n; i ++) {
			for(int j = 0; j < i; j ++) {
				result[i] += result[j] * result[i - j - 1];
			}
		}

		return result[n];
	}
}
