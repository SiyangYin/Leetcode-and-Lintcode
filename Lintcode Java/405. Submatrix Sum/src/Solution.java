import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * @param matrix: an integer matrix
     * @return: the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // write your code here
        int[][] res = null;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = matrix[i][j] + preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int[] nums = new int[n + 1];
                for (int k = 0; k < n; k++) {
                    // (i, 0)   (j, k)
                    nums[k + 1] = preSum[j + 1][k + 1] - preSum[j + 1][0] - preSum[i][k + 1] + preSum[i][0];
                }
                
                int[] idx = solveOneD(nums);
                if (idx != null) {
                    res = new int[][]{{i, idx[0]}, {j, idx[1] - 1}};
                    return res;
                }
            }
        }
        
        return res;
    }
    
    private int[] solveOneD(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int start = map.get(nums[i]);
                return new int[]{start, i};
            }
            
            map.put(nums[i], i);
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        // int[][] mat = {{1, 5, 7}, {3, 7, -8}, {4, -8, 9}};
        int[][] mat = {{0}};
        System.out.println(Arrays.deepToString(new Solution().submatrixSum(mat)));
    }
}
