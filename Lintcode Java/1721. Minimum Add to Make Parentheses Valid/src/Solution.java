public class Solution {
    /**
     * @param S: the given string
     * @return: the minimum number of parentheses we must add
     */
    public int minAddToMakeValid(String S) {
        // Write your code here
        int res = 0, l = 0, r = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            
            if (r > l) {
                l++;
                res++;
            }
        }
        
        res += l - r;
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minAddToMakeValid("())"));
        System.out.println(new Solution().minAddToMakeValid("((("));
    }
}
