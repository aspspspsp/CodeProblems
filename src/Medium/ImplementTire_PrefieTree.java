package Medium;

import java.util.HashMap;

//自訂的class
public class ImplementTire_PrefieTree {
	
	class TireNode {
	    char stored_char;
	    //紀錄在這個節點下的所有子節點
	    HashMap<Character, TireNode> children = new HashMap<>();
	    
	    boolean has_word; //紀錄是否為尾節點(成為一個字)
	    
	    //給root用的
	    public TireNode() {}
	    
	    //給一般節點用的
	    public TireNode(char stored_char)
	    {
	        this.stored_char = stored_char;
	    }
	}
	
	public class Trie {
	    //紀錄根結點
	    TireNode root;
	    /** Initialize your data structure here. */
	    public Trie() {
	        //初始化根結點
	        root = new TireNode();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        TireNode cur_node = root; //插入字串都先由根結點開始拜訪
	        HashMap<Character, TireNode> cur_children = root.children;  //存取目前節點的子節點
	        
	        //開始對要插入的文字逐字元拜訪
	        char[] word_array = word.toCharArray();
	        for(int i = 0; i < word_array.length; i ++) {
	            char cur_char = word_array[i];
	            if(cur_children.containsKey(cur_char)) {
	                cur_node = cur_children.get(cur_char); //若子節點有包含目前的字元時，則移到該節點
	            } else {
	                //新增一個節點
	                TireNode new_node = new TireNode(cur_char);
	                cur_children.put(cur_char, new_node);
	                cur_node = new_node;//切換到新節點
	            }
	            //統一切換目前子節點
	            cur_children = cur_node.children;
	            
	            //判斷是否為尾節點(成為一個字)
	            if(i == word_array.length - 1) {
	                cur_node.has_word = true;
	            }
	        }
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        TireNode finalTireNode = searchWordNodePos(word);
	        if(finalTireNode == null)
	            return false;
	        else {
	            if(finalTireNode.has_word == true)
	                return true;
	            else
	                return false;
	        }
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    //找到此字典樹是否有包含這個prefix
	    public boolean startsWith(String prefix) {
	        TireNode finalTireNode = searchWordNodePos(prefix);
	        if(finalTireNode == null)
	            return false;
	        else 
	            return true;
	    }
	    
	    //自訂的方法
	    TireNode searchWordNodePos(String word) {
	        //從root開始尋找字符串
	        TireNode cur_node = root;
	        HashMap<Character, TireNode> cur_children = root.children;
	        
	        //開始對要搜索的文字逐字元拜訪
	        char[] word_array = word.toCharArray();
	        for(int i = 0; i < word_array.length; i ++) {
	            char cur_char = word_array[i];
	            if(cur_children.containsKey(cur_char)) {
	                cur_node = cur_children.get(cur_char); //若子節點有包含目前的字元時，則移到該節點
	                cur_children = cur_node.children;
	            } else {
	                //若該字元搜索不到時則返回null
	                return null;
	            }
	        }
	        
	        //返回答案
	        return cur_node;
	    }
	}
	
	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
}