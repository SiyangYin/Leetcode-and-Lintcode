import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        long P = 131;
        long[] hashS = new long[s.length() + 1], pow = new long[s.length() + 1];
        pow[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            hashS[i + 1] = hashS[i] * P + s.charAt(i);
            pow[i + 1] = pow[i] * P;
        }
        
        Set<Long> set = new HashSet<>();
        for (String word : wordDict) {
            long hash = 0;
            for (int i = 0; i < word.length(); i++) {
                hash = hash * P + word.charAt(i);
            }
            
            set.add(hash);
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(hashS[i] - hashS[j] * pow[i - j])) {
                    dp[i] |= dp[j];
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        if (!dp[s.length()]) {
            return res;
        }
        
        dfs(s.length() - 1, s, new ArrayList<>(), set, dp, hashS, pow, res);
        return res;
    }
    
    private void dfs(int pos, String s, List<String> list, Set<Long> set, boolean[] dp, long[] hashS, long[] pow, List<String> res) {
        if (pos == -1) {
            StringBuilder sb = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                sb.append(list.get(i)).append(' ');
            }
            
            res.add(sb.substring(0, sb.length() - 1));
            return;
        }
    
        for (int i = pos; i >= 0; i--) {
            if (dp[i] && set.contains(hashS[pos + 1] - hashS[i] * pow[pos - i + 1])) {
                list.add(s.substring(i, pos + 1));
                dfs(i - 1, s, list, set, dp, hashS, pow, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
