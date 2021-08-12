import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum = new int[m + 1][n];
    
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= m; i++) {
                preSum[i][j] = preSum[i - 1][j] + matrix[i - 1][j];
            }
        }
        
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int sum = 0;
                map.clear();
                map.put(0, 1);
                for (int k = 0; k < n; k++) {
                    sum += preSum[j + 1][k] - preSum[i][k];
                    res += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {1, -1},
                {-1, 1}};
        System.out.println(new Solution().numSubmatrixSumTarget(mat, 0));
    }
}
