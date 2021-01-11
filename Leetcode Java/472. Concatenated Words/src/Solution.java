import java.util.*;

public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (w1, w2) -> Integer.compare(w1.length(), w2.length()));
        
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (word.length() >= words[0].length() * 2) {
                if (check(word, set)) {
                    res.add(word);
                }
            }
            set.add(word);
        }
        
        return res;
    }
    
    private boolean check(String s, Set<String> set) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (dp[i] == -1) {
                continue;
            }
            
            for (int j = s.length() - i; j > 0; j--) {
                if (set.contains(s.substring(i, i + j))) {
                    dp[i + j] = Math.max(dp[i + j], dp[i] + 1);
                    if (dp[s.length()] > 1) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        String[] ss = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        // String[] ss = {"cat", "dog", "catdog"};
        // String[] ss = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa"};
        System.out.println(new Solution().findAllConcatenatedWordsInADict(ss));
    }
}
