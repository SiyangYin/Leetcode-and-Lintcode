import java.util.Arrays;

public class Solution2 {
    public int longestSubstring(String s, int k) {
        int res = 0, diffCount = 0, kCount = 0;
        int[] count = new int[26];
        
        for (int c = 1; c <= 26; c++) {
            Arrays.fill(count, 0);
            diffCount = kCount = 0;
            
            for (int i = 0, j = 0; i < s.length(); i++) {
                char chi = s.charAt(i);
                count[chi - 'a']++;
                if (count[chi - 'a'] == 1) {
                    diffCount++;
                }
                if (count[chi - 'a'] == k) {
                    kCount++;
                }
                
                if (diffCount > c) {
                    while (diffCount > c) {
                        char chj = s.charAt(j);
                        
                        count[chj - 'a']--;
                        if (count[chj - 'a'] == 0) {
                            diffCount--;
                        }
                        if (count[chj - 'a'] == k - 1) {
                            kCount--;
                        }
                        
                        j++;
                    }
                } else if (diffCount == c) {
                    if (diffCount == kCount) {
                        res = Math.max(res, i - j + 1);
                    }
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution2().longestSubstring("aaabb", 3));
        System.out.println(new Solution2().longestSubstring("bbaaacbd", 3));
    }
}
