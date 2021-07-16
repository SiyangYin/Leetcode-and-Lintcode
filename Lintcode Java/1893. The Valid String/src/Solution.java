import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param s: a String
     * @return: if valid return "YES" else return "NO"
     */
    public String isValid(String s) {
        // write your code here
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // 出现了key次的字符有value个
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            
            map.put(count[i], map.getOrDefault(count[i], 0) + 1);
        }
        
        if (map.size() == 1) {
            return "YES";
        }
        if (map.size() > 2) {
            return "NO";
        }
        
        int[] cnt = new int[2];
        int idx = 0;
        for (int c : map.keySet()) {
            cnt[idx++] = c;
        }
        
        idx = cnt[0] > cnt[1] ? 0 : 1;
        if (map.get(cnt[idx]) == 1 && cnt[idx] - cnt[idx ^ 1] == 1) {
            return "YES";
        }
        if (map.get(cnt[idx ^ 1]) == 1 && cnt[idx ^ 1] == 1) {
            return "YES";
        }
        
        return "NO";
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("aabbccc"));
        System.out.println(new Solution().isValid("aabbc"));
        // System.out.println(new Solution().isValid("aabbcd"));
        // System.out.println(new Solution().isValid("aabbbb"));
        // System.out.println(new Solution().isValid("abbaaa"));
    }
}
