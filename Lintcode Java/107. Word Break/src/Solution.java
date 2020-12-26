import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        int min = s.length(), max = 0;
        for (String word : dict) {
            min = Math.min(min, word.length());
            max = Math.max(max, word.length());
        }
        
        return dfs(s, 0, dict, min, max);
    }
    
    private boolean dfs(String s, int pos, Set<String> dict, int min, int max) {
        if (pos == s.length()) {
            return true;
        }
        
        for (int i = pos + min - 1; i <= pos + max - 1 && i < s.length(); i++) {
            if (dict.contains(s.substring(pos, i + 1))) {
                if (dfs(s, i + 1, dict, min, max)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("aaaa");
        dict.add("aaa");
    
        System.out.println(new Solution().wordBreak("aaaaaaa", dict));
    }
}

