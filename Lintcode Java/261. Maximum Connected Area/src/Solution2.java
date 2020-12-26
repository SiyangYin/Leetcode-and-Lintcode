import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    /**
     * @param matrix: the matrix for calculation.
     * @return: return the max area after operation at most once.
     */
    public int maxArea(int[][] matrix) {
        // write your code here.
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int[][] id = new int[m][n];
        int idx = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    map.put(idx, dfs(i, j, matrix, id, idx, visited));
                    idx++;
                }
            }
        }
    
        int res = 0;
        boolean found = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    found = true;
                    Set<Integer> ids = new HashSet<>();
                    int[] d = {1, 0, -1, 0, 1};
                    
                    int curArea = 1;
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + d[k], nextY = j + d[k + 1];
                        if (inBound(nextX, nextY, matrix) && matrix[nextX][nextY] == 1) {
                            int curId = id[nextX][nextY];
                            if (!ids.contains(curId)) {
                                ids.add(curId);
                                curArea += map.get(curId);
                            }
                        }
                    }
                    
                    res = Math.max(res, curArea);
                }
            }
        }
        
        return found ? res : m * n;
    }
    
    private int dfs(int x, int y, int[][] matrix, int[][] id, int idx, boolean[][] visited) {
        visited[x][y] = true;
        id[x][y] = idx;
        
        int[] d = {1, 0, -1, 0, 1};
        
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, matrix) && matrix[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                area += dfs(nextX, nextY, matrix, id, idx, visited);
            }
        }
        
        return area;
    }
    
    private boolean inBound(int x, int y, int[][] matrix) {
        return 0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length;
    }
}
