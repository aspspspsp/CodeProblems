package BasicAlg;

import java.util.HashMap;

public class TrieTree {
	
    public static void main(String args[]) {
	    TrieTree trie = new TrieTree();  
	    trie.insert("I");  
	    trie.insert("Love");  
	    trie.insert("China");  
	    trie.insert("China");  
	    trie.insert("China");  
	    trie.insert("China");  
	    trie.insert("China");  
	    trie.insert("xiaoliang");  
	    trie.insert("xiaoliang");  
	    trie.insert("man");  
	    trie.insert("handsome");  
	    trie.insert("love");  
	    trie.insert("chinaha");  
	    trie.insert("her");  
	    trie.insert("know");  
    
	    HashMap<String, Integer> map = trie.getAllWords();  
      
	    for(String key:map.keySet()){  
	        System.out.println(key+" 出现: "+ map.get(key)+"次");  
	    }  
	      
	    map=trie.getWordsForPrefix("chin");  
	      
	    System.out.println("\n\n包含chin（包括本身）前缀的单词及出现次数：");  
	    for(String key:map.keySet()){  
	        System.out.println(key+" 出现: "+ map.get(key)+"次");  
	    }  
	      
	    if(trie.isExist("xiaoming")==false){  
	        System.out.println("\n\n字典树中不存在：xiaoming ");  
	    }  
      
      
    }  
	
	public class Node {
		private int dupli_num; //该字串的重复数目，该属性统计重复次数的时候有用,取值为0、1、2、3、
		
		private int prefix_num; //以该字串为前缀的字串数， 应该包括该字串本身
		private Node childs[]; //此处用数组实现，当然也可以map或list实现以节省空间
		private boolean isLeaf; //是否为单词节点(最後一個節點)
		
		public Node() {
			this.dupli_num = 0;
			this.prefix_num = 0;
			isLeaf = false;
			childs = new Node[26];
		}
	}
	
	private Node root; //树根 
	public TrieTree() {
		root = new Node(); //初始化trie 树  
	}
	
	/** 
     * 插入字串，用循环代替迭代实现 
     * @param words 
     */  
	public void insert(String words) {
		insert(this.root, words);
	}
	
	private void insert(Node root, String words) {
		words = words.toLowerCase();
		char[] chars = words.toCharArray();
		
		for(int i = 0; i < chars.length; i ++) {
			int length = chars.length;
			
			//用相对于a字母的值作为下标索引，也隐式地记录了该字母的值(index 即為 ascii code)
			int index = chars[i] - 'a';
			if(root.childs[index] != null) {
				//已经存在了，该子节点prefix_num++  
				root.childs[index].prefix_num ++;
			} else {
				//如果不存在，則新增一個節點
				root.childs[index] = new Node();
				root.childs[index].prefix_num ++;
			}
			
			//如果到了字串结尾，则做标记
			if(i == length - 1) {
				root.childs[index].isLeaf = true;
				root.childs[index].dupli_num ++;
			}
			
			//root指向子节点，继续处理下 一個char
			root = root.childs[index];
		}
	}
	
	/** 
     * 遍历Trie树，查找所有的words以及出现次数 
     * @return HashMap<String, Integer> map 
     */  
	public HashMap<String, Integer> getAllWords() {
		return preTraversal(this.root, "");
	}
	
	 /** 
     * 前序遍历。。。 
     * @param root      子树根节点 
     * @param prefixs   查询到该节点前所遍历过的前缀 
     * @return 
     */  
	public HashMap<String, Integer> preTraversal(Node root, String prefixs) {
		HashMap<String, Integer> map = new HashMap<>();
		
		if(root != null) {
			//当前(root節點)即为一个单词 
			if(root.isLeaf == true) {
				map.put(prefixs, root.dupli_num);
			}
			
			for(int i = 0; i < root.childs.length; i ++) {
			 	if(root.childs[i] != null) {
			 		char _char = (char)(i + 'a');
			 		
			 		String tempStr = prefixs + _char;
			 		
			 		//递归调用前序遍历  
			 		map.putAll(preTraversal(root.childs[i], tempStr));
			 	}
			}
		}
		
		return map;
		
	}
	
	/** 
     * 判断某字串是否在字典树中 
     * @param word 
     * @return true if exists ,otherwise  false  
     */  
	public boolean isExist(String word) {
		return search(this.root, word);
	}
	
	 /** 
     * 查询某字串是否在字典树中 
     * @param word 
     * @return true if exists ,otherwise  false  
     */  
	private boolean search(Node root, String word) {
		char[] chars = word.toLowerCase().toCharArray();
		for(int i = 0; i < chars.length; i ++) {
			int index = chars[i] - 'a';
			if(root.childs[index] == null) {
				//如果不存在，则查找失败  
				return false;
			}
			//將指針切換到另一個node以繼續
			root = root.childs[index];
		}
		
		return true;
	}
	
	/** 
     * 得到以某字串为前缀的字串集，包括字串本身！ 类似单词输入法的联想功能 
     * @param prefix 字串前缀 
     * @return 字串集以及出现次数，如果不存在则返回null 
     */  
	public HashMap<String, Integer> getWordsForPrefix(String prefix) {
		return getWordsForPrefix(this.root, prefix);
	}
	
	/** 
     * 得到以某字串为前缀的字串集，包括字串本身！ 
     * @param root 
     * @param prefix 
     * @return 字串集以及出现次数 
     */  
	public HashMap<String, Integer> getWordsForPrefix(Node root, String prefix) {
		char [] chars = prefix.toLowerCase().toCharArray();
		
		for(int i = 0; i < chars.length; i ++) {
			int index = chars[i] - 'a';
			if(root.childs[index] == null) {
				return null;
			}
			
			root = root.childs[index];
		}
		
        //结果包括该前缀本身  
        //此处利用之前的前序搜索方法进行搜索 
		return preTraversal(root, prefix);
	}

}
