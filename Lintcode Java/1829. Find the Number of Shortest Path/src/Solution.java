import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param n: the row of the map
     * @param m: the column of the map
     * @param A: the map
     * @return: the number of shortest path
     */
    public int theNumberofShortestPath(int n, int m, int[][] A) {
        // write your code here
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[n][m], cnt = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }
        
        for (int i = 0; i < m; i++) {
            if (A[0][i] == 0) {
                queue.offer(new int[]{0, i});
                dist[0][i] = 0;
                cnt[0][i] = 1;
            }
        }
        
        int step = 0;
        boolean flag = false;
        int[] d = {1, 0, -1, 0, 1};
        while (!queue.isEmpty()) {
            step++;
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = cur[0], y = cur[1];
                    int nextX = x + d[j], nextY = y + d[j + 1];
                    if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m && A[nextX][nextY] == 0) {
                        if (dist[nextX][nextY] == -1) {
                            dist[nextX][nextY] = step;
                            cnt[nextX][nextY] = cnt[x][y];
                            queue.offer(new int[]{nextX, nextY});
                            
                            if (nextX == n - 1) {
                                flag = true;
                            }
                        } else if (dist[nextX][nextY] == step) {
                            cnt[nextX][nextY] += cnt[x][y];
                        }
                    }
                }
            }
            
            if (flag) {
                break;
            }
        }
        
        int res = 0;
        for (int x : cnt[n - 1]) {
            res += x;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int n = 5, m = 7;
        int[][] g = {
                {0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1}};
        System.out.println(new Solution().theNumberofShortestPath(n, m, g));
    }
}
