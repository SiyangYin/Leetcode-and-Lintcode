import java.util.Arrays;

public class Solution {
    /**
     * @param l:      The length of the matrix
     * @param w:      The width of the matrix
     * @param points: three points
     * @return: The sum of the paths sum
     */
    public long calculationTheSumOfPath(int l, int w, Point[] points) {
        // Write your code here
        Arrays.sort(points, (p1, p2) -> p1.x != p2.x ? Integer.compare(p1.x, p2.x) : Integer.compare(p1.y, p2.y));
        Point start = new Point(0, 0), end = new Point(l - 1, w - 1);
        
        long res = 0, MOD = (long) (1E9 + 7);
        for (int i = 0; i < points.length; i++) {
            Point point = points[i];
            point.x--;
            point.y--;
            
            if (i == 0) {
                res = compute(start, point, MOD);
            } else {
                res *= compute(points[i - 1], point, MOD);
            }
            
            res %= MOD;
        }
        
        res *= compute(points[points.length - 1], end, MOD);
        return res % MOD;
    }
    
    private long compute(Point start, Point end, long MOD) {
        int m = end.x - start.x + 1, n = end.y - start.y + 1;
        long[][] dp = new long[2][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i & 1][j] = 1;
                } else {
                    dp[i & 1][j] = dp[i - 1 & 1][j] + dp[i & 1][j - 1];
                }
                
                dp[i & 1][j] %= MOD;
            }
        }
        
        return dp[m - 1 & 1][n - 1];
    }
}

class Point {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}