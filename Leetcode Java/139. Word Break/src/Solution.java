import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return true;
        }
    
        Set<String> dict = new HashSet<>(wordDict);
        int minLen = Integer.MAX_VALUE, maxLen = 0;
        for (String word : wordDict) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
        
        boolean[] dp = new boolean[s.length()];
    
        // s[0,...,i]可以被切分吗
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j + 1 >= minLen && i - j + 1 <= maxLen && dict.contains(s.substring(j, i + 1))) {
                    if (j == 0) {
                        dp[i] = true;
                        break;
                    } else {
                        dp[i] |= dp[j - 1];
                    }
                }
            }
        }
        
        return dp[s.length() - 1];
    }
    
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> dict = new ArrayList<>(){{
            add("apple");
            add("pen");
        }};
    
        System.out.println(new Solution().wordBreak(s, dict));
    }
}
