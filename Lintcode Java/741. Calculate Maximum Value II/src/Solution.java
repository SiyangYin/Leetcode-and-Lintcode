public class Solution {
    /**
     * @param str: a string of numbers
     * @return: the maximum value
     */
    public int maxValue(String str) {
        // write your code here
        int n = str.length();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = str.charAt(i) - '0';
        }
        
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                for (int i = l; i < r; i++) {
                    f[l][r] = Math.max(f[l][r], Math.max(f[l][i] + f[i + 1][r], f[l][i] * f[i + 1][r]));
                }
            }
        }
        
        return f[0][n - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxValue("01231"));
    }
}
