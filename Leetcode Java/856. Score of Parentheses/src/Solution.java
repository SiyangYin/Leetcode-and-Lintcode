public class Solution {
    public int scoreOfParentheses(String S) {
        int l = 0, res = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                l++;
            } else {
                l--;
                if (S.charAt(i - 1) == '(') {
                    res += 1 << l;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().scoreOfParentheses("((()()))"));
        System.out.println(new Solution().scoreOfParentheses("(()(()))"));
    }
}
