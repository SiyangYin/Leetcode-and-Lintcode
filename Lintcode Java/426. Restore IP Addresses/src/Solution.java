import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param s: the IP string
     * @return: All possible valid IP addresses
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
    
        dfs(s, 0, new StringBuilder(), 0, res);
    
        return res;
    }
    
    private void dfs(String s, int pos, StringBuilder sb, int cut, List<String> res) {
        if (pos == s.length()) {
            if (cut == 4) {
                res.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        
        for (int i = Math.min(s.length(), pos + 3); i >= pos + 1; i--) {
            if (s.length() - i > (4 - cut) * 3) {
                return;
            }
            
            String cur = s.substring(pos, i);
            if ((!cur.startsWith("0") || cur.equals("0")) && Integer.parseInt(cur) <= 255 && cut < 4) {
                sb.append(cur).append('.');
                dfs(s, i, sb, cut + 1, res);
                sb.setLength(sb.length() - cur.length() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
    }
}
