import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numDistinctIslands2(int[][] grid) {
        double eps = 1E-10;
        
        List<int[]> list = new ArrayList<>();
        List<Double> hashList = new ArrayList<>();
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    list.clear();
                    
                    dfs(i, j, grid, list, d);
                    double hash = hash(list);
                    boolean found = false;
                    for (Double v : hashList) {
                        if (Math.abs(v - hash) < eps) {
                            found = true;
                            break;
                        }
                    }
                    
                    if (!found) {
                        hashList.add(hash);
                    }
                }
            }
        }
        
        return hashList.size();
    }
    
    private double hash(List<int[]> list) {
        double hash = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int[] p1 = list.get(i), p2 = list.get(j);
                hash += Math.sqrt(pow2(p1[0] - p2[0]) + pow2(p1[1] - p2[1]));
            }
        }
        
        return hash;
    }
    
    private double pow2(int x) {
        return x * x;
    }
    
    private void dfs(int x, int y, int[][] grid, List<int[]> list, int[] d) {
        list.add(new int[]{x, y});
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < grid.length && 0 <= nextY && nextY < grid[0].length && grid[nextX][nextY] == 1) {
                dfs(nextX, nextY, grid, list, d);
            }
        }
    }
}
