public class Solution {
    /**
     * @param arr: the steps whether have glue
     * @return: the sum of the answers
     */
    public int ratJump(int[] arr) {
        // Write your code here.
        int n = arr.length, mod = (int) (1e9 + 7);
        long[][] f = new long[n + 3][2];
        int[][] s = {{1, 3, 4}, {1, 2, 4}};
        f[0][0] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == 1) {
                continue;
            }
            
            for (int x : s[0]) {
                f[i + x][0] = (f[i + x][0] + f[i][1]) % mod;
            }
            for (int x : s[1]) {
                f[i + x][1] = (f[i + x][1] + f[i][0]) % mod;
            }
        }
        
        long res = 0;
        for (int i = n - 1; i < f.length; i++) {
            res = (res + f[i][0] + f[i][1]) % mod;
        }
        
        return (int) res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().ratJump(new int[]{0, 0, 0}));
    }
}
