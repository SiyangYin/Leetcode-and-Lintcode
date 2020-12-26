import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int size = grid.length;
        if (grid[0][0] != 0 || grid[size - 1][size - 1] != 0) {
            return -1;
        }
        if (size == 1) {
            return 1;
        }
        
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int beginPath = 1, endPath = 1;
        Queue<int[]> startQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<Integer> startVisited = new HashSet<>(), endVisited = new HashSet<>();
        startQueue.offer(new int[]{0, 0});
        endQueue.offer(new int[]{size - 1, size - 1});
        startVisited.add(0);
        endVisited.add(size * size - 1);
        
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            int startSize = startQueue.size(), endSize = endQueue.size();
            for (int i = 0; i < startSize; i++) {
                int[] cur = startQueue.poll();
                for (int j = 0; j < 8; j++) {
                    int x = cur[0] + dirs[j][0];
                    int y = cur[1] + dirs[j][1];
                    if (inBound(grid, x, y)) {
                        if (endVisited.contains(coordToInt(grid, x, y))) {
                            return beginPath + endPath;
                        }
                        if (grid[x][y] == 0 && !startVisited.contains(coordToInt(grid, x, y))) {
                            startQueue.offer(new int[]{x, y});
                            startVisited.add(coordToInt(grid, x, y));
                        }
                    }
                }
            }
            beginPath++;
            
            for (int i = 0; i < endSize; i++) {
                int[] cur = endQueue.poll();
                for (int j = 0; j < 8; j++) {
                    int x = cur[0] + dirs[j][0];
                    int y = cur[1] + dirs[j][1];
                    if (inBound(grid, x, y)) {
                        if (startVisited.contains(coordToInt(grid, x, y))) {
                            return beginPath + endPath;
                        }
                        if (grid[x][y] == 0 && !endVisited.contains(coordToInt(grid, x, y))) {
                            endQueue.offer(new int[]{x, y});
                            endVisited.add(coordToInt(grid, x, y));
                        }
                    }
                }
            }
            endPath++;
        }
        
        return -1;
    }
    
    private int coordToInt(int[][] grid, int x, int y) {
        return x * grid.length + y;
    }
    
    private boolean inBound(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1},
                {1, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0}};
        
        int[][] grid2 = {{0, 1}, {1, 0}};
        System.out.println(new Solution().shortestPathBinaryMatrix(grid));
        System.out.println(new Solution().shortestPathBinaryMatrix(grid2));
    }
}
