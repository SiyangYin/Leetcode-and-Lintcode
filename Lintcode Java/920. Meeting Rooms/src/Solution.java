import java.util.List;

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // write your code here
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        int len = intervals.size();
        for (int i = 0; i < len - 1; i++) {
            if (intervals.get(i).end > intervals.get(i + 1).start) {
                return false;
            }
        }
        
        return true;
    }
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}