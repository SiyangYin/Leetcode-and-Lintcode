import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    /**
     * @param map: the map
     * @return: can you reach the endpoint
     */
    public boolean reachEndpoint(int[][] map) {
        // Write your code here
        if (map == null || map.length == 0 || map[0].length == 0) {
            return false;
        }
        
        if (map[0][0] == 0) {
            return false;
        }
        if (map[0][0] == 9) {
            return true;
        }
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        Set<Pair> visited = new HashSet<>(queue);
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dirs[i][0];
                int y = cur.y + dirs[i][1];
                Pair pair = new Pair(x, y);
                if (inBound(map, x, y) && !visited.contains(pair)) {
                    if (map[x][y] == 9) {
                        return true;
                    } else if (!visited.contains(pair) && map[x][y] == 1) {
                        queue.offer(pair);
                        visited.add(pair);
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean inBound(int[][] map, int x, int y) {
        return 0 <= x && x < map.length && 0 <= y && y < map[0].length;
    }
    
    class Pair {
        int x, y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return x == p.x && y == p.y;
        }
        
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
