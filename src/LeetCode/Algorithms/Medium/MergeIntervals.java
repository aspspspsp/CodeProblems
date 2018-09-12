package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import src.LeetCode.Algorithms.Dependencies.Interval;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * 这道和之前那道 Insert Interval 插入区间 很类似，这次题目要
 * 求我们合并区间，之前那题明确了输入区间集是有序的，而这题没有
 * ，所有我们首先要做的就是给区间集排序，由于我们要排序的是个结
 * 构体，所以我们要定义自己的comparator，才能用sort来排序，我
 * 们以start的值从小到大来排序，排完序我们就可以开始合并了，首
 * 先把第一个区间存入结果中，然后从第二个开始遍历区间集，如果结
 * 果中最后一个区间和遍历的当前区间无重叠，直接将当前区间存入结
 * 果中，如果有重叠，将结果中最后一个区间的end值更新为结果中最后
 * 一个区间的end和当前end值之中的较大值，然后继续遍历区间集，以
 * 此类推可以得到最终结果
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0)
            return result;
        
        //先對intervals排序(先按start再按end)
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if(i1.start != i2.start) {
                    return i1.start - i2.start;
                } else {
                    return i1.end - i2.end;
                }
            }
        });
        
        //再依序加入各個intervals
        /*
        因為已經排過序了只會有三種情況:
        1.  ======
            ====
        2.  ====
            ======
        3.  ======
             ====
        4.  ======
            ======
        5.  ===
               ====
        */
        Interval pre = intervals.get(0);
        for(int i = 0; i < intervals.size(); i ++) {
            Interval cur = intervals.get(i);
            if(cur.start > pre.end) { //情況5
                result.add(pre);
                pre = cur;
            } else { //情況 1,2,3,4
                Interval merged = new Interval(pre.start, Math.max(pre.end, cur.end));
                pre = merged;
            }
        }
        
        result.add(pre);
        
        return result;
    }
}