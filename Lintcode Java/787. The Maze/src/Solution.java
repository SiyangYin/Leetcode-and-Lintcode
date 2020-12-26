import java.util.*;

public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start[0] + "," + start[1]);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            List<int[]> dest = getDestination(cur, maze, visited);
            for (int[] pos : dest) {
                if (Arrays.equals(pos, destination)) {
                    return true;
                }
                String posString = pos[0] + "," + pos[1];
                if (!visited.contains(posString)){
                    queue.offer(pos);
                    visited.add(posString);
                }
            }
        }
        
        return false;
    }
    
    private List<int[]> getDestination(int[] cur, int[][] maze, Set<String> visited) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<int[]> dest = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int x = cur[0], y = cur[1];
            while (inBoard(x, y, maze) && maze[x][y] != 1) {
                x += dirs[i][0];
                y += dirs[i][1];
            }
            x -= dirs[i][0];
            y -= dirs[i][1];
            if (!visited.contains(x + "," + y)) {
                dest.add(new int[]{x, y});
            }
        }
        
        return dest;
    }
    
    private boolean inBoard(int x, int y, int[][] maze) {
        return 0 <= x && x < maze.length && 0 <= y && y < maze[0].length;
    }
}
