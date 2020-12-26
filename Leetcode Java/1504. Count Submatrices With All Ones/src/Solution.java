public class Solution {
    public int numSubmat(int[][] mat) {
        // write your code here
        int res = 0;
        int m = mat.length, n = mat[0].length;
        for (int bound = m - 1; bound >= 0; bound--) {
            for (int i = 0; i <= bound; i++) {
                int width = 0;
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        width++;
                    } else {
                        width = 0;
                    }
                    res += width;
                    
                    if (i < bound) {
                        mat[i][j] &= mat[i + 1][j];
                    }
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
        System.out.println(new Solution().numSubmat(mat));
        System.out.println(new Solution2().numSubmat(mat));
    }
    
}
