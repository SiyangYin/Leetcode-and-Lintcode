import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        s = s.toLowerCase();
        Set<Long> set = new HashSet<>();
        long P = 131;
        for (String str : dict) {
            long hash = 0;
            str = str.toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                hash = hash * P + str.charAt(i);
            }
            
            set.add(hash);
        }
        
        long[] hashS = new long[s.length() + 1], pow = new long[s.length() + 1];
        pow[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            hashS[i + 1] = hashS[i] * P + s.charAt(i);
            pow[i + 1] = pow[i] * P;
        }
        
        // s[0, ..., i - 1]能被拆分的方案数
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                long hash = hashS[i] - hashS[j] * pow[i - j];
                if (set.contains(hash)) {
                    dp[i] += dp[j];
                }
            }
        }
        
        return dp[s.length()];
    }
    
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("aaaa");
        dict.add("aaa");
        dict.add("Aa");
        
        System.out.println(new Solution().wordBreak3("aaaaaaaa", dict));
    }
}
