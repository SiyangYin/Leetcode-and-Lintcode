public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
    
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            res += timeCons(points[i], points[i + 1]);
        }
        return res;
    }
    
    private int timeCons(int[] p1, int[] p2) {
        int dx = Math.abs(p1[0] - p2[0]);
        int dy = Math.abs(p1[1] - p2[1]);
        return Math.max(dx, dy);
    }
}
