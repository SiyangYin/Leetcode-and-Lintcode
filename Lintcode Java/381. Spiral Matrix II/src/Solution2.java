import java.util.Arrays;

public class Solution2 {
    /**
     * @param n: An integer
     * @return: a square matrix
     */
    public int[][] generateMatrix(int n) {
        // write your code here
        int[][] res = new int[n][n];
        int[] d = {0, 1, 0, -1, 0};
        int count = 0;
        int x = 0, y = 0;
        while (count < n * n) {
            for (int i = 0; i < 4; i++) {
                while (0 <= x && x < n && 0 <= y && y < n && res[x][y] == 0) {
                    res[x][y] = ++count;
                    x += d[i];
                    y += d[i + 1];
                }
                
                x -= d[i];
                y -= d[i + 1];
                x += d[(i + 1) % 4];
                y += d[(i + 2) % 4];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution2().generateMatrix(2)));
    }
}
