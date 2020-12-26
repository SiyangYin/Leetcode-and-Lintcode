import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    class Pair implements Comparable<Pair> {
        int x, y, distance;
        String path;
        
        Pair(int x, int y, int distance, String path) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.path = path;
        }
        
        @Override
        public int compareTo(Pair p) {
            if (distance != p.distance) {
                return distance < p.distance ? -1 : 1;
            } else {
                return this.path.compareTo(p.path);
            }
        }
    }
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return "impossible";
        }
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        minHeap.offer(new Pair(ball[0], ball[1], 0, ""));
        
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            if (cur.x == hole[0] && cur.y == hole[1]) {
                return cur.path;
            }
            
            if (visited[cur.x][cur.y]) {
                continue;
            }
            
            visited[cur.x][cur.y] = true;
            for (Pair next : getNexts(cur, hole, maze, dirs, visited)) {
                minHeap.offer(next);
            }
            
        }
        
        return "impossible";
    }
    
    private List<Pair> getNexts(Pair cur, int[] hole, int[][] maze, int[][] dirs, boolean[][] visited) {
        int x = cur.x, y = cur.y;
        List<Pair> nexts = new ArrayList<>();
        for (int i = 0; i < dirs.length; i++) {
            int dx = dirs[i][0], dy = dirs[i][1];
            int step = 1;
            int curX = x + step * dx, curY = y + step * dy;
            while (inBound(curX, curY, maze) && maze[curX][curY] == 0 && !(curX == hole[0] && curY == hole[1])) {
                step++;
                curX = x + step * dx;
                curY = y + step * dy;
            }
    
            if (curX == hole[0] && curY == hole[1]) {
                step++;
            }
            
            step--;
            int nextX = x + step * dx, nextY = y + step * dy;
            if (!visited[nextX][nextY]) {
                String path = cur.path;
                switch (i) {
                    case 0: path += 'r'; break;
                    case 1: path += 'd'; break;
                    case 2: path += 'l'; break;
                    case 3: path += 'u'; break;
                    default: break;
                }
                
                nexts.add(new Pair(nextX, nextY, cur.distance + step, path));
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, int[][] maze) {
        return 0 <= x && x < maze.length && 0 <= y && y < maze[0].length;
    }
    
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0}};
        int[] start = {4, 3};
        int[] dest = {0, 1};
        System.out.println(new Solution().findShortestWay(maze, start, dest));
    }
}
