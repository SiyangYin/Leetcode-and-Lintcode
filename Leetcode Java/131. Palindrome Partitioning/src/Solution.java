import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    isPal[i][j] = true;
                } else {
                    isPal[i][j] = s.charAt(i) == s.charAt(j) && (len == 2 || isPal[i + 1][j - 1]);
                }
            }
        }
        
        dfs(s, 0, new ArrayList<>(), res, isPal);
        
        return res;
    }
    
    private void dfs(String s, int pos, List<String> cur, List<List<String>> res, boolean[][] isPal) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = pos; i < s.length(); i++) {
            if (isPal[pos][i]) {
                cur.add(s.substring(pos, i + 1));
                dfs(s, i + 1, cur, res, isPal);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
    }
}
