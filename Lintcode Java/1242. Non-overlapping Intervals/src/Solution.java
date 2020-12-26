import java.util.List;

public class Solution {
    /**
     * @param intervals: a collection of intervals
     * @return: the minimum number of intervals you need to remove
     */
    public int eraseOverlapIntervals(List<Interval> intervals) {
        // write your code here
        intervals.sort((i1, i2) -> Integer.compare(i1.end, i2.end));
        int count = 0, cur = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (interval.start < cur) {
                continue;
            }
            
            count++;
            cur = interval.end;
        }
        
        return intervals.size() - count;
    }
}

class Interval {
    int start, end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}