public class Solution {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return check(s, i + 1, j) || check(s, i, j - 1);
            }
        }
        return true;
    }
    
    public boolean check(String s, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("eeccccbebaeeabebccceea"));
    }
    
}
