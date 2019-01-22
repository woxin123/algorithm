package com.example.leetcode;

import com.example.leetcode.util.Interval;

import java.util.*;

/**
 * 合并区间
 * @auther 孟晨
 * @date 2019/1/22 12:27
 */
public class Merge {
    /**
     * 暴力求解
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> res = new LinkedList<>();
        intervals.sort(Comparator.comparingInt(o -> o.start));
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval1 = res.getLast();
            Interval interval2 = intervals.get(i);
            if (interval1.end >= interval2.start) {
                if (interval1.end >= interval2.end) {
                    continue;
                }
                interval2.start = interval1.start;
                res.removeLast();
                res.add(interval2);
            } else {
                res.add(interval2);
            }
        }
        return res;
    }

    public List<Interval> merge2(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0 || n == 1) {
            return intervals;
        }
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int mark = 0;
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || start[i +  1] > end[i]) {
                res.add(new Interval(start[mark], end[i]));
                mark = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 4));
        list.add(new Interval(0, 2));
        list.add(new Interval(3, 5));
//        list.add(new Interval(15, 18));
        System.out.println(merge.merge2(list));
    }
}
