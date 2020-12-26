import java.util.Arrays;

public class Solution {
    /**
     * @param nums: List[List[int]]
     * @param r:    an integer
     * @param c:    an integer
     * @return: return List[List[int]]
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // write your code here
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        
        int[][] res = new int[r][c];
        for (int idx = 0, i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[idx / c][idx % c] = nums[i][j];
                idx++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(new Solution().matrixReshape(nums, 1, 4)));
    }
}
