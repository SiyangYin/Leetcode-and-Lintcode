import java.util.*;

public class Solution {
    
    class Pair {
        int x, y;
    
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    /**
     * @param maze: the map of maze
     * @param start: the start points
     * @param endd: the end points
     * @return: Return the minimal steps
     */
    public int getAns(int[][] maze, int[][] start, int[][] endd) {
        // Write your code here
        Set<Pair> end = new HashSet<>();
        for (int[] e : endd) {
            end.add(new Pair(e[0], e[1]));
        }
        
        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        for (int[] s : start) {
            Pair ss = new Pair(s[0], s[1]);
            if (end.contains(ss)) {
                return 0;
            }
            
            queue.offer(ss);
            visited.add(ss);
        }
        
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                for (Pair next : getNexts(cur, maze, visited)) {
                    if (end.contains(next)) {
                        return res;
                    }
                    
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        
        return -1;
    }
    
    private List<Pair> getNexts(Pair cur, int[][] maze, Set<Pair> visited) {
        List<Pair> nexts = new ArrayList<>();
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = cur.x + d[i], nextY = cur.y + d[i + 1];
            if (0 <= nextX && nextX < maze.length && 0 <= nextY && nextY < maze[0].length && maze[nextX][nextY] != 1) {
                Pair next = new Pair(nextX, nextY);
                if (!visited.contains(next)) {
                    nexts.add(next);
                }
            }
        }
        
        return nexts;
    }
}
