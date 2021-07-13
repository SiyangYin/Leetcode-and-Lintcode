import java.util.Arrays;

public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        
        int[] f = new int[1 << maxChoosableInteger];
        Arrays.fill(f, -1);
        return dfs(0, 0, f, maxChoosableInteger, desiredTotal);
    }
    
    private boolean dfs(int state, int sum, int[] f, int max, int target) {
        if (f[state] != -1) {
            return f[state] == 1;
        }
        
        if (sum >= target) {
            f[state] = 0;
            return false;
        }
        
        for (int i = 1; i <= max; i++) {
            if ((state >> i - 1 & 1) == 0 && !dfs(state | (1 << i - 1), sum + i, f, max, target)) {
                f[state] = 1;
                return true;
            }
        }
        
        f[state] = 0;
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canIWin(10, 11));
    }
}
