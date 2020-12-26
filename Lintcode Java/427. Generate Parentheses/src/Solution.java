import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        // write your code here
        List<String> res = new ArrayList<>();
        
        dfs(new StringBuilder(), 0, 0, n, res);
        return res;
    }
    
    private void dfs(StringBuilder sb, int left, int right, int n, List<String> res) {
        if (left + right == 2 * n) {
            res.add(sb.toString());
            return;
        }
        
        if (left < n) {
            sb.append('(');
            dfs(sb, left + 1, right, n, res);
            sb.setLength(sb.length() - 1);
        }
        
        if (left > right) {
            sb.append(')');
            dfs(sb, left, right + 1, n, res);
            sb.setLength(sb.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
