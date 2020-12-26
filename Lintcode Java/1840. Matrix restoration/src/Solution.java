import java.util.Arrays;

public class Solution {
    /**
     * @param n: the row of the matrix
     * @param m: the column of the matrix
     * @param after: the matrix
     * @return: restore the matrix
     */
    public int[][] matrixRestoration(int n, int m, int[][] after) {
        // write your code here
        for (int i = n - 1; i > 0; i--) {
            for (int j = m - 1; j > 0; j--) {
                after[i][j] = after[i][j] - after[i - 1][j] - after[i][j - 1] + after[i - 1][j - 1];
            }
        }
    
        for (int i = n - 1; i > 0; i--) {
            after[i][0] -= after[i - 1][0];
        }
    
        for (int i = m - 1; i > 0; i--) {
            after[0][i] -= after[0][i - 1];
        }
        
        return after;
    }
    
    public static void main(String[] args) {
        int[][] after = {{1, 3}, {4, 10}};
        System.out.println(Arrays.deepToString(new Solution().matrixRestoration(2, 2, after)));
    }
}
