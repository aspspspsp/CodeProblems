package src.LeetCode.Medium;
/*
檢查一個二叉樹序列化後的字串是否可以被解析成二叉數(前序歷遍)

0 	   _9_
1     /   \
2    3     2
3   / \   / \
4  4   1  #  6
5 / \ / \   / \
6 # # # #   # #

index   0  1  2  3  4  5  6  7  8  9  10 11 12
元素    "9, 3, 4, #, #, 1, #, #, 2, #, 6, #, #"
 * 
 *  ���Y�c(root-0)��9(��0��Ԫ��)
 *  ���Ә�(root-1) (��1��Ԫ��)
 *  ���Ә�(root-1) (��8(8(���Ә�Ԫ�؂���))��Ԫ��)
 *  �����Դ����
 * 
 */
public class VerifyPreorderSerializationOfABinaryTree {
	public boolean isValidSerialization(String preorder) {
		//切分每個元素
		String [] preOrders = preorder.split(",");

		//從第0個元素開始拜訪，若最終返回的答案為本身的所有元素的長度，此樹為合法
		if(findTree(preOrders, 0) == preOrders.length)
			return true;
		//反之不合法
		else
			return false;
	}

	//preOrder為切分後的序列 start為從第幾個元素開始
	int findTree(String[] preOrders, int start) {

		//若目前拜訪的元素序號start超過序列長度，則表示不存在這個子樹(子樹長度為-1)
		if(preOrders.length - start == 0)
			//-1表示此子樹不合法，不必再繼續檢查了
			return -1;

		//若目前拜訪的元素(preOrder[start])為"#"，表示已經到最下層的葉子節點
		if(preOrders[start].equals("#"))
			//則表示游標往右一位
			return start + 1;

		//檢查左子树（从目前(start)第1个元素开始算起到第x个元素）
		int left = findTree(preOrders, start + 1);
		//若不存在左子樹(左子樹長度 == 0)
		if(left < 0)
			//-1表示此子樹不合法，不必再繼續檢查了
			return -1;

		//檢查右子树（从第x + 1个元素算起到序列末尾）
		int right = findTree(preOrders, left);
		//若不存在右子樹(右子樹長度 == 0)
		if(right < 0)
			//-1表示此子樹不合法，不必再繼續檢查了
			return -1;
		//返回一個右子樹的節點編號(表示目前為止這棵樹都是合法的)
		return right;
	}
}
