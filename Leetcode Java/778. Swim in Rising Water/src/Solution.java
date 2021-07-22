import java.util.PriorityQueue;

public class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[0], p2[0]));
        int[] d = {-1, 0, 1, 0, -1};
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int x = cur[1], y = cur[2];
            
            for (int i = 0; i < 4; i++) {
                int nextX = x + d[i], nextY = y + d[i + 1];
                if (0 <= nextX && nextX < grid.length && 0 <= nextY && nextY < grid[0].length && !vis[nextX][nextY]) {
                    if (nextX == grid.length - 1 && nextY == grid[0].length - 1) {
                        return Math.max(cur[0], grid[nextX][nextY]);
                    }
                    
                    vis[nextX][nextY] = true;
                    minHeap.offer(new int[]{Math.max(cur[0], grid[nextX][nextY]), nextX, nextY});
                }
            }
        }
        
        return -1;
    }
}
