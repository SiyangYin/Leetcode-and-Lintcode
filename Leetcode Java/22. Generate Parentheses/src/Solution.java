import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), res);
        
        return res;
    }
    
    private void dfs(int n, int l, int r, StringBuilder sb, List<String> res) {
        if (l + r == 2 * n) {
            res.add(sb.toString());
            return;
        }
        
        if (l < n) {
            dfs(n, l + 1, r, sb.append('('), res);
            sb.setLength(sb.length() - 1);
        }
        
        if (r < l) {
            dfs(n, l, r + 1, sb.append(')'), res);
            sb.setLength(sb.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
