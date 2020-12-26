import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    class Pair {
        int x, y, dist;
        
        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    /**
     * @param maze:        the maze
     * @param start:       the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        PriorityQueue<Pair> queue = new PriorityQueue<>((v1, v2) -> v1.dist < v2.dist ? -1 : 1);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        queue.offer(new Pair(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            List<Pair> nexts = getNext(cur, maze, visited);
            for (Pair next : nexts) {
                if (next.x == destination[0] && next.y == destination[1]) {
                    return next.dist;
                }
                queue.offer(next);
                visited[next.x][next.y] = true;
            }
        }
        
        return -1;
    }
    
    private List<Pair> getNext(Pair cur, int[][] maze, boolean[][] visited) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Pair> dest = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int x = cur.x, y = cur.y, dist = 0;
            while (inBound(x, y, maze) && maze[x][y] != 1) {
                x += dirs[i][0];
                y += dirs[i][1];
                dist++;
            }
            x -= dirs[i][0];
            y -= dirs[i][1];
            dist--;
            
            if (!visited[x][y]) {
                dest.add(new Pair(x, y, cur.dist + dist));
            }
        }
        
        return dest;
    }
    
    private boolean inBound(int x, int y, int[][] maze) {
        return 0 <= x && x < maze.length && 0 <= y && y < maze[0].length;
    }
    
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 1, 1, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                
                {0, 0, 0, 0, 0, 0, 0, 0}};
        
        System.out.println(new Solution().shortestDistance(maze, new int[]{3, 0}, new int[]{1, 2}));
    }
}
