import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        List<Character>[][] g = (List<Character>[][]) new ArrayList[7][7];
        for (String s : allowed) {
            int x1 = s.charAt(0) - 'A', x2 = s.charAt(1) - 'A';
            if (g[x1][x2] == null) {
                g[x1][x2] = new ArrayList<>();
            }
            
            g[x1][x2].add(s.charAt(2));
        }
        
        return dfs(bottom, "", 0, g);
    }
    
    private boolean dfs(String cur, String up, int pos, List<Character>[][] g) {
        if (cur.length() == 1) {
            return true;
        }
        
        if (pos == cur.length() - 1) {
            return dfs(up, "", 0, g);
        }
        
        int x1 = cur.charAt(pos) - 'A', x2 = cur.charAt(pos + 1) - 'A';
        if (g[x1][x2] != null) {
            for (char next : g[x1][x2]) {
                if (dfs(cur, up + next, pos + 1, g)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().pyramidTransition("AABA", Arrays.asList("AAA", "AAB", "ABA", "ABB", "BAC")));
    }
}
