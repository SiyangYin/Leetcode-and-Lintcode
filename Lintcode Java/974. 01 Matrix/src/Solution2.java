import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    /**
     * @param matrix: a 0-1 matrix
     * @return: return a matrix
     */
    public int[][] updateMatrix(int[][] matrix) {
        // write your code here
        int m = matrix.length, n = matrix[0].length;
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * n + j);
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                int x = cur / n, y = cur % n;
                for (int j = 0; j < dirs.length; j++) {
                    int nextX = x + dirs[j][0], nextY = y + dirs[j][1];
                    if (inBound(nextX, nextY, matrix) && matrix[nextX][nextY] != 0) {
                        if (matrix[nextX][nextY] > step) {
                            matrix[nextX][nextY] = step;
                            queue.offer(nextX * n + nextY);
                        }
                    }
                }
            }
        }
        
        return matrix;
    }
    
    private boolean inBound(int x, int y, int[][] matrix) {
        return 0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1}};
        System.out.println(Arrays.deepToString(new Solution2().updateMatrix(matrix)));
        
        // Integer a = 127;
        // Integer b = 127;
        // Integer a = new Integer(127);
        // Integer b = new Integer(127);
        // System.out.println(a == b);
        // System.out.println(a.equals(b));
    }
}
