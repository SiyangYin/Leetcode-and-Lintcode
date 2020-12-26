import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return res;
        }
        
        intervals.sort(Comparator.comparingInt(i -> i.start));
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            mergeIn(res, res.get(res.size() - 1), intervals.get(i));
        }
        
        return res;
    }
    
    private void mergeIn(List<Interval> res, Interval last, Interval cur) {
        if (last.end < cur.start) {
            res.add(cur);
        } else {
            last.end = Math.max(last.end, cur.end);
        }
    }
    
    public static void main(String[] args) {
        List<Interval> lists = new ArrayList<>();
        lists.add(new Interval(1, 3));
        lists.add(new Interval(2, 6));
        lists.add(new Interval(8, 10));
        lists.add(new Interval(15, 18));
    
        List<Interval> merge = new Solution().merge(lists);
        for (Interval interval : merge) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}

class Interval {
    public int start, end;
    
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}