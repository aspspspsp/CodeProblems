package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Dependencies.Interval;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
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