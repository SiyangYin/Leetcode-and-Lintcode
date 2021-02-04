import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        boolean[][] beginVisited = new boolean[m][n], endVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    beginQueue.offer(new int[]{i, j});
                    beginVisited[i][j] = true;
                } else if (grid[i][j] == '#') {
                    endQueue.offer(new int[]{i, j});
                    endVisited[i][j] = true;
                }
            }
        }
        
        int res = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            res++;
            if (oneStep(beginQueue, beginVisited, endVisited, grid)) {
                return res;
            }
            res++;
            if (oneStep(endQueue, endVisited, beginVisited, grid)) {
                return res;
            }
        }
        
        return -1;
    }
    
    private boolean oneStep(Queue<int[]> beginQueue, boolean[][] beginVisited, boolean[][] endVisited, char[][] grid) {
        int[] d = {1, 0, -1, 0, 1};
        
        int size = beginQueue.size();
        for (int i = 0; i < size; i++) {
            int[] cur = beginQueue.poll();
            for (int j = 0; j < 4; j++) {
                int nextX = cur[0] + d[j], nextY = cur[1] + d[j + 1];
                if (inBound(nextX, nextY, grid) && !beginVisited[nextX][nextY] && grid[nextX][nextY] != 'X') {
                    if (endVisited[nextX][nextY]) {
                        return true;
                    }
                    
                    beginVisited[nextX][nextY] = true;
                    beginQueue.offer(new int[]{nextX, nextY});
                }
            }
        }
        
        return false;
    }
    
    private boolean inBound(int x, int y, char[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
