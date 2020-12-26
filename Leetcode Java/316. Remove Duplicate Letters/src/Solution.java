import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        boolean[] used = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
    
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (used[ch - 'a']) {
                continue;
            }
            
            char last = 0;
            while (sb.length() > 0 && (last = sb.charAt(sb.length() - 1)) > ch && map.get(last) > i) {
                used[last - 'a'] = false;
                sb.setLength(sb.length() - 1);
            }
            
            sb.append(ch);
            used[ch - 'a'] = true;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("bcabc"));
        System.out.println(new Solution().removeDuplicateLetters("cbacdcbc"));
        System.out.println(new Solution().removeDuplicateLetters("bbcaac"));
    }
}
