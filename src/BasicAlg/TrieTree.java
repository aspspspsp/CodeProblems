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
	        System.out.println(key+" ����: "+ map.get(key)+"��");  
	    }  
	      
	    map=trie.getWordsForPrefix("chin");  
	      
	    System.out.println("\n\n����chin����������ǰ׺�ĵ��ʼ����ִ�����");  
	    for(String key:map.keySet()){  
	        System.out.println(key+" ����: "+ map.get(key)+"��");  
	    }  
	      
	    if(trie.isExist("xiaoming")==false){  
	        System.out.println("\n\n�ֵ����в����ڣ�xiaoming ");  
	    }  
      
      
    }  
	
	public class Node {
		private int dupli_num; //���ִ����ظ���Ŀ��������ͳ���ظ�������ʱ������,ȡֵΪ0��1��2��3��
		
		private int prefix_num; //�Ը��ִ�Ϊǰ׺���ִ����� Ӧ�ð������ִ�����
		private Node childs[]; //�˴�������ʵ�֣���ȻҲ����map��listʵ���Խ�ʡ�ռ�
		private boolean isLeaf; //�Ƿ�Ϊ���ʽڵ�(����һ�����c)
		
		public Node() {
			this.dupli_num = 0;
			this.prefix_num = 0;
			isLeaf = false;
			childs = new Node[26];
		}
	}
	
	private Node root; //���� 
	public TrieTree() {
		root = new Node(); //��ʼ��trie ��  
	}
	
	/** 
     * �����ִ�����ѭ���������ʵ�� 
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
			
			//�������a��ĸ��ֵ��Ϊ�±�������Ҳ��ʽ�ؼ�¼�˸���ĸ��ֵ(index ���� ascii code)
			int index = chars[i] - 'a';
			if(root.childs[index] != null) {
				//�Ѿ������ˣ����ӽڵ�prefix_num++  
				root.childs[index].prefix_num ++;
			} else {
				//��������ڣ��t����һ�����c
				root.childs[index] = new Node();
				root.childs[index].prefix_num ++;
			}
			
			//��������ִ���β���������
			if(i == length - 1) {
				root.childs[index].isLeaf = true;
				root.childs[index].dupli_num ++;
			}
			
			//rootָ���ӽڵ㣬���������� һ��char
			root = root.childs[index];
		}
	}
	
	/** 
     * ����Trie�����������е�words�Լ����ִ��� 
     * @return HashMap<String, Integer> map 
     */  
	public HashMap<String, Integer> getAllWords() {
		return preTraversal(this.root, "");
	}
	
	 /** 
     * ǰ����������� 
     * @param root      �������ڵ� 
     * @param prefixs   ��ѯ���ýڵ�ǰ����������ǰ׺ 
     * @return 
     */  
	public HashMap<String, Integer> preTraversal(Node root, String prefixs) {
		HashMap<String, Integer> map = new HashMap<>();
		
		if(root != null) {
			//��ǰ(root���c)��Ϊһ������ 
			if(root.isLeaf == true) {
				map.put(prefixs, root.dupli_num);
			}
			
			for(int i = 0; i < root.childs.length; i ++) {
			 	if(root.childs[i] != null) {
			 		char _char = (char)(i + 'a');
			 		
			 		String tempStr = prefixs + _char;
			 		
			 		//�ݹ����ǰ�����  
			 		map.putAll(preTraversal(root.childs[i], tempStr));
			 	}
			}
		}
		
		return map;
		
	}
	
	/** 
     * �ж�ĳ�ִ��Ƿ����ֵ����� 
     * @param word 
     * @return true if exists ,otherwise  false  
     */  
	public boolean isExist(String word) {
		return search(this.root, word);
	}
	
	 /** 
     * ��ѯĳ�ִ��Ƿ����ֵ����� 
     * @param word 
     * @return true if exists ,otherwise  false  
     */  
	private boolean search(Node root, String word) {
		char[] chars = word.toLowerCase().toCharArray();
		for(int i = 0; i < chars.length; i ++) {
			int index = chars[i] - 'a';
			if(root.childs[index] == null) {
				//��������ڣ������ʧ��  
				return false;
			}
			//��ָ��ГQ����һ��node���^�m
			root = root.childs[index];
		}
		
		return true;
	}
	
	/** 
     * �õ���ĳ�ִ�Ϊǰ׺���ִ����������ִ����� ���Ƶ������뷨�����빦�� 
     * @param prefix �ִ�ǰ׺ 
     * @return �ִ����Լ����ִ���������������򷵻�null 
     */  
	public HashMap<String, Integer> getWordsForPrefix(String prefix) {
		return getWordsForPrefix(this.root, prefix);
	}
	
	/** 
     * �õ���ĳ�ִ�Ϊǰ׺���ִ����������ִ����� 
     * @param root 
     * @param prefix 
     * @return �ִ����Լ����ִ��� 
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
		
        //���������ǰ׺����  
        //�˴�����֮ǰ��ǰ������������������ 
		return preTraversal(root, prefix);
	}

}
