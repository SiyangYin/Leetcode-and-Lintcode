public class Solution {
    /**
     * @param s: the given string s
     * @param t: the given string t
     * @return: check if s is subsequence of t
     */
    public boolean isSubsequence(String s, String t) {
        // Write your code here
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            while (j < t.length() && t.charAt(j) != s.charAt(i)) {
                j++;
            }
            if (j == t.length()) {
                return false;
            }
            
            i++;
            j++;
        }
        
        return i == s.length();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
    }
}
