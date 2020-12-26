import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    class Pair implements Comparable<Pair> {
        int x, y, distance;
        
        Pair(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Pair p) {
            if (distance != p.distance) {
                return distance < p.distance ? -1 : 1;
            } else {
                return 0;
            }
        }
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return -1;
        }
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        minHeap.offer(new Pair(start[0], start[1], 0));
        
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            if (cur.x == destination[0] && cur.y == destination[1]) {
                return cur.distance;
            }
            
            if (visited[cur.x][cur.y]) {
                continue;
            }
            
            visited[cur.x][cur.y] = true;
            for (Pair next : getNexts(cur, maze, dirs, visited)) {
                minHeap.offer(next);
            }
    
        }
        
        return -1;
    }
    
    private List<Pair> getNexts(Pair cur, int[][] maze, int[][] dirs, boolean[][] visited) {
        int x = cur.x, y = cur.y;
        List<Pair> nexts = new ArrayList<>();
        for (int i = 0; i < dirs.length; i++) {
            int dx = dirs[i][0], dy = dirs[i][1];
            int step = 1;
            while (inBound(x + step * dx, y + step * dy, maze) && maze[x + step * dx][y + step * dy] == 0) {
                step++;
            }
            
            step--;
            int nextX = x + step * dx, nextY = y + step * dy;
            if (!visited[nextX][nextY]) {
                nexts.add(new Pair(nextX, nextY, cur.distance + step));
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, int[][] maze) {
        return 0 <= x && x < maze.length && 0 <= y && y < maze[0].length;
    }
    
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] dest = {2, 2};
        System.out.println(new Solution().shortestDistance(maze, start, dest));
    }
}
