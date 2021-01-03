public class Solution {
    /**
     * @param string: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean matchParentheses(String string) {
        // write your code here
        if (string.length() % 2 != 0) {
            return false;
        }
        
        int l = 0, r = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            
            if (l < r) {
                return false;
            }
        }
        
        return l == r;
    }
}
