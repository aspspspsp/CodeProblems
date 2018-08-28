package LeetCode.Medium;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import LeetCode.Dependencies.NestedInteger;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
    Stack<Integer> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<Integer>();
        contructStack(nestedList);
    }
    
    void contructStack(List<NestedInteger> nestedList) {
        // 從結尾至開頭
        for(int i = nestedList.size() - 1; i >= 0; i --) {
            LeetCode.Dependencies.NestedInteger cur = nestedList.get(i);
            if(cur.isInteger() == false) {
                contructStack(cur.getList());
            } else {
                int num = cur.getInteger();
                stack.push(num);
            }
        }
    }
    

    @Override
    public Integer next() {
        if(this.hasNext() == true) {
            return stack.pop();
        }
        
        return null;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
