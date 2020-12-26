public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
    public int maxSubmatrix(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int res = 0;
        int[][] preSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                preSum[i + 1][j + 1] = matrix[i][j] + preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j];
            }
        }
    
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                res = Math.max(res, maxSubsum(colSum(preSum, i, j)));
            }
        }
        
        return res;
    }
    
    private int[] colSum(int[][] preSum, int from, int to) {
        int[] res = new int[preSum[0].length - 1];
        // mat[from][i] mat[to][i]
        for (int i = 0; i < res.length; i++) {
            res[i] = preSum[to + 1][i + 1] - preSum[to + 1][i] - preSum[from][i + 1] + preSum[from][i];
        }
        
        return res;
    }
    
    private int maxSubsum(int[] nums) {
        int sum = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            res = Math.max(res, sum);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] mat = {{1,3,-1},{2,3,-2},{-1,-2,-3}};
        System.out.println(new Solution().maxSubmatrix(mat));
    }
}
