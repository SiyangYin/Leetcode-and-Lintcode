public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (n * m != r * c) {
            return nums;
        }
        
        int[][] res = new int[r][c];
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[idx / c][idx % c] = nums[i][j];
                idx++;
            }
        }
        
        return res;
    }
}
