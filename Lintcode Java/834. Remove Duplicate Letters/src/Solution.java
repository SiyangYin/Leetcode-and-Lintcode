import java.util.Arrays;

public class Solution {
    /**
     * @param s: a string
     * @return: return a string
     */
    public String removeDuplicateLetters(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return s;
        }
        int[] count = new int[26];
        boolean[] used = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if (used[c - 'a']) {
                continue;
            }
            
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.setLength(sb.length() - 1);
            }
            
            sb.append(c);
            used[c - 'a'] = true;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().removeDuplicateLetters("bcabc"));
        System.out.println(new Solution().removeDuplicateLetters("cbacdcbc"));
    }
}
