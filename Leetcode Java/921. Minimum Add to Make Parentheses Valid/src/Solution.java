public class Solution {
    public int minAddToMakeValid(String S) {
        int res = 0, l = 0, r = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                l++;
            } else {
                r++;
            }
            
            if (l < r) {
                res++;
                l++;
            }
        }
        
        res += l - r;
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minAddToMakeValid("((()"));
    }
}
