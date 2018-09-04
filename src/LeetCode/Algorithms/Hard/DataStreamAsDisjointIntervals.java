package src.LeetCode.Algorithms.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import src.LeetCode.Algorithms.Dependencies.Interval;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class DataStreamAsDisjointIntervals {
    private TreeMap<Integer, Interval> tree;
    
    /** Initialize your data structure here. */
    public DataStreamAsDisjointIntervals() {
        tree = new TreeMap<>();
    }
    
    public void addNum(int val) {
        //若含有重複的val 則不動作
        if(tree.containsKey(val))
            return;
        
        Integer higherKey = tree.higherKey(val); //找到在這棵樹中比自己大的最小key，若沒有則返回null
        Integer lowerKey = tree.lowerKey(val); //找到在這棵樹中比自己小的最大key，若沒有則返回null
        
        Interval higherInterval = null;
        if(higherKey != null)
            higherInterval = tree.get(higherKey);
        
        Interval lowerInterval = null;
        if(lowerKey != null)
            lowerInterval = tree.get(lowerKey);
        
        if(lowerKey != null && higherKey != null && lowerInterval.end + 1 == val && higherKey == val + 1) {
            lowerInterval.end = higherInterval.end;
            tree.remove(higherKey);
        } else if(lowerKey != null && lowerInterval.end + 1 >= val) {
            lowerInterval.end = Math.max(lowerInterval.end, val);
        } else if(higherKey != null && higherKey == val + 1) {
            Interval newInterval = new Interval(val, higherInterval.end);
            tree.put(val, newInterval);
            tree.remove(higherKey);
        //離區間太遠，則新增一個區間
        } else {
            Interval newInterval = new Interval(val, val);
            tree.put(val, newInterval);
        }
    }
    
    public List<Interval> getIntervals() {
        List<Interval> list = new ArrayList<>();
        
        for(Interval interval : tree.values()) {
            list.add(interval);
        }
        
        return list;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */