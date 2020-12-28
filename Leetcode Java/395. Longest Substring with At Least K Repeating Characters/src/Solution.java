public class Solution {
    public int longestSubstring(String s, int k) {
        int[][] preCount = new int[26][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                preCount[ch - 'a'][i + 1] = preCount[ch - 'a'][i];
            }
            
            preCount[s.charAt(i) - 'a'][i + 1] = preCount[s.charAt(i) - 'a'][i] + 1;
        }
        
        return dfs(s, 0, s.length() - 1, preCount, k);
    }
    
    private int dfs(String s, int l, int r, int[][] preCount, int k) {
        if (l > r) {
            return 0;
        }
        
        for (int i = l; i <= r; i++) {
            if (preCount[s.charAt(i) - 'a'][r + 1] - preCount[s.charAt(i) - 'a'][l] < k) {
                int right = i;
                while (right <= r && preCount[s.charAt(right) - 'a'][r + 1] - preCount[s.charAt(right) - 'a'][l] < k) {
                    right++;
                }
                
                return Math.max(dfs(s, l, i - 1, preCount, k), dfs(s, right, r, preCount, k));
            }
        }
        
        return r - l + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestSubstring("ababbc", 2));
        // System.out.println(new Solution().longestSubstring("aaabb", 3));
    }
}
