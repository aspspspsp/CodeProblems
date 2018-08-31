package src.LeetCode.Hard;

import java.util.ArrayList;
import java.util.List;

import LeetCode.Dependencies.Interval;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        if(intervals.isEmpty() == true) {
            result.add(newInterval);
            return result;
        }
        
        int i = 0;
        /*
                *小於newInterval<-|newInterval|(會與newInterval重疊的部分)|->大於newInterval
        */
        while(i < intervals.size() && newInterval.start > intervals.get(i).end) {
            result.add(intervals.get(i));
            i ++;
        }
        
        /*
                 小於newInterval<-|*newInterval|(會與newInterval重疊的部分)|->大於newInterval
        */
        result.add(newInterval);
        
        /*
                 小於newInterval<-|newInterval|*(會與newInterval重疊的部分)|->大於newInterval
                 合併重疊的部分
        */
        while(i < intervals.size() && isOverlap(newInterval, intervals.get(i)) == true) {
            Interval interval = intervals.get(i);
            newInterval.start = Math.min(newInterval.start, interval.start);
            newInterval.end = Math.max(newInterval.end, interval.end);
            i ++;
        }
        
        /*
                  小於newInterval<-|newInterval|(會與newInterval重疊的部分)|->*大於newInterval
                  添加大於newInterval的部分
        */
        while(i < intervals.size()) {
            result.add(intervals.get(i));
            i ++;
        }
        
        return result;
    }
    
    //檢查區間是否重疊
    boolean isOverlap(Interval i1, Interval i2) {
        if(i1.start >= i2.start && i1.start <= i2.end)
            return true;
        if(i2.start >= i1.start && i2.start <= i1.end)
            return true;
        
        return false;
    }
}