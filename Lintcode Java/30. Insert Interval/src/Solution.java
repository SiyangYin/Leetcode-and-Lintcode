import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param intervals:   Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        List<Interval> res = new ArrayList<>();
        int start = newInterval.start, end = newInterval.end;
        int l = 0, r = intervals.size() - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (intervals.get(m).start <= start) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        if (intervals.get(l).start > start) {
            res.add(newInterval);
            for (int i = 0; i < intervals.size(); i++) {
                merge(res, res.get(res.size() - 1), intervals.get(i));
            }
        } else {
            for (int i = 0; i <= l; i++) {
                res.add(intervals.get(i));
            }
            merge(res, res.get(res.size() - 1), newInterval);
            for (int i = l; i < intervals.size(); i++) {
                merge(res, res.get(res.size() - 1), intervals.get(i));
            }
        }
        
        return res;
    }
    
    private void merge(List<Interval> intervals, Interval last, Interval cur) {
        if (last.end < cur.start) {
            intervals.add(cur);
        } else {
            last.end = Math.max(last.end, cur.end);
        }
    }
    
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(5, 9));
        List<Interval> insert = new Solution().insert(intervals, new Interval(2, 5));
        for (Interval interval : insert) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}

class Interval {
    int start, end;
    
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}