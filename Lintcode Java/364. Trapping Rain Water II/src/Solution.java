import java.util.PriorityQueue;

public class Solution {
    
    class Pair {
        int x, y, height;
        
        public Pair(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
    
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
        if (heights == null || heights.length <= 2 || heights[0].length <= 2) {
            return 0;
        }
        
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.height, p2.height));
        
        int m = heights.length, n = heights[0].length;
        
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Pair(i, 0, heights[i][0]));
            minHeap.offer(new Pair(i, n - 1, heights[i][n - 1]));
            visited[i][0] = visited[i][n - 1] = true;
        }
        
        
        for (int i = 1; i < n - 1; i++) {
            minHeap.offer(new Pair(0, i, heights[0][i]));
            minHeap.offer(new Pair(m - 1, i, heights[m - 1][i]));
            visited[0][i] = visited[m - 1][i] = true;
        }
        
        int res = 0, minH = 0;
        int[] d = {1, 0, -1, 0, 1};
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            if (cur.height > minH) {
                minH = cur.height;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + d[i], nextY = cur.y + d[i + 1];
                if (0 <= nextX && nextX < heights.length && 0 <= nextY && nextY < heights[0].length && !visited[nextX][nextY]) {
                    minHeap.offer(new Pair(nextX, nextY, heights[nextX][nextY]));
                    res += Math.max(0, minH - heights[nextX][nextY]);
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] h = {
                {12, 13, 0, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}};
        
        // int[][] h = {{2,2,2,2},{2,2,3,4},{3,3,3,1},{2,3,4,5}};
        
        System.out.println(new Solution().trapRainWater(h));
    }
}
