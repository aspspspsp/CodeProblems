package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class ImplementTire_PrefixTree {
    //定義Trie節點的數據結構
    class TrieNode {
        private char val;
        private List<TrieNode> children;
        private boolean isFianl;
        
        //建構子
        public TrieNode(char val) {
            children = new ArrayList<>();
            this.val = val;
            this.isFianl = false;
        }
        
        //若不賦值，則此節點則是最末節點
        public TrieNode() {
            isFianl = true;
        }
        
        //返回此節點是否為最末節點
        public boolean getIsFinal() {
            return isFianl;
        }
        
        //返回此節點是否為一個字中的最末節點
        public boolean isFinalChar() {
            for(TrieNode child : children) {
                if(child.getIsFinal() == true)
                    return true;
            }
            
            return false;
        }
        
        //取得此節點的值
        public char getVal() {
            return val;
        }
        
        //增加子節點
        public void addChild(TrieNode node) {
            children.add(node);
        }
        
        //查找子節點是否含有某個字元的子節點，並返回它
        public TrieNode getChild(char c) {
            for(TrieNode child : children) {
                if(child.getIsFinal() == false && child.getVal() == c) {
                    return child;
                }
            }
            
            return null;
        }
        
        //查找子節點是否含有某個字元的子節點
        public boolean hasChild(char c) {
            for(TrieNode child : children) {
                if(child.getVal() == c) {
                    return true;
                }
            }
            
            return false;
        }
    }
    
    /** Initialize your data structure here. */
    private TrieNode root;
    public ImplementTire_PrefieTree() {
        //新增一個Tries樹
        root = new TrieNode('.');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] w_c = word.toCharArray();
        
        //把指針指到root節點
        TrieNode cur = root;
        
        //對這個字符串進行歷遍(逐字符)
        for(char c : w_c) {
            //若這個節點的子節點含有當前字符則將指針移到子節點
            if(cur.hasChild(c) == true) {
                cur = cur.getChild(c);
                
            //否則就新增一個節點，並將指針移到新節點上面
            } else {
                TrieNode t = new TrieNode(c);
                cur.addChild(t);
                cur = t;
            }
        }
        
        //歷遍完字符串後，在當前節點後面新增一個結尾節點
        cur.addChild(new TrieNode());
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        
        char[] w_c = word.toCharArray();
        
        //對這個字符串進行歷遍(逐字符)
        for(char c : w_c) {
            //若這個節點的子節點含有當前字符則將指針移到子節點
            if(cur.hasChild(c) == true) 
                cur = cur.getChild(c);
            //否則返回false(表示沒有這個字)
            else
                return false;
        }
        
        //若最後的節點是字符末，表示這個字是含在Tries樹當中，返回true
        if(cur.isFinalChar() == true)
            return true;
        
        //否則，返回false(只有當前字符的前綴)
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        char[] w_c = prefix.toCharArray();

        for(char c : w_c) {
            //若這個節點的子節點含有當前字符則將指針移到子節點
            if(cur.hasChild(c) == true) 
                cur = cur.getChild(c);
            //否則返回false(表示沒有這個字)
            else
                return false;
        }
        
        //若最後的節點是字符末，表示這個字的前綴是含在Tries樹當中，返回true
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */