import java.util.Arrays;

class Solution {
    public int maxStudents(char[][] s) {
        int m = s.length, n = s[0].length;
        int[] seats = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i][j] == '.') {
                    seats[i] += 1 << n - 1 - j;
                }
            }
        }
        
        boolean[] canSit = new boolean[1 << n];
        Arrays.fill(canSit, true);
        for (int i = 0; i < 1 << n; i++) {
            int j = i;
            while (j > 0) {
                if ((j & 3) == 3) {
                    canSit[i] = false;
                    break;
                }
                
                j >>= 1;
            }
        }
        
        int[][] f = new int[m + 1][1 << n];
        for (int i = 1; i <= m; i++) {
            for (int now = 0; now < 1 << n; now++) {
                if (!canSit[now]) {
                    continue;
                }
                
                if ((now | seats[i - 1]) != seats[i - 1]) {
                    continue;
                }
    
                for (int prev = 0; prev < 1 << n; prev++) {
                    if (!canSit[prev]) {
                        continue;
                    }
                
                    if (i >= 2 && (prev | seats[i - 2]) != seats[i - 2]) {
                        continue;
                    }
                    
                    if ((prev << 1 & now) != 0 || (prev >> 1 & now) != 0) {
                        continue;
                    }
                    
                    f[i][now] = Math.max(f[i][now], f[i - 1][prev] + Integer.bitCount(now));
                }
            }
        }
        
        int res = 0;
        for (int x = 0; x < 1 << n; x++) {
            if (canSit[x]) {
                res = Math.max(res, f[m][x]);
            }
        }
        
        return res;
    }
}