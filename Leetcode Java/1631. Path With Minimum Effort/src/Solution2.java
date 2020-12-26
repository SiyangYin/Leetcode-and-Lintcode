import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2 {
    
    class Pair {
        int x, y, maxDiff;
        
        public Pair(int x, int y, int maxDiff) {
            this.x = x;
            this.y = y;
            this.maxDiff = maxDiff;
        }
    }
    
    public int minimumEffortPath(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        
        int m = heights.length, n = heights[0].length;
        if (m == 1 && n == 1) {
            return 0;
        }
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.maxDiff, p2.maxDiff));
        boolean[][] visited = new boolean[m][n];
        int[][] minMaxdiff = new int[m][n];
        
        for (int i = 0; i < minMaxdiff.length; i++) {
            Arrays.fill(minMaxdiff[i], Integer.MAX_VALUE);
        }
        
        int[] dir = {1, 0, -1, 0, 1};
        
        minHeap.offer(new Pair(0, 0, 0));
        minMaxdiff[0][0] = 0;
        
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            int x = cur.x, y = cur.y;
            if (x == m - 1 && y == n - 1) {
                return minMaxdiff[m - 1][n - 1];
            }
            
            visited[x][y] = true;
            
            for (int i = 0; i < 4; i++) {
                int nextX = x + dir[i], nextY = y + dir[i + 1];
                if (inBound(nextX, nextY, m, n) && !visited[nextX][nextY]) {
                    int curDiff = Math.abs(heights[nextX][nextY] - heights[x][y]);
                    int maxDiff = Math.max(curDiff, cur.maxDiff);
                    
                    if (minMaxdiff[nextX][nextY] > maxDiff) {
                        minMaxdiff[nextX][nextY] = maxDiff;
                        minHeap.offer(new Pair(nextX, nextY, maxDiff));
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean inBound(int x, int y, int m, int n) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }
    
    public static void main(String[] args) {
        int[][] h = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}};
        System.out.println(new Solution2().minimumEffortPath(h));
    }
}
