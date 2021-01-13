import java.util.*;

public class Solution {
    /**
     * @param words: List[str]
     * @return: return List[str]
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // write your code here
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        Arrays.sort(words, (w1, w2) -> Integer.compare(w1.length(), w2.length()));
        for (int i = 0; i < words.length; i++) {
            if (check(words[i], set)) {
                res.add(words[i]);
            }
            
            set.add(words[i]);
        }
        
        return res;
    }
    
    private boolean check(String s, Set<String> set) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == -1) {
                continue;
            }
            
            for (int j = s.length() - i; j >= 0; j--) {
                if (set.contains(s.substring(i, i + j))) {
                    dp[i + j] = Math.max(dp[i + j], dp[i] + 1);
                }
                
                if (dp[s.length()] > 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
