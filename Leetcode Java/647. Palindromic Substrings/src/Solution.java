public class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
    
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }
    
        int count = len;
        
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (i + 1 >= j - 1 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aaa"));
    }
}
