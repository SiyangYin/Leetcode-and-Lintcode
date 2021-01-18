public class Solution {
    public boolean isBoomerang(int[][] points) {
        int[] x = new int[2], y = new int[2];
        for (int i = 1; i < points.length; i++) {
            x[i - 1] = points[i][0] - points[0][0];
            y[i - 1] = points[i][1] - points[0][1];
        }
        
        return x[0] * y[1] != x[1] * y[0];
    }
}
