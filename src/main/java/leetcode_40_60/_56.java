package leetcode_40_60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * Created by john on 2017/3/6.
 */
public class _56 {

    public static void main(String[] args) {
        _56 demo = new _56();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(0, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(15, 18));
        demo.merge(intervals).forEach(System.out::println);
    }

    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, (e1, e2) -> e1.start - e2.start);

        for (int i = 0; i < intervals.size() - 1;) {
            int end1 = intervals.get(i).end;
            int start1 = intervals.get(i).start;
            int end2 = intervals.get(i + 1).end;
            int start2 = intervals.get(i + 1).start;
            if (end1 >= end2) {
                intervals.remove(i + 1);
            }
            else if (end1 >= start2) {
                int end = end1 > end2 ? end1 : end2;
                Interval ele = new Interval(start1, end);
                intervals.remove(i);
                intervals.remove(i);
                intervals.add(i, ele);
            } else {
                i++;
            }
        }

        return intervals;
    }

    /**
     *
     * @param intervals : the list is initially sorted
     * @param newInterval  : the element to be inserted
     * @return
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        int sign = 1;

        return intervals;
    }

    private void insertInterval(List<Interval> intervals, Interval interval) {
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start > interval.start) {
                intervals.add(i, interval);
            }
        }
    }

     private static class Interval {
         int start;
         int end;

         Interval() {
             start = 0;
             end = 0;
         }

         Interval(int s, int e) {
             start = s;
             end = e;
         }

         @Override
         public String toString() {
             return "[" + start + "," + end + "]";
         }
     }
}
