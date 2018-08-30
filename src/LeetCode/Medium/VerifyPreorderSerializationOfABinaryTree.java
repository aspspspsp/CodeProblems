package src.LeetCode.Medium;
/*
0 	   _9_
1     /   \
2    3     2
3   / \   / \
4  4   1  #  6
5 / \ / \   / \
6 # # # #   # #

��̖  0  1  2  3  4  5  6  7  8  9  10 11 12
����"9, 3, 4, #, #, 1, #, #, 2, #, 6, #, #"
 * 
 *  ���Y�c(root-0)��9(��0��Ԫ��)
 *  ���Ә�(root-1) (��1��Ԫ��)
 *  ���Ә�(root-1) (��8(8(���Ә�Ԫ�؂���))��Ԫ��)
 *  �����Դ����
 * 
 */
public class VerifyPreorderSerializationOfABinaryTree {
	
	public static void main(String [] args) {
		VerifyPreorderSerializationOfABinaryTree s = new VerifyPreorderSerializationOfABinaryTree();
		s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
	}
	
	public boolean isValidSerialization(String preorder) {
		//�з�ÿ��Ԫ��
		String [] preOrders = preorder.split(",");
		
		//�ĵ�0��Ԫ���_ʼ���L������K���صĴ𰸞鱾�������Ԫ�ص��L�ȣ��˘��Ϸ�
		if(findTree(preOrders, 0) == preOrders.length)
			return true;
		//��֮���Ϸ�
		else
			return false;
	}
	
	//preOrder���з�������� start��ĵڎׂ�Ԫ���_ʼ���L
	int findTree(String[] preOrders, int start) {
				
		//��Ŀǰ�ѽ����L����ĩ�˵��s����"#"���t��ʾ���Ә䲻�Ϸ�(���^�m�z������e)
		if(preOrders.length - start == 0)
			//-1��ʾ���Ә䲻�Ϸ����������^�m�z����
			return -1;
		
		//��Ŀǰ���L��Ԫ��(preOrder[start])��"#"����ʾ�ѽ������ӵ��~�ӹ��c
		if(preOrders[start].equals("#"))
			//�t��ʾ�Θ�����һλ
			return start + 1;
		
		//�z������������Ŀǰ(start)��1��Ԫ�ؿ�ʼ���𵽵�x��Ԫ�أ�
		int left = findTree(preOrders, start + 1);
		//�����������Ә�(���Ә��L�� == 0)
		if(left < 0)
			//-1��ʾ���Ә䲻�Ϸ����������^�m�z����
			return -1;
		
		//�z�����������ӵ�x + 1��Ԫ����������ĩβ��
		int right = findTree(preOrders, left);
		//�����������Ә�(���Ә��L�� == 0)
		if(right < 0)
			//-1��ʾ���Ә䲻�Ϸ����������^�m�z����
			return -1;
		//����һ�����Ә�Ĺ��c��̖(��ʾĿǰ��ֹ�@�Ø䶼�ǺϷ���)
		return right;
	}
}
