import java.util.Arrays;
import java.util.Random;

public class Solution2 {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0) {
            return new int[0][0];
        }
        
        int p = A.length, q = A[0].length, r = B[0].length;
        int[][] res = new int[p][r];
        
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < r; k++) {
                        if (B[j][k] != 0) {
                            res[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] A = {{1, 0, 0}, {-1, 0, 3}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(Arrays.deepToString(new Solution2().multiply(A, B)));
        Random random = new Random();
    
        for (int f = 0; f < 100; f++) {
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = random.nextInt(10);
            }
        }
    
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                B[i][j] = random.nextInt(13);
            }
        }
    
        int[][] res1 = new Solution().multiply(A, B);
        int[][] res2 = new Solution2().multiply(A, B);
        System.out.println(Arrays.deepEquals(res1, res2));
        }
    }
}
