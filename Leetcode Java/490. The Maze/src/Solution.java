import java.util.*;

public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        queue.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] next : getNexts(cur[0], cur[1], maze, dirs, visited)) {
                if (Arrays.equals(next, destination)) {
                    return true;
                }
                
                queue.offer(next);
                visited[next[0]][next[1]] = true;
            }
        }
        
        return false;
    }
    
    private List<int[]> getNexts(int x, int y, int[][] maze, int[][] dirs, boolean[][] visited) {
        List<int[]> nexts = new ArrayList<>();
        for (int i = 0; i < dirs.length; i++) {
            int dx = dirs[i][0], dy = dirs[i][1];
            int step = 1;
            while (inBound(x + step * dx, y + step * dy, maze) && maze[x + step * dx][y + step * dy] == 0) {
                step++;
            }
            
            step--;
            int nextX = x + step * dx, nextY = y + step * dy;
            if (!visited[nextX][nextY]) {
                nexts.add(new int[]{nextX, nextY});
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, int[][] maze) {
        return 0 <= x && x < maze.length && 0 <= y && y < maze[0].length;
    }
}
