import java.util.Arrays;

public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (end > interval[0]) {
                return false;
            }
            
            end = interval[1];
        }
        
        
        return true;
    }
}
