import java.util.Arrays;
import java.util.Objects;

public class Solution {
    
    class Slope {
        // n / m
        int n, m;
        
        public Slope(int x, int y) {
            if (y == 0) {
                n = Integer.MAX_VALUE;
                return;
            }
            
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
            if (y == 0) {
                return Math.abs(x);
            }
            
            while (y != 0) {
                int tmp = y;
                y = x % y;
                x = tmp;
            }
            
            return x;
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
    
    public boolean checkStraightLine(int[][] coordinates) {
        Slope slope = null;
        for (int i = 1; i < coordinates.length; i++) {
            if (Arrays.equals(coordinates[0], coordinates[i])) {
                continue;
            }
            
            Slope curSlope = new Slope(coordinates[i][1] - coordinates[0][1], coordinates[i][0] - coordinates[0][0]);
            if (slope == null) {
                slope = curSlope;
            } else if (!slope.equals(curSlope)) {
                return false;
            }
        }
    
        return slope != null;
    }
}
