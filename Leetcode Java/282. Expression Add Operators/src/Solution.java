import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(0, num, 0, 0, target, new StringBuilder(), res);
        return res;
    }
    
    private void dfs(int cur, String s, long last, long val, long target, StringBuilder sb, List<String> res) {
        if (cur == s.length()) {
            if (val == target) {
                res.add(sb.toString());
            }
            
            return;
        }
        
        long n = 0;
        for (int i = cur; i < s.length(); i++) {
            if (i > cur && s.charAt(cur) == '0') {
                break;
            }
            
            n = n * 10 + s.charAt(i) - '0';
            int len = i - cur + 1;
            
            if (cur == 0) {
                sb.append(n);
                dfs(i + 1, s, n, n, target, sb, res);
                sb.setLength(0);
            } else {
                sb.append('+').append(n);
                dfs(i + 1, s, n, val + n, target, sb, res);
                sb.setLength(sb.length() - (len + 1));
                
                sb.append('-').append(n);
                dfs(i + 1, s, -n, val - n, target, sb, res);
                sb.setLength(sb.length() - (len + 1));
                
                sb.append('*').append(n);
                dfs(i + 1, s, last * n, val - last + last * n, target, sb, res);
                sb.setLength(sb.length() - (len + 1));
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().addOperators("00", 0));
        System.out.println(new Solution().addOperators("105", 5));
    }
}
