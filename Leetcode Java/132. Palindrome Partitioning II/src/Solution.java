public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        
        int[] minCut = new int[n];
        minCut[0] = 0;
        
        for (int i = 1; i < n; i++) {
            minCut[i] = i;
            for (int j = i; j >= 0; j--) {
                isPalindrome[j][i] = s.charAt(j) == s.charAt(i);
                if (i - j + 1 > 2) {
                    isPalindrome[j][i] &= isPalindrome[j + 1][i - 1];
                }
                
                if (isPalindrome[j][i]) {
                    if (j == 0) {
                        minCut[i] = 0;
                        break;
                    } else {
                        minCut[i] = Math.min(minCut[i], 1 + minCut[j - 1]);
                    }
                }
            }
        }
        
        return minCut[n - 1];
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().minCut("aab"));
        // System.out.println(new Solution().minCut("bb"));
        System.out.println(new Solution().minCut("ccaacabacb"));
    }
}
