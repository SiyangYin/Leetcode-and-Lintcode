import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param matrix : the martix
     * @return: the distance of grid to the police
     */
    public int[][] policeDistance(int[][] matrix) {
        // Write your code here
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    vis[i][j] = true;
                } else if (matrix[i][j] == -1) {
                    res[i][j] = -1;
                }
            }
        }
        
        int dis = 0;
        int[] d = {1, 0, -1, 0, 1};
        while (!queue.isEmpty()) {
            dis++;
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int j = 0; j < 4; j++) {
                    int nextX = x + d[j], nextY = y + d[j + 1];
                    if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && matrix[nextX][nextY] == 0 && !vis[nextX][nextY]) {
                        res[nextX][nextY] = dis;
                        vis[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        
        return res;
    }
}
