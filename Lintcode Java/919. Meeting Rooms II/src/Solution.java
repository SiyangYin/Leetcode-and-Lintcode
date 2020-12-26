import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class Pair {
        int time;
        int flag;
    
        public Pair(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
    
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }
    
        List<Pair> list = new ArrayList<>();
        for (Interval interval : intervals) {
            list.add(new Pair(interval.start, 1));
            list.add(new Pair(interval.end, 0));
        }
        
        list.sort((p1, p2) -> p1.time != p2.time ? Integer.compare(p1.time, p2.time) : Integer.compare(p1.flag, p2.flag));
        
        int res = 0, count = 0;
        for (Pair pair : list) {
            if (pair.flag == 1) {
                count++;
            } else {
                count--;
            }
            
            res = Math.max(res, count);
        }
        
        return res;
    }
}

class Interval {
    int start, end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}