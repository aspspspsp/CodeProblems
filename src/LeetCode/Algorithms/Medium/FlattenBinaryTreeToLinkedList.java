package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
將之前拜訪的點接到最右邊
ex:
    1       1. 拜訪到6，將6的右邊設置為pervVisted(空)，左邊設置為空，pervVisted = 6
   / \      2. 拜訪到5，將5的右邊設置為pervVisted(6)，左邊設置為空，pervVisted = 5 //把 6 接到 5 的右邊
  2   5     3. 拜訪到4，將4的右邊設置為pervVisted(5)，左邊設置為空，pervVisted = 4 //把 5 接到 4 的右邊
 / \   \    4. 拜訪到3，將3的右邊設置為pervVisted(4)，左邊設置為空，pervVisted = 3 //把 4 接到 3 的右邊
3   4   6   5. 拜訪到2，將2的右邊設置為pervVisted(3)，左邊設置為空，pervVisted = 2 //把 3 接到 2 的右邊
            6. 拜訪到1，將1的右邊設置為pervVisted(2)，左邊設置為空，pervVisted = 1 //把 2 接到 1 的右邊
            7. 拜訪到null，退出
 */
public class FlattenBinaryTreeToLinkedList {
    //紀錄上一個拜訪的點
    TreeNode pervVisited;
    
    public void flatten(TreeNode root) {
    	helper(root);
    }
    
    void helper(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	
    	//先遞歸至最後(先拜訪右，在拜訪左)，自底向上的做
    	helper(root.right);
    	helper(root.left);
    	
        //把上一個拜訪的點接到目前節點的右邊
    	root.right = pervVisited;
        //把左節點設為空
    	root.left = null;
        
        //這個節點已經拜訪過了，記錄下來，讓上一層也重覆上面的過程
    	pervVisited = root;
    }
}