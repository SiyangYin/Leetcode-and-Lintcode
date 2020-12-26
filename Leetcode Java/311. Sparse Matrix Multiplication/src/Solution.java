import java.util.Arrays;

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0) {
            return new int[0][0];
        }
        
        int p = A.length, q = A[0].length, r = B[0].length;
        int[][] res = new int[p][r];
        
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                int idx1 = 0, idx2 = 0;
                while (idx1 < q && idx2 < q) {
                    while (idx1 < q && A[i][idx1] == 0) {
                        idx1++;
                    }
                    if (idx1 == q) {
                        break;
                    }
                    while (idx2 < q && B[idx2][j] == 0) {
                        idx2++;
                    }
                    if (idx2 == q) {
                        break;
                    }
                    
                    if (idx1 == idx2) {
                        res[i][j] += A[i][idx1] * B[idx1][j];
                        idx1++;
                        idx2++;
                    } else {
                        int max = Math.max(idx1, idx2);
                        idx1 = idx2 = max;
                    }
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] A = {{1, -5}};
        int[][] B = {{12}, {-1}};
        System.out.println(Arrays.deepToString(new Solution().multiply(A, B)));
    }
}
