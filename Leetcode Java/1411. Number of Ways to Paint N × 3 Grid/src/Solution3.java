import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public int numOfWays(int n) {
        int MOD = (int) (1e9 + 7);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i == j || j == k) {
                        continue;
                    }
                    
                    list.add(i * 100 + j * 10 + k);
                }
            }
        }
        
        boolean[][] valid = new boolean[list.size()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            valid[i][i] = false;
            for (int j = i + 1; j < list.size(); j++) {
                valid[i][j] = valid[j][i] = check(list.get(i), list.get(j));
            }
        }
        
        int[][] f = new int[2][list.size()];
        Arrays.fill(f[0], 1);
        for (int i = 1; i < n; i++) {
            Arrays.fill(f[i & 1], 0);
            for (int cur = 0; cur < list.size(); cur++) {
                for (int prev = 0; prev < list.size(); prev++) {
                    if (valid[prev][cur]) {
                        f[i & 1][cur] = (f[i & 1][cur] + f[i - 1 & 1][prev]) % MOD;
                    }
                }
            }
        }
        
        int res = 0;
        for (int x : f[n - 1 & 1]) {
            res = (res + x) % MOD;
        }
        
        return res;
    }
    
    private boolean check(int x, int y) {
        for (int i = 0; i < 3; i++) {
            if (x % 10 == y % 10) {
                return false;
            }
            x /= 10;
            y /= 10;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numOfWays(5000));
    }
}
