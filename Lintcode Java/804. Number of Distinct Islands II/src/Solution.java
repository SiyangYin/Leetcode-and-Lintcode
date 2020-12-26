import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    
    class Pair {
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    /**
     * @param grid: the 2D grid
     * @return: the number of distinct islands
     */
    public int numDistinctIslands2(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<Pair> island = new ArrayList<>();
                    dfs(i, j, grid, island);
                    set.add(getUniqueIsland(island));
                }
            }
        }
        
        return set.size();
    }
    
    private String getUniqueIsland(List<Pair> island) {
        List<String> islands = new ArrayList<>();
        
        int[][] tran = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0; i < 4; i++) {
            List<Pair> island1 = new ArrayList<>(), island2 = new ArrayList<>();
            for (Pair pair : island) {
                island1.add(new Pair(tran[i][0] * pair.x, tran[i][1] * pair.y));
                island2.add(new Pair(tran[i][0] * pair.y, tran[i][1] * pair.x));
            }
            
            islands.add(islandToString(island1));
            islands.add(islandToString(island2));
        }
        
        islands.sort(String::compareTo);
        return islands.get(0);
    }
    
    private String islandToString(List<Pair> island) {
        island.sort((a, b) -> {
            if (a.x != b.x) {
                return Integer.compare(a.x, b.x);
            } else {
                return Integer.compare(a.y, b.y);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        int origX = island.get(0).x, origY = island.get(0).y;
        
        for (Pair pair : island) {
            sb.append(pair.x - origX).append(' ').append(pair.y - origY).append(' ');
        }
        
        return sb.toString();
    }
    
    private void dfs(int x, int y, int[][] grid, List<Pair> island) {
        island.add(new Pair(x, y));
        
        grid[x][y] = 0;
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < grid.length && 0 <= nextY && nextY < grid[0].length && grid[nextX][nextY] == 1) {
                dfs(nextX, nextY, grid, island);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] g = {
                {1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1}};
        System.out.println(new Solution().numDistinctIslands2(g));
    }
}
