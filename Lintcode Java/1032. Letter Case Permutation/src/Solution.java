import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param S: a string
     * @return: return a list of strings
     */
    public List<String> letterCasePermutation(String S) {
        // write your code here
        List<String> res = new ArrayList<>();
        
        dfs(S, 0, new StringBuilder(), res);
        return res;
    }
    
    private void dfs(String s, int pos, StringBuilder sb, List<String> res) {
        if (pos == s.length()) {
            res.add(sb.toString());
            return;
        }
        
        if (!Character.isLetter(s.charAt(pos))) {
            sb.append(s.charAt(pos));
            dfs(s, pos + 1, sb, res);
            sb.setLength(sb.length() - 1);
        } else {
            sb.append(Character.toLowerCase(s.charAt(pos)));
            dfs(s, pos + 1, sb, res);
            sb.setLength(sb.length() - 1);
            
            sb.append(Character.toUpperCase(s.charAt(pos)));
            dfs(s, pos + 1, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b"));
    }
}
