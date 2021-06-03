import java.util.Arrays;

public class Solution2 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        int res = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int cur = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (cur == -1 || dist[cur] > dist[j])) {
                    cur = j;
                }
            }
            
            if (i != 0) {
                res += dist[cur];
            }
            
            used[cur] = true;
            
            for (int j = 0; j < n; j++) {
                if (!used[j]) {
                    dist[j] = Math.min(dist[j], Math.abs(points[cur][0] - points[j][0]) + Math.abs(points[cur][1] - points[j][1]));
                }
            }
        }
        
        return res;
    }
}
