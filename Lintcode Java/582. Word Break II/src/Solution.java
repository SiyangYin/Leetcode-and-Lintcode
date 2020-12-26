import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    
    private long HASH_SIZE = 31;
    
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        List<String> res = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        
        for (String word : wordDict) {
            long hash = 0;
            for (int i = 0; i < word.length(); i++) {
                hash = hash * HASH_SIZE + word.charAt(i);
            }
            
            set.add(hash);
        }
        
        // s的后i个字符是否能被组合起来
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            long hash = 0;
            for (int j = 1; j <= i; j++) {
                hash = hash * HASH_SIZE + s.charAt(s.length() - i + j - 1);
                if (set.contains(hash) && wordDict.contains(s.substring(s.length() - i, s.length() - i + j))) {
                    dp[i] = dp[i - j];
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        
        dfs(new StringBuilder(), 0, s, dp, set, wordDict, res);
        return res;
    }
    
    private void dfs(StringBuilder sb, int pos, String s, boolean[] dp, Set<Long> set, Set<String> dict, List<String> res) {
        if (pos == s.length()) {
            res.add(sb.substring(0, sb.length() - 1));
            return;
        }
        
        long hash = 0;
        for (int i = pos; i < s.length(); i++) {
            hash = hash * HASH_SIZE + s.charAt(i);
            String cut = s.substring(pos, i + 1);
            if (set.contains(hash) && dict.contains(cut) && dp[s.length() - pos]) {
                sb.append(cut).append(' ');
                dfs(sb, i + 1, s, dp, set, dict, res);
                sb.setLength(sb.length() - cut.length() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>() {{
            add("de");
            add("ding");
            add("co");
            add("code");
            add("lint");
        }};
        System.out.println(new Solution().wordBreak("lintcode", dict));
    }
}
