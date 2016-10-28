package Medium;
/*
0 	   _9_
1     /   \
2    3     2
3   / \   / \
4  4   1  #  6
5 / \ / \   / \
6 # # # #   # #

編號  0  1  2  3  4  5  6  7  8  9  10 11 12
內容"9, 3, 4, #, #, 1, #, #, 2, #, 6, #, #"
 * 
 *  根結點(root-0)為9(第0個元素)
 *  左子樹(root-1) (第1個元素)
 *  右子樹(root-1) (第8(8(左子樹元素個數))個元素)
 *  其他以此類推
 * 
 */
public class VerifyPreorderSerializationOfABinaryTree {
	
	public static void main(String [] args) {
		VerifyPreorderSerializationOfABinaryTree s = new VerifyPreorderSerializationOfABinaryTree();
		s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
	}
	
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
	
	//preOrder為切分後的序列 start為從第幾個元素開始拜訪
	int findTree(String[] preOrders, int start) {
				
		//若目前已經拜訪到最末端但卻不是"#"，則表示此子樹不合法(再繼續檢查會報錯)
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
