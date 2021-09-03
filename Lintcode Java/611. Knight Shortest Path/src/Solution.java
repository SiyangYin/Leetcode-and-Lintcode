import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        int m = grid.length, n = grid[0].length;
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        // bq是beginQueue, eq是endQueue
        Queue<int[]> bq = new LinkedList<>(), eq = new LinkedList<>();
        boolean[][] bvis = new boolean[m][n], evis = new boolean[m][n];
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }
        
        bq.offer(new int[]{source.x, source.y});
        bvis[source.x][source.y] = true;
        eq.offer(new int[]{destination.x, destination.y});
        evis[destination.x][destination.y] = true;
        int step = 0;
        while (!bq.isEmpty() && !eq.isEmpty()) {
            step++;
            if (bq.size() <= eq.size()) {
                if (oneStep(bq, bvis, evis, grid, dx, dy)) {
                    return step;
                }
            } else {
                if (oneStep(eq, evis, bvis, grid, dx, dy)) {
                    return step;
                }
            }
        }
        
        return -1;
    }
    
    boolean oneStep(Queue<int[]> bq, boolean[][] bvis, boolean[][] evis, boolean[][] grid, int[] dx, int[] dy) {
        for (int k = bq.size(); k > 0; k--) {
            int[] cur = bq.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (inBound(nx, ny, grid) && !bvis[nx][ny] && !grid[nx][ny]) {
                    if (evis[nx][ny]) {
                        return true;
                    }
                    
                    bq.offer(new int[]{nx, ny});
                    bvis[nx][ny] = true;
                }
            }
        }
        
        return false;
    }
    
    private boolean inBound(int x, int y, boolean[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        boolean[][] grid = {
                {false, true, false},
                {false, false, true},
                {false, false, false}};
        
        Point source = new Point(2, 0);
        Point destination = new Point(2, 2);
        System.out.println(new Solution().shortestPath(grid, source, destination));
    }
}

class Point {
    
    int x, y;
    
    Point() {
        x = y = 0;
    }
    
    Point(int a, int b) {
        x = a;
        y = b;
    }
}