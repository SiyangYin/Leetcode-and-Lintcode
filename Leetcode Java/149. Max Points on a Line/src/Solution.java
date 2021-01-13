import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    
    class Slope {
        // 斜率是n / m
        int n, m;
        
        public Slope(int x, int y) {
            n = x;
            m = y;
            
            int gcd = gcd(n, m);
            n /= gcd;
            m /= gcd;
            if (n == 0) {
                m = Math.abs(m);
            } else if (n < 0) {
                n = -n;
                m = -m;
            }
        }
        
        private int gcd(int x, int y) {
            while (y != 0) {
                int tmp = y;
                y = x % y;
                x = tmp;
            }
            
            return Math.abs(x);
        }
        
        @Override
        public boolean equals(Object o) {
            Slope slope = (Slope) o;
            return n == slope.n && m == slope.m;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(n, m);
        }
    }
    
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        int res = 0;
        Map<Slope, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            if (i > 0 && Arrays.equals(points[i], points[i - 1])) {
                continue;
            }
            
            int dup = 0, vert = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (Arrays.equals(points[i], points[j])) {
                    dup++;
                } else if (points[j][0] == points[i][0]) {
                    vert++;
                } else {
                    Slope slope = new Slope(points[j][1] - points[i][1], points[j][0] - points[i][0]);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            
            res = Math.max(res, dup + 1 + vert);
            for (Map.Entry<Slope, Integer> entry : map.entrySet()) {
                res = Math.max(res, dup + 1 + entry.getValue());
            }
            
            map.clear();
        }
        
        return res;
    }
}
