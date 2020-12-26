import java.util.*;

public class Solution {
    /**
     * @param Maze:
     * @return: nothing
     */
    public int Portal(char[][] Maze) {
        if (Maze == null || Maze.length == 0 || Maze[0].length == 0) {
            return -1;
        }
        
        boolean[][] visited = new boolean[Maze.length][Maze[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < Maze.length; i++) {
            for (int j = 0; j < Maze[0].length; j++) {
                if (Maze[i][j] == 'S') {
                    queue.offer(new int[]{i, j});
                    break;
                }
            }
            if (!queue.isEmpty()) {
                break;
            }
        }
        
        int[] s = queue.peek();
        visited[s[0]][s[1]] = true;
        
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] next : getNexts(cur, Maze)) {
                    int nextX = next[0], nextY = next[1];
                    if (Maze[nextX][nextY] == 'E') {
                        return res;
                    }
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private List<int[]> getNexts(int[] cur, char[][] Maze) {
        List<int[]> nexts = new ArrayList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < dirs.length; i++) {
            int nextX = cur[0] + dirs[i][0], nextY = cur[1] + dirs[i][1];
            if (0 <= nextX && nextX < Maze.length && 0 <= nextY && nextY < Maze[0].length && Maze[nextX][nextY] != '#') {
                nexts.add(new int[]{nextX, nextY});
            }
        }
        
        return nexts;
    }
}
