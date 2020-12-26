public class Solution2 {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i][j + 1];
                }
            }
        }
        
        int res = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int min = mat[i][j];
                for (int k = i; k < m; k++) {
                    min = Math.min(min, mat[k][j]);
                    res += min;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}};
        System.out.println(new Solution2().numSubmat(mat));
        System.out.println(new Solution3().numSubmat(mat));
    }
}
