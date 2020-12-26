public class Solution {
    public int longestSubstring(String s, int k) {
        int[] count = new int[26];
        int res = 0;
        for (int j = 0, i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            while (check(count, k)) {
                res = Math.max(res, i - j + 1);
                count[s.charAt(j) - 'a']--;
                j++;
            }
        }
        
        return res;
    }
    
    private boolean check(int[] count, int k) {
        for (int i = 0; i < count.length; i++) {
            if (0 < count[i] && count[i] < k) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestSubstring("ababbc", 2));
    }
}
