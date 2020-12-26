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
        Set<String> dictCopy = new HashSet<>();
        long HASH_SIZE = 31;
        for (String str : dict) {
            long hash = 0;
            str = str.toLowerCase();
            dictCopy.add(str);
            for (int i = str.length() - 1; i >= 0; i--) {
                hash = hash * HASH_SIZE + str.charAt(i);
            }
            
            set.add(hash);
        }
        
        // s[0, ..., i - 1]能被拆分的方案数
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= s.length(); i++) {
            long hash = 0;
            for (int j = 1; j <= i; j++) {
                hash = hash * HASH_SIZE + s.charAt(i - j);
                if (set.contains(hash) && dictCopy.contains(s.substring(i - j, i))) {
                    dp[i] += dp[i - j];
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
        
        // System.out.println("aaaaaaaa".length());
    }
}
