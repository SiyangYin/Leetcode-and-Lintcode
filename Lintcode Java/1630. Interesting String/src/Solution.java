import java.util.Arrays;

public class Solution {
    /**
     * @param s: the string s
     * @return: check if the string is interesting
     */
    public String check(String s) {
        // Write your code here
        boolean[] memo = new boolean[s.length()];
        Arrays.fill(memo, true);
        return dfs(0, s, memo) ? "yes" : "no";
    }
    
    private boolean dfs(int pos, String s, boolean[] memo) {
        if (pos == s.length()) {
            return true;
        }
        
        if (pos > s.length()) {
            return false;
        }
        
        if (!Character.isDigit(s.charAt(pos))) {
            return false;
        }
        
        if (!memo[pos]) {
            return false;
        }
        
        for (int i = pos; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int len = Integer.parseInt(s.substring(pos, i + 1)), next = i + len + 1;
                if (dfs(next, s, memo)) {
                    return true;
                }
            } else {
                break;
            }
        }
        
        memo[pos] = false;
        return false;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().check("124gray6hunter"));
        System.out.println(new Solution().check("12grayaaaaaaaa6hunter"));
    }
}
