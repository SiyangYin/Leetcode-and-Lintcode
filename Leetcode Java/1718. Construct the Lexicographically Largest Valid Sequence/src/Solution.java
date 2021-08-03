import java.util.Arrays;

public class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        dfs(0, n, new boolean[n + 1], res);
        return res;
    }
    
    private boolean dfs(int u, int n, boolean[] used, int[] res) {
        if (u == 2 * n - 1) {
            return true;
        }
        
        if (res[u] != 0) {
            return dfs(u + 1, n, used, res);
        }
        
        for (int i = n; i > 1; i--) {
            if (!used[i] && u + i < 2 * n - 1 && res[u + i] == 0) {
                res[u] = res[u + i] = i;
                used[i] = true;
                if (dfs(u + 1, n, used, res)) {
                    return true;
                }
                
                res[u] = res[u + i] = 0;
                used[i] = false;
            }
        }
        
        if (!used[1]) {
            used[1] = true;
            res[u] = 1;
            if (dfs(u + 1, n, used, res)) {
                return true;
            }
            used[1] = false;
            res[u] = 0;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructDistancedSequence(3)));
        System.out.println(Arrays.toString(new Solution().constructDistancedSequence(5)));
    }
}
