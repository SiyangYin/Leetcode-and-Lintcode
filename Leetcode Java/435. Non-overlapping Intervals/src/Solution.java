import java.util.Arrays;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[1] != i2[1] ? Integer.compare(i1[1], i2[1]) : Integer.compare(i1[0], i2[0]));
        int count = 0, curEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= curEnd) {
                curEnd = interval[1];
                count++;
            }
        }
        
        return intervals.length - count;
    }
}
