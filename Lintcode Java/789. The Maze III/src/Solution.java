import java.util.*;

public class Solution {
    
    class Pair {
        int x, y, dis;
        String path;
        
        public Pair(int x, int y, int dis, String path) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.path = path;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair entry = (Pair) o;
            return x == entry.x && y == entry.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    /**
     * @param maze: the maze
     * @param ball: the ball position
     * @param hole: the hole position
     * @return: the lexicographically smallest way
     */
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        // write your code here
        if (Arrays.equals(ball, hole)) {
            return "";
        }
        
        Pair start = new Pair(ball[0], ball[1], 0, "");
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> p1.dis != p2.dis ? Integer.compare(p1.dis, p2.dis) : p1.path.compareTo(p2.path));
        Set<Pair> visited = new HashSet<>();
        
        minHeap.offer(start);
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            
            if (cur.x == hole[0] && cur.y == hole[1]) {
                return cur.path;
            }
            
            if (visited.contains(cur)) {
                continue;
            }
            
            visited.add(cur);
            
            for (Pair next : getNexts(cur, maze, hole, visited)) {
                minHeap.offer(next);
            }
        }
        
        
        return "impossible";
    }
    
    private List<Pair> getNexts(Pair cur, int[][] maze, int[] hole, Set<Pair> visited) {
        List<Pair> nexts = new ArrayList<>();
        int x = cur.x, y = cur.y;
        
        int[] d = {1, 0, -1, 0, 1};
        char[] dir = {'d', 'l', 'u', 'r'};
        for (int i = 0; i < 4; i++) {
            int curx = x, cury = y;
            int diff = 0;
            while (inBound(curx, cury, maze) && maze[curx][cury] != 1 && !(curx == hole[0] && cury == hole[1])) {
                curx += d[i];
                cury += d[i + 1];
                diff++;
            }
            
            if (!(curx == hole[0] && cury == hole[1])) {
                curx -= d[i];
                cury -= d[i + 1];
                diff--;
            } else {
                nexts.clear();
                nexts.add(new Pair(curx, cury, cur.dis + diff, cur.path + dir[i]));
                return nexts;
            }
            
            if (diff == 0) {
                continue;
            }
            
            Pair next = new Pair(curx, cury, cur.dis + diff, cur.path + dir[i]);
            if (!visited.contains(next)) {
                nexts.add(next);
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, int[][] maze) {
        return 0 <= x && x < maze.length && 0 <= y && y < maze[0].length;
    }
    
    public static void main(String[] args) {
        int[][] maze = {{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
        int[] ball = {4, 3}, hole = {0, 1};
        System.out.println(Arrays.deepToString(maze));
        System.out.println(new Solution().findShortestWay(maze, ball, hole));
    }
}

