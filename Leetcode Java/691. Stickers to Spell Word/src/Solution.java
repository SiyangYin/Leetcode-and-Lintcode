import java.util.Arrays;

public class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int[] f = new int[1 << n];
        int[][] g = new int[1 << n][26];
        Arrays.fill(f, -1);
        for (int[] row : g) {
            Arrays.fill(row, -1);
        }
        
        int res = dfs(0, f, g, stickers, target);
        return res == 0x3f3f3f3f ? -1 : res;
    }
    
    private int dfs(int state, int[] f, int[][] g, String[] strs, String target) {
        if (f[state] != -1) {
            return f[state];
        }
        
        if (state == (1 << target.length()) - 1) {
            return f[state] = 0;
        }
        
        int res = 0x3f3f3f3f;
        for (String s : strs) {
            int cur = state;
            for (int i = 0; i < s.length(); i++) {
                cur = fill(cur, s.charAt(i), g, target);
            }
            
            if (cur == state) {
                continue;
            }
            
            res = Math.min(res, dfs(cur, f, g, strs, target) + 1);
        }
        
        return f[state] = res;
    }
    
    private int fill(int state, char ch, int[][] g, String target) {
        if (g[state][ch - 'a'] != -1) {
            return g[state][ch - 'a'];
        }
        
        int cur = state;
        for (int i = 0; i < target.length(); i++) {
            if ((state >> i & 1) == 0 && ch == target.charAt(i)) {
                cur += 1 << i;
                break;
            }
        }
        
        return g[state][ch - 'a'] = cur;
    }
    
    public static void main(String[] args) {
        String[] st = {"with", "example", "science"};
        System.out.println(new Solution().minStickers(st, "thehat"));
    }
}
