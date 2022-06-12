public class Solution {
    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0, j = 1;
        while (i < n && j < n) {
            int k = 0;
            while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            
            if (i + k == n || j + k == n) {
                break;
            }
            
            if (s.charAt(i + k) < s.charAt(j + k)) {
                i += k + 1;
            } else {
                j += k + 1;
            }
            
            if (i == j) {
                j++;
            }
        }
        
        return s.substring(Math.min(i, j));
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().lastSubstring("leetcode"));
    }
}
