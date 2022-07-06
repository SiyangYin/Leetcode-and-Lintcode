import java.util.ArrayList;
import java.util.List;

public class Solution {
    int res;
    
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            g[parent[i]].add(i);
        }
        
        dfs(0, g, s);
        return res;
    }
    
    int dfs(int u, List<Integer>[] g, String s) {
        if (g[u].isEmpty()) {
            res = Math.max(res, 1);
            return 1;
        }
        
        int max1 = 0, max2 = 0;
        for (int ne : g[u]) {
            int len = dfs(ne, g, s);
            if (s.charAt(ne) != s.charAt(u)) {
                if (len > max1) {
                    max2 = max1;
                    max1 = len;
                } else if (len > max2) {
                    max2 = len;
                }
            }
        }
        
        res = Math.max(res, max1 + 1 + max2);
        return 1 + max1;
    }
    
    public static void main(String[] args) {
        int[] p = {-1, 0, 0, 0};
        String s = "aabc";
        System.out.println(new Solution().longestPath(p, s));
    }
}
