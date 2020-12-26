import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0, ll = 0, rr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l == r) {
                    rr++;
                } else {
                    r++;
                }
            }
        }
        ll = l - r;
        
        List<String> res = new ArrayList<>();
        dfs(0, s, new StringBuilder(), 0, ll, rr, res);
        return res;
    }
    
    private void dfs(int pos, String s, StringBuilder sb, int diff, int l, int r, List<String> res) {
        if (pos == s.length()) {
            if (diff == 0 && l == 0 && r == 0) {
                res.add(sb.toString());
            }
            return;
        }
        
        if (s.charAt(pos) != '(' && s.charAt(pos) != ')') {
            sb.append(s.charAt(pos));
            dfs(pos + 1, s, sb, diff, l, r, res);
            sb.setLength(sb.length() - 1);
        }
        
        if (s.charAt(pos) == '(') {
            int j = pos;
            while (j < s.length() && s.charAt(j) == '(') {
                j++;
            }
            
            for (int i = 0; i <= Math.min(l, j - pos); i++) {
                sb.append("(".repeat(j - pos - i));
                dfs(j, s, sb, diff + (j - pos - i), l - i, r, res);
                sb.setLength(sb.length() - (j - pos - i));
            }
        } else if (s.charAt(pos) == ')') {
            int j = pos;
            while (j < s.length() && s.charAt(j) == ')') {
                j++;
            }
            
            for (int i = 0; i <= Math.min(r, j - pos); i++) {
                if (diff - (j - pos - i) >= 0) {
                    sb.append(")".repeat(j - pos - i));
                    dfs(j, s, sb, diff - (j - pos - i), l, r - i, res);
                    sb.setLength(sb.length() - (j - pos - i));
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeInvalidParentheses(")("));
        List<String> list = new Solution().removeInvalidParentheses(")(");
        System.out.println(list.size());
        System.out.println(new Solution().removeInvalidParentheses("()())()"));
        System.out.println(new Solution().removeInvalidParentheses("(a)())()"));
    }
}
