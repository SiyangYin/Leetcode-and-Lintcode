import java.util.Arrays;

public class Solution {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        
        int[][] matrix = {{1, 1}, {1, 0}};
        N -= 1;
        
        int[][] ans = {{1, 0}, {0, 1}};
        while (N > 0) {
            if ((N & 1) == 1) {
                multi(ans, matrix);
            }
            multi(matrix, matrix);
            N >>= 1;
            System.out.println(Arrays.deepToString(ans));
        }
        
        return ans[0][0];
    }
    
    private void multi(int[][] matrix0, int[][] matrix2) {
        int[][] matrix1 = {{matrix2[0][0], matrix2[0][1]}, {matrix2[1][0], matrix2[1][1]}};
        
        int a00 = matrix0[0][0] * matrix1[0][0] + matrix0[0][1] * matrix1[1][0];
        int a01 = matrix0[0][0] * matrix1[0][1] + matrix0[0][1] * matrix1[1][1];
        int a10 = matrix0[1][0] * matrix1[0][0] + matrix0[1][1] * matrix1[1][0];
        int a11 = matrix0[1][0] * matrix1[0][1] + matrix0[1][1] * matrix1[1][1];
        matrix0[0][0] = a00;
        matrix0[0][1] = a01;
        matrix0[1][0] = a10;
        matrix0[1][1] = a11;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 1}, {0, 1}};
        // System.out.println(new Solution().fib(0));
        // System.out.println(new Solution().fib(1));
        System.out.println(new Solution().fib(4));
    }
}
