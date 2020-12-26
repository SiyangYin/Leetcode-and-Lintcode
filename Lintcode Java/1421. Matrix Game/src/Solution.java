import java.util.Arrays;

public class Solution {
    /**
     * @param grids: a integer matrix
     * @return: return the difference between two people at last.
     */
    public int MatrixGame(int[][] grids) {
        // write your code here
        if (grids == null || grids.length == 0 || grids[0].length == 0) {
            return 0;
        }
        
        int[] max = new int[grids[0].length];
        Arrays.fill(max, Integer.MIN_VALUE);
    
        for (int i = 0; i < grids[0].length; i++) {
            for (int j = 0; j < grids.length; j++) {
                max[i] = Math.max(max[i], grids[j][i]);
            }
        }
        
        Arrays.sort(max);
        int res = 0, sign = 1;
        for (int i = max.length - 1; i >= 0; i--) {
            res += sign * max[i];
            sign *= -1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] grids = {{1,4,7}, {2,5,8},{3,6,9}};
        System.out.println(new Solution().MatrixGame(grids));
    }
}
