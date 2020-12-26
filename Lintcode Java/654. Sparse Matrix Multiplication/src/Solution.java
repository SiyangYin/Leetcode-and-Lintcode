import java.util.Arrays;

public class Solution {
    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        int[][] C = new int[A.length][B[0].length];
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < B[0].length; k++) {
                        C[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        
        return C;
    }
    
    public static void main(String[] args) {
        int[][] A = {{1, 0, 0}, {-1, 0, 3}}, B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(Arrays.deepToString(new Solution().multiply(A, B)));
    }
}
