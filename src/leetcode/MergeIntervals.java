package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ZhengHy on 2017-02-07.
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * <p>
 * 思路：
 * 先将虽有间隔按照起始点排序，然后把第一个间隔作为比较元，与后一个比较
 * - 如果后一个的起始点大于比较元的终止点，则将前一个间隔保存起来，以当前的下一个间隔作为比较元，这里是分割；
 * - 如果后一个的起始点小于比较元的终止点，把比较元的终止点的值设成后一个的终止点，这里是合并；
 */
public class MergeIntervals {
    public class Interval {
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
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });

        List<Interval> ret = new ArrayList<>();
        Interval prev = null;
        for(Interval interval : intervals){
            if(prev == null || prev.end < interval.start){
                ret.add(interval);
                prev = interval;
            }else if (interval.end>prev.end) {
                prev.end = interval.end;
            }
        }
        return ret;
    }

    public static void main(String[] args){

    }
}
