import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        
        dfs(s, 0, new StringBuilder(), 0, res);
        
        return res;
    }
    
    private void dfs(String s, int pos, StringBuilder sb, int cut, List<String> res) {
        if (pos == s.length() && cut == 4) {
            res.add(sb.substring(0, sb.length() - 1));
            return;
        }
    
        for (int i = pos + 1; i <= s.length(); i++) {
            String cur = s.substring(pos, i);
            if ((!cur.startsWith("0") || "0".equals(cur)) && cur.length() <= 3 && Integer.parseInt(cur) <= 255 && cut < 4) {
                sb.append(cur).append('.');
                dfs(s, i, sb, cut + 1, res);
                sb.delete(sb.length() - cur.length() - 1, sb.length());
            } else if (cur.length() > 3) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().restoreIpAddresses("25525511135"));
        System.out.println(new Solution().restoreIpAddresses("1111"));
    }
}
