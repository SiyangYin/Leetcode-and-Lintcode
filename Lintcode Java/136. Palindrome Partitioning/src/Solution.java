import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        
        boolean[][] isPalin = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i + len - 1 < s.length(); i++) {
                int l = i, r = i + len - 1;
                if (len == 1) {
                    isPalin[l][r] = true;
                } else {
                    isPalin[l][r] = s.charAt(l) == s.charAt(r);
                    if (len > 2) {
                        isPalin[l][r] &= isPalin[l + 1][r - 1];
                    }
                }
            }
        }
        
        List<String> cur = new ArrayList<>();
        dfs(s, isPalin, 0, cur, res);
        
        return res;
    }
    
    private void dfs(String s, boolean[][] isPalin, int pos, List<String> cur, List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = pos; i < s.length(); i++) {
            if (isPalin[pos][i]) {
                cur.add(s.substring(pos, i + 1));
                dfs(s, isPalin, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().partition("aaaa").size());
    }
}
