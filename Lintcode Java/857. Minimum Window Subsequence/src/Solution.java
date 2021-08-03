public class Solution {
    /**
     * @param s1: a string
     * @param s2: a string
     * @return: the minimum substring of s1
     */
    public String minWindow(String s1, String s2) {
        // Write your code here
        int n = s1.length(), m = s2.length(), begin = -1, minLen = n + 1;
        
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            f[0][i] = i == 0 ? 0 : -1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    f[i][j] = i;
                } else {
                    if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                        f[i][j] = f[i - 1][j];
                    } else {
                        f[i][j] = Math.max(f[i - 1][j - 1], f[i - 1][j]);
                    }
                }
            }
            
            if (f[i][m] != -1) {
                int len = i - f[i][m];
                if (len < minLen) {
                    minLen = len;
                    begin = f[i][m];
                }
            }
        }
        
        return begin == -1 ? "" : s1.substring(begin, begin + minLen);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("abcdebdde", "bde"));
    }
}
