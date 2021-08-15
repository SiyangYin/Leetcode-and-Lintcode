import java.util.Arrays;

public class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[] tmp = new int[m + 2];
        for (int i = 0; i < m; i++) {
            tmp[i + 1] = cuts[i];
        }
        tmp[m + 1] = n;
        cuts = tmp;
        
        int[][] f = new int[m + 2][m + 2];
        for (int[] row : f) {
            Arrays.fill(row, -1);
        }
        
        return dfs(0, m + 1, cuts, f);
    }
    
    int dfs(int l, int r, int[] cuts, int[][] f) {
        if (f[l][r] != -1) {
            return f[l][r];
        }
        
        if (r == l + 1) {
            return f[l][r] = 0;
        }
        
        f[l][r] = cuts[r] - cuts[l];
        int min = 0x3f3f3f3f;
        for (int i = l + 1; i < r; i++) {
            min = Math.min(min, dfs(l, i, cuts, f) + dfs(i, r, cuts, f));
        }
        
        f[l][r] += min;
        return f[l][r];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minCost(7, new int[]{1, 3, 4, 5}));
        // System.out.println(new Solution().minCost(9, new int[]{5, 6, 1, 4, 2}));
    }
}
