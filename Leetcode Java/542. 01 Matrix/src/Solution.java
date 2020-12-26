import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] res = new int[n][m];
    
        for (int i = 0; i < res.length; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[] dir = {1, 0, -1, 0, 1};
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int j = 0; j < 4; j++) {
                    int nextX = x + dir[j], nextY = y + dir[j + 1];
                    if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m && matrix[nextX][nextY] == 1) {
                        if (res[nextX][nextY] > step) {
                            res[nextX][nextY] = step;
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }
        
        return res;
    }
}
