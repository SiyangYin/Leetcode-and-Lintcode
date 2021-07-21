public class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int x = q[0], y = q[1], r = q[2], cnt = 0;
            for (int[] p : points) {
                int dx = p[0] - x, dy = p[1] - y;
                if (dx * dx + dy * dy <= r * r) {
                    cnt++;
                }
            }
            
            res[i] = cnt;
        }
        
        return res;
    }
}
