import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param word: the given word
     * @return: the generalized abbreviations of a word
     */
    public List<String> generateAbbreviations(String word) {
        // Write your code here
        List<String> res = new ArrayList<>();
        dfs(0, new StringBuilder(), word, res);
        return res;
    }
    
    private void dfs(int pos, StringBuilder sb, String s, List<String> res) {
        if (pos == s.length()) {
            res.add(sb.toString());
            return;
        }
        
        for (int i = 0; i <= s.length() - pos; i++) {
            if (i == 0) {
                sb.append(s.charAt(pos));
                dfs(pos + 1, sb, s, res);
                sb.setLength(sb.length() - 1);
            } else {
                if (sb.length() > 0 && Character.isDigit(sb.charAt(sb.length() - 1))) {
                    return;
                }
                
                sb.append(i);
                dfs(pos + i, sb, s, res);
                sb.setLength(sb.length() - String.valueOf(i).length());
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().generateAbbreviations("word"));
    }
}
