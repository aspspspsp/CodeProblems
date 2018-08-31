package src.LeetCode.Algorithms.Medium;

import java.util.Stack;

import src.LeetCode.Algorithms.Dependencies.NestedInteger;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        String tokenNum = "";
        
        char[] chars = s.toCharArray();
        
        //歷遍每個字符
        for(int i = 0; i < chars.length; i ++) {
            switch(chars[i]) {
                //'['代表一個list的開頭
                case '[':
                    stack.push(new NestedInteger());
                    break;
                //']'代表一個list的結尾
                case ']':
                    //若token前面為數字
                    if(tokenNum.equals("") == false) {
                        //則把數字加入到本層的list當中
                        stack.peek().add(new NestedInteger(Integer.parseInt(tokenNum)));
                    }
                    
                    //本層的list結束
                    NestedInteger ni = stack.pop();
                    tokenNum = "";
                    
                    //棧內更高層次的list
                    if(stack.isEmpty() == false) {
                        stack.peek().add(ni);
                    }
                    //棧為空，歷遍到字符串的結尾
                    else {
                        return ni;
                    }
                    break;
                case ',':
                    //將數字加入到本層的list中
                    if(tokenNum.equals("") == false) {
                        stack.peek().add(new NestedInteger(Integer.parseInt(tokenNum)));
                    }
                    tokenNum = "";
                    break;
                default:
                    tokenNum += chars[i];
            }
        }
        
        //特殊case:如果字符串只包含數字的情況
        if(tokenNum.equals("") == false) {
            return new NestedInteger(Integer.parseInt(tokenNum));
        }
        return null;
    }
}
