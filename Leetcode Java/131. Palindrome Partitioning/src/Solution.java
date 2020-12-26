import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        
        if (s == null || s.isEmpty()) {
            return res;
        }
        
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
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
    
        for (int i = pos + 1; i <= s.length(); i++) {
            if (isPal[pos][i - 1]) {
                cur.add(s.substring(pos, i));
                dfs(s, i, cur, res, isPal);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
    }
}
