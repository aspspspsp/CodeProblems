package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class AddAndSearchWord_DataStructureDesign {
    //定義Trie節點的數據結構
    class TrieNode {
        private char val;
        public List<TrieNode> children;
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
    public AddAndSearchWord_DataStructureDesign() {
        //新增一個Tries樹
        root = new TrieNode('.');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] c_array = word.toCharArray();
        
        boolean isFinded = isFind(c_array, 0, root);
        
        return isFinded;
    }
    
    /**
    * c_list: 字符串的所有字元
    * pos: 當前拜訪的字符位置
    * cur: 當前拜訪的tries樹的節點
    */
    //利用dfs拜訪tries樹
    boolean isFind(char[] c_array, int pos, TrieNode cur) {
        //若整個字串拜訪完，則檢查這個節點是否有最末節點的子節點
        if(c_array.length == pos) {
            if(cur.getIsFinal() == false && cur.isFinalChar() == true)
                return true;
            
            return false;
        }
        
        //若此節點為最末節點則返回false(後面不會有節點了)
        if(cur.getIsFinal() == true)
            return false;
        
        //標示是否已經找到該字元
        boolean isFind = false;
        
        //表示當前拜訪字元
        char cur_c = c_array[pos];
        
        //若當前字符為'.'，表示為任意字元，故要將所有子節點都拜訪一遍
        if(cur_c == '.') {
            for(TrieNode child : cur.children) {
                if(cur.getIsFinal() == true)
                    continue;
                
                isFind |= isFind(c_array, pos + 1, child);
            }
        //否則只拜訪含有該字元的子節點
        } else {
            if(cur.hasChild(cur_c) == true) {
                isFind |= isFind(c_array, pos + 1, cur.getChild(cur_c));
            } else {
                return false;
            }
        }
        
        return isFind;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
