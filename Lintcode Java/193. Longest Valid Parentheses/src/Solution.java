public class Solution {
    /**
     * @param s: a string
     * @return: return a integer
     */
    public int longestValidParentheses(String s) {
        // write your code here
        int res = 0;
        
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                res = Math.max(res, left + right);
            }
            if (left < right) {
                left = right = 0;
            }
        }
        
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                right++;
            }
        
            if (left == right) {
                res = Math.max(res, left + right);
            }
            if (left > right) {
                left = right = 0;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("(()"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
    }
}
