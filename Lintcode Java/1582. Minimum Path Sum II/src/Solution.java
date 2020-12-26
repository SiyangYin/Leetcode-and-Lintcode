import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    
    class Pair {
        int x, y, sum;
        
        public Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
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
    
    /**
     * @param matrix: a matrix
     * @return: the minimum height
     */
    public int minPathSumII(int[][] matrix) {
        // Write your code here
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.sum, p2.sum));
        
        int m = matrix.length, n = matrix[0].length;
        minHeap.offer(new Pair(m - 1, 0, matrix[m - 1][0]));
        
        Set<Pair> visited = new HashSet<>();
        int[] d = {1, 0, -1, 0, 1};
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            if (cur.x == 0 && cur.y == n - 1) {
                return cur.sum;
            }
    
            if (visited.contains(cur)) {
                continue;
            }
            
            visited.add(cur);
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + d[i], nextY = cur.y + d[i + 1];
                if (inBound(nextX, nextY, matrix)) {
                    Pair next = new Pair(nextX, nextY, cur.sum + matrix[nextX][nextY]);
                    if (!visited.contains(next)) {
                        minHeap.offer(next);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean inBound(int x, int y, int[][] matrix) {
        return 0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length;
    }
    
    public static void main(String[] args) {
        int[][] mat = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(new Solution().minPathSumII(mat));
    }
}
