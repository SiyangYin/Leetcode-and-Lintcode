import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));
        
        int res = 0;
        long curEnd = Long.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > curEnd) {
                res++;
                curEnd = points[i][1];
            }
        }
        
        return res;
    }
}
