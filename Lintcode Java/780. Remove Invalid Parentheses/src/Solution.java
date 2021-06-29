import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        List<String> res = new ArrayList<>();
        // l和r分别是要删多少个左括号和右括号
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l == 0) {
                    r++;
                } else {
                    l--;
                }
            }
        }
        
        // cnt是左括号数减去右括号数
        dfs(0, s, new StringBuilder(), 0, l, r, res);
        return res;
    }
    
    private void dfs(int pos, String s, StringBuilder sb, int cnt, int l, int r, List<String> res) {
        if (pos == s.length()) {
            if (cnt == 0) {
                res.add(sb.toString());
            }
            
            return;
        }
        
        char ch = s.charAt(pos);
        if (ch != '(' && ch != ')') {
            dfs(pos + 1, s, sb.append(ch), cnt, l, r, res);
            sb.setLength(sb.length() - 1);
        } else if (ch == '(') {
            int i = pos;
            while (i < s.length() && s.charAt(i) == '(') {
                i++;
            }
            
            l -= i - pos;
            for (int j = i - pos; j >= 0; j--) {
                if (l >= 0) {
                    dfs(i, s, sb, cnt, l, r, res);
                }
                sb.append('(');
                cnt++;
                l++;
            }
            sb.setLength(sb.length() - (i - pos + 1));
        } else {
            int i = pos;
            while (i < s.length() && s.charAt(i) == ')') {
                i++;
            }
            r -= i - pos;
            for (int j = i - pos; j >= 0; j--) {
                if (cnt >= 0 && r >= 0) {
                    dfs(i, s, sb, cnt, l, r, res);
                }
                sb.append(')');
                cnt--;
                r++;
            }
            sb.setLength(sb.length() - (i - pos + 1));
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeInvalidParentheses("()())()"));
        System.out.println(new Solution().removeInvalidParentheses("(j))("));
    }
}
