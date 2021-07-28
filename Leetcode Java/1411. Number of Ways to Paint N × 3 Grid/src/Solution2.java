public class Solution2 {
    
    class Matrix {
        private final int MOD = (int) (1e9 + 7);
        private long a11, a12, a21, a22;
        
        public Matrix(int a11, int a12, int a21, int a22) {
            this.a11 = a11;
            this.a12 = a12;
            this.a21 = a21;
            this.a22 = a22;
        }
        
        public void mult(Matrix B) {
            long c11 = (a11 * B.a11 + a12 * B.a21) % MOD;
            long c12 = (a11 * B.a12 + a12 * B.a22) % MOD;
            long c21 = (a21 * B.a11 + a22 * B.a21) % MOD;
            long c22 = (a21 * B.a12 + a22 * B.a22) % MOD;
            a11 = c11;
            a12 = c12;
            a21 = c21;
            a22 = c22;
        }
    }
    
    public int numOfWays(int n) {
        int MOD = (int) (1e9 + 7);
        Matrix res = new Matrix(1, 0, 0, 1), A = new Matrix(3, 2, 2, 2);
        n--;
        while (n > 0) {
            if ((n & 1) == 1) {
                res.mult(A);
            }
            
            n >>= 1;
            A.mult(A);
        }
        
        return (int) ((res.a11 + res.a12 + res.a21 + res.a22) * 6 % MOD);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().numOfWays(5000));
    }
}
