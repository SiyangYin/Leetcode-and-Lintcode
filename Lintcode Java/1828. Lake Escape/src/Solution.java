import java.util.*;

public class Solution {
    
    class Pair {
        int x, y;
        boolean flag;
        
        public Pair(int x, int y, boolean flag) {
            this.x = x;
            this.y = y;
            this.flag = flag;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y && flag == pair.flag;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y, flag);
        }
    
        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", flag=" + flag +
                    '}';
        }
    }
    
    /**
     * @param side_length:   the length of a side of the lake (it's a square)
     * @param lake_grid:     a 2D matrix representing the lake 0= ice, 1= snowbank, -1= hole
     * @param albert_row:    row of Albert's snowbank
     * @param albert_column: column of Albert's snowbank
     * @param kuna_row:      row of Kuna's snowbank
     * @param kuna_column:   column of Kuna's snowbank
     * @return: a bool - whether Albert can escape
     */
    public boolean lakeEscape(int side_length, int[][] lake_grid, int albert_row, int albert_column, int kuna_row, int kuna_column) {
        // write your code here
        Pair start = new Pair(albert_row, albert_column, false);
        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (Pair next : getNexts(cur, lake_grid, visited, new int[]{kuna_row, kuna_column})) {
                int x = next.x, y = next.y;
                if (!inBound(x, y, lake_grid) && cur.flag) {
                    System.out.println(cur);
                    return true;
                }
                
                visited.add(next);
                queue.offer(next);
            }
        }
        
        return false;
    }
    
    private List<Pair> getNexts(Pair cur, int[][] lake_grid, Set<Pair> visited, int[] kuna) {
        List<Pair> nexts = new ArrayList<>();
        int[] d = {1, 0, -1, 0, 1};
        int x = cur.x, y = cur.y;
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            while (inBound(nextX, nextY, lake_grid) && lake_grid[nextX][nextY] == 0) {
                nextX += d[i];
                nextY += d[i + 1];
            }
            
            if (!inBound(nextX, nextY, lake_grid)) {
                if (cur.flag) {
                    return Arrays.asList(new Pair(nextX, nextY, true));
                }
            } else if (lake_grid[nextX][nextY] == 1) {
                Pair next = new Pair(nextX, nextY, cur.flag || (nextX == kuna[0] && nextY == kuna[1]));
                if (!visited.contains(next)) {
                    nexts.add(next);
                }
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] g = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, -1, 0, 0, 0, 0},
                {0, 0, 1, -1, 0, -1, 0},
                {-1, 0, 1, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 1, 0},
                {-1, 0, -1, 0, -1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}};
        System.out.println(new Solution().lakeEscape(g.length, g, 4, 1, 3, 2));
    }
}
