package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;

/*
递归（Recursive）构造法
优先将数字乘10；如果数字末位＜9，考虑将数字加1
递归式类似于二叉树的先根遍历
*/

public class LexicographicalNumbers {
    int _n;
    List<Integer> result;
    public List<Integer> lexicalOrder(int n) {
        result = new ArrayList<Integer>();
        _n = n;
        
        //從1開始
        slove(1);
        return result;
    }
    
    void slove(int m) {
        //放入結果
        result.add(m);
        
        //优先将数字乘10，再進行歷遍
        if(m * 10 <= _n) {
            slove(m * 10);
        }
        
        //如果数字末位<9，考虑将数字加1
        //(m % 10取得末尾數字)
        if(m < _n && m % 10 < 9) {
            slove(m + 1);
        }
    }
}