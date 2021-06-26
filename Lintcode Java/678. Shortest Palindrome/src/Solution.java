public class Solution {
    /**
     * @param str: String
     * @return: String
     */
    public String shortestPalindrome(String str) {
        // Write your code here
        for (int i = str.length() - 1; i >= 0; i--) {
            if (check(str, i)) {
                String suf = str.substring(i + 1);
                return new StringBuilder(suf).reverse().append(str).toString();
            }
        }
        
        return "";
    }
    
    private boolean check(String s, int j) {
        for (int i = 0; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().shortestPalindrome("aacecaaa"));
    }
}
