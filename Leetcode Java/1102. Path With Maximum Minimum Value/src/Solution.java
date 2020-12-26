import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    
    class Pair {
        int x, y, maxMin;
        
        public Pair(int x, int y, int maxMin) {
            this.x = x;
            this.y = y;
            this.maxMin = maxMin;
        }
    }
    
    public int maximumMinimumPath(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] maxMinMat = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> -Integer.compare(p1.maxMin, p2.maxMin));
        maxHeap.offer(new Pair(0, 0, A[0][0]));
        for (int[] arr : maxMinMat) {
            Arrays.fill(arr, 0);
        }
        maxMinMat[0][0] = A[0][0];
        
        int[] dir = {1, 0, -1, 0, 1};
        while (!maxHeap.isEmpty()) {
            Pair cur = maxHeap.poll();
            int x = cur.x, y = cur.y;
            if (x == m - 1 && y == n - 1) {
                return maxMinMat[x][y];
            }
            
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dir[i], nextY = y + dir[i + 1];
                if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && !visited[nextX][nextY]) {
                    int curMaxMin = Math.min(cur.maxMin, A[nextX][nextY]);
                    if (maxMinMat[nextX][nextY] < curMaxMin) {
                        maxMinMat[nextX][nextY] = curMaxMin;
                        maxHeap.offer(new Pair(nextX, nextY, curMaxMin));
                    }
                }
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        int[][] A = {{5, 4, 5}, {1, 2, 6}, {7, 4, 6}};
        System.out.println(new Solution().maximumMinimumPath(A));
    }
}
