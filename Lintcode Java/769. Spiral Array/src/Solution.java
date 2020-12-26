import java.util.Arrays;

public class Solution {
    /**
     * @param n: a Integer
     * @return: a spiral array
     */
    public int[][] spiralArray(int n) {
        // write your code here
        int[][] res = new int[n][n];
        res[0][0] = 1;
        
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int num = 1, x = 0, y = 0;
        
        while (num < n * n) {
            for (int i = 0; i < 4; i++) {
                int dx = d[i][0], dy = d[i][1];
                while (inBound(n, x + dx, y + dy) && res[x + dx][y + dy] == 0) {
                    res[x + dx][y + dy] = ++num;
                    x += dx;
                    y += dy;
                }
            }
        }
        
        return res;
    }
    
    private boolean inBound(int n, int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    public static void main(String[] args) {
        for (int[] ints : new Solution().spiralArray(5)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
