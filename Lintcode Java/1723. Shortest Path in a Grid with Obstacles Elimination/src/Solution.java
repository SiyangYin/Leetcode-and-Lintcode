import java.util.*;

public class Solution {
    
    class Pair {
        int x, y, obs;
        
        public Pair(int x, int y, int obs) {
            this.x = x;
            this.y = y;
            this.obs = obs;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y && obs == pair.obs;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y, obs);
        }
    }
    
    /**
     * @param grid: a list of list
     * @param k:    an integer
     * @return: Return the minimum number of steps to walk
     */
    public int shortestPath(int[][] grid, int k) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) {
            return 0;
        }
        
        Queue<Pair> queue = new LinkedList<>();
        Pair start = new Pair(0, 0, 0);
        queue.offer(start);
        
        Set<Pair> visited = new HashSet<>();
        visited.add(start);
        
        int[] dir = {1, 0, -1, 0, 1};
        
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                
                int x = cur.x, y = cur.y;
                for (int j = 0; j < 4; j++) {
                    int nextX = x + dir[j], nextY = y + dir[j + 1];
                    if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n) {
                        int obs = cur.obs;
                        if (obs + grid[nextX][nextY] <= k) {
                            if (nextX == m - 1 && nextY == n - 1) {
                                return res;
                            }
                            
                            Pair next = new Pair(nextX, nextY, obs + grid[nextX][nextY]);
                            if (!visited.contains(next)) {
                                visited.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[][] g = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        System.out.println(new Solution().shortestPath(g, 1));
    }
}
