public class Solution {
    /**
     * @param s: the article
     * @return: the number of letters that are illegal
     */
    public int count(String s) {
        // Write your code here.
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int res = 0;
        if (Character.isLowerCase(s.charAt(0))) {
            res++;
        }
        
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ' && s.charAt(i - 1) == '.' && Character.isLowerCase(s.charAt(i + 1))) {
                res++;
            }
            
            if (s.charAt(i - 1) != ' ' && Character.isUpperCase(ch)) {
                res++;
            }
        }
        
        return res;
    }
}
