import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {
    
    class Pair {
        int x, y, h;
        
        public Pair(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.h, p2.h));
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Pair(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            minHeap.offer(new Pair(i, n - 1, heightMap[i][n - 1]));
            visited[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Pair(0, i, heightMap[0][i]));
            visited[0][i] = true;
            minHeap.offer(new Pair(m - 1, i, heightMap[m - 1][i]));
            visited[m - 1][i] = true;
        }
        
        int res = 0;
        int[] d = {1, 0, -1, 0, 1};
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + d[i], nextY = cur.y + d[i + 1];
                if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n) {
                    if (visited[nextX][nextY]) {
                        continue;
                    }
                    
                    res += Math.max(0, cur.h - heightMap[nextX][nextY]);
                    
                    Pair next = new Pair(nextX, nextY, Math.max(cur.h, heightMap[nextX][nextY]));
                    visited[nextX][nextY] = true;
                    minHeap.offer(next);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] h = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        System.out.println(new Solution().trapRainWater(h));
    }
}
