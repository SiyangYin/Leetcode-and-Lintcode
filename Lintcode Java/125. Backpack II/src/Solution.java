public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[][] f = new int[A.length][m + 1];
        
        for (int j = 1; j <= m; j++) {
            f[0][j] = A[0] <= j ? V[0] : 0;
        }
    
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= A[i]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - A[i]] + V[i]);
                }
            }
        }
        
        return f[A.length - 1][m];
    }
    
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 7};
        int[] V = {1, 5, 2, 4};
    
        System.out.println(new Solution().backPackII(10, A, V));
    }
}