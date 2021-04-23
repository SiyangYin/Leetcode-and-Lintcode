import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] d = {1, 0, -1, 0, 1};
        int[] mapToD = {3, 2, 4, 1};
        
        Deque<Integer> deque = new ArrayDeque<>();
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        boolean[][] visited = new boolean[m][n];
        
        deque.offerLast(0);
        dist[0][0] = 0;
        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();
            if (visited[cur / n][cur % n]) {
                continue;
            }
            
            int x = cur / n, y = cur % n;
            if (x == m - 1 && y == n - 1) {
                return dist[m - 1][n - 1];
            }
            
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = x + d[i], nextY = y + d[i + 1];
                if (!(0 <= nextX && nextX < m && 0 <= nextY && nextY < n)) {
                    continue;
                }
                
                int e = grid[x][y] == mapToD[i] ? 0 : 1;
                if (!visited[nextX][nextY] && dist[nextX][nextY] > dist[x][y] + e) {
                    dist[nextX][nextY] = dist[x][y] + e;
                    if (e == 0) {
                        deque.offerFirst(nextX * n + nextY);
                    } else {
                        deque.offerLast(nextX * n + nextY);
                    }
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 2}, {4, 3}};
        System.out.println(new Solution().minCost(g));
    }
}
