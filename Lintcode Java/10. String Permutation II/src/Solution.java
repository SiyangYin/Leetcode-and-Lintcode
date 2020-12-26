import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        
        if (str == null || str.isEmpty()) {
            res.add("");
            return res;
        }
        
        char[] s = str.toCharArray();
        Arrays.sort(s);
        
        boolean[] used = new boolean[s.length];
        dfs(s, new StringBuilder(), used, res);
        
        return res;
    }
    
    private void dfs(char[] s, StringBuilder sb, boolean[] used, List<String> res) {
        if (sb.length() == s.length) {
            res.add(sb.toString());
            return;
        }
    
        for (int i = 0; i < s.length; i++) {
            if (used[i] || (i > 0 && s[i] == s[i - 1] && !used[i - 1])) {
                continue;
            }
            
            sb.append(s[i]);
            used[i] = true;
            dfs(s, sb, used, res);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().stringPermutation2("abb"));
        System.out.println(new Solution().stringPermutation2("aaab"));
    }
}
