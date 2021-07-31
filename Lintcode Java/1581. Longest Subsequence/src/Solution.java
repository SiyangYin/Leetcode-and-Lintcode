import java.util.Set;

public class Solution {
    /**
     * @param word_dict: a dictionary
     * @param s: a string
     * @return: the longest one existed in the given dictionary
     */
    public String longestSubsequence(Set<String> word_dict, String s) {
        // Write your code here
        int[][] dfa = buildDfa(s);
        String res = "";
        for (String str : word_dict) {
            if (check(str, dfa) && (str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) < 0))) {
                res = str;
            }
        }
        
        return res;
    }
    
    private boolean check(String s, int[][] dfa) {
        if (s.length() >= dfa.length) {
            return false;
        }
        
        for (int i = 0, pos = 0; i < s.length(); i++) {
            pos = dfa[pos][s.charAt(i) - 'a'];
            if (pos == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private int[][] buildDfa(String s) {
        int[][] dfa = new int[s.length() + 1][26];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                dfa[i][j] = dfa[i + 1][j];
            }
            dfa[i][s.charAt(i) - 'a'] = i + 1;
        }
        
        return dfa;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestSubsequence(Set.of("code"), "lintcode"));
    }
}
