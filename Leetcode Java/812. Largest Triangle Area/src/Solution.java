public class Solution {
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        int n = points.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int x1 = points[i][0], y1 = points[i][1];
                    int x2 = points[j][0], y2 = points[j][1];
                    int x3 = points[k][0], y3 = points[k][1];
                    double S = 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1));
                    res = Math.max(res, S);
                }
            }
        }
        
        return res;
    }
}
