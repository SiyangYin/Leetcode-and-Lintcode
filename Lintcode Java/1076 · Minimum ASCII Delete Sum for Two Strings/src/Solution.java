public class Solution {
    /**
     * @param s1: a string
     * @param s2: a string
     * @return: the lowest ASCII sum of deleted characters to make two strings equal
     */
    public int minimumDeleteSum(String s1, String s2) {
        // Write your code here
        int m = s1.length(), n = s2.length();
        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum += s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            sum += s2.charAt(i);
        }
        
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + s1.charAt(i - 1));
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        
        return sum - 2 * f[m][n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minimumDeleteSum("sea", "eat"));
    }
}
