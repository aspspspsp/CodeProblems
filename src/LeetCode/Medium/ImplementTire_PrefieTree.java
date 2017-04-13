package LeetCode.Medium;

import java.util.HashMap;

//��ӆ��class
public class ImplementTire_PrefieTree {
	
	class TireNode {
	    char stored_char;
	    //�o����@�����c�µ������ӹ��c
	    HashMap<Character, TireNode> children = new HashMap<>();
	    
	    boolean has_word; //�o��Ƿ��β���c(�ɞ�һ����)
	    
	    //�oroot�õ�
	    public TireNode() {}
	    
	    //�oһ�㹝�c�õ�
	    public TireNode(char stored_char)
	    {
	        this.stored_char = stored_char;
	    }
	}
	
	public class Trie {
	    //�o䛸��Y�c
	    TireNode root;
	    /** Initialize your data structure here. */
	    public Trie() {
	        //��ʼ�����Y�c
	        root = new TireNode();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        TireNode cur_node = root; //�����ִ������ɸ��Y�c�_ʼ���L
	        HashMap<Character, TireNode> cur_children = root.children;  //��ȡĿǰ���c���ӹ��c
	        
	        //�_ʼ��Ҫ�������������Ԫ���L
	        char[] word_array = word.toCharArray();
	        for(int i = 0; i < word_array.length; i ++) {
	            char cur_char = word_array[i];
	            if(cur_children.containsKey(cur_char)) {
	                cur_node = cur_children.get(cur_char); //���ӹ��c�а���Ŀǰ����Ԫ�r���t�Ƶ�ԓ���c
	            } else {
	                //����һ�����c
	                TireNode new_node = new TireNode(cur_char);
	                cur_children.put(cur_char, new_node);
	                cur_node = new_node;//�ГQ���¹��c
	            }
	            //�yһ�ГQĿǰ�ӹ��c
	            cur_children = cur_node.children;
	            
	            //�Д��Ƿ��β���c(�ɞ�һ����)
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
	    //�ҵ����ֵ���Ƿ��а����@��prefix
	    public boolean startsWith(String prefix) {
	        TireNode finalTireNode = searchWordNodePos(prefix);
	        if(finalTireNode == null)
	            return false;
	        else 
	            return true;
	    }
	    
	    //��ӆ�ķ���
	    TireNode searchWordNodePos(String word) {
	        //��root�_ʼ�����ַ���
	        TireNode cur_node = root;
	        HashMap<Character, TireNode> cur_children = root.children;
	        
	        //�_ʼ��Ҫ��������������Ԫ���L
	        char[] word_array = word.toCharArray();
	        for(int i = 0; i < word_array.length; i ++) {
	            char cur_char = word_array[i];
	            if(cur_children.containsKey(cur_char)) {
	                cur_node = cur_children.get(cur_char); //���ӹ��c�а���Ŀǰ����Ԫ�r���t�Ƶ�ԓ���c
	                cur_children = cur_node.children;
	            } else {
	                //��ԓ��Ԫ���������r�t����null
	                return null;
	            }
	        }
	        
	        //���ش�
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