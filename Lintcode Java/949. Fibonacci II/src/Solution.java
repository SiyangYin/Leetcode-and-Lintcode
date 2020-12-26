public class Solution {
    
    class Matrix {
        int[][] mat;
    
        public Matrix(int a00, int a01, int a10, int a11) {
            mat = new int[2][2];
            mat[0][0] = a00;
            mat[0][1] = a01;
            mat[1][0] = a10;
            mat[1][1] = a11;
        }
        
        public void multiply(Matrix m) {
            int[][] mat1 = m.mat;
            int a00 = mat[0][0] * mat1[0][0] + mat[0][1] * mat1[1][0];
            int a01 = mat[0][0] * mat1[0][1] + mat[0][1] * mat1[1][1];
            int a10 = mat[1][0] * mat1[0][0] + mat[1][1] * mat1[1][0];
            int a11 = mat[1][0] * mat1[0][1] + mat[1][1] * mat1[1][1];
            
            mat[0][0] = a00;
            mat[0][1] = a01;
            mat[1][0] = a10;
            mat[1][1] = a11;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    mat[i][j] %= MOD;
                }
            }
        }
    }
    
    private int MOD = 10000;
    
    /**
     * @param n: an integer
     * @return: return an int
     */
    public int lastFourDigitsOfFn(int n) {
        // write your code here
        Matrix matrix = new Matrix(1, 1, 1, 0);
        
        Matrix res = new Matrix(1, 0, 0, 1);
        
        while (n > 0) {
            if (n % 2 == 1) {
                res.multiply(matrix);
            }
            
            matrix.multiply(matrix);
            n >>= 1;
        }
        
        return res.mat[1][0];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().lastFourDigitsOfFn(9));
        System.out.println(new Solution().lastFourDigitsOfFn(0));
    }
}
