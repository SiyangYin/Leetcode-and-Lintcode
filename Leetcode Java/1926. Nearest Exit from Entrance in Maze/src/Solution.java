import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        boolean[][] vis = new boolean[maze.length][maze[0].length];
        vis[entrance[0]][entrance[1]] = true;
        int[] d = {-1, 0, 1, 0, -1};
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            for (int i = q.size() - 1; i >= 0; i--) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = cur[0] + d[j], nextY = cur[1] + d[j + 1];
                    if (0 <= nextX && nextX < maze.length && 0 <= nextY && nextY < maze[0].length && maze[nextX][nextY] != '+' && !vis[nextX][nextY]) {
                        if (check(nextX, nextY, maze)) {
                            return res;
                        }
                        
                        vis[nextX][nextY] = true;
                        q.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean check(int x, int y, char[][] maze) {
        return x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1;
    }
}
