import java.util.*;

public class Solution {
    
    class Pair {
        int x, y, val;
        
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
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
    
    public int kthSmallest(int[][] matrix, int k) {
        Pair start = new Pair(0,0,matrix[0][0]);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.val, p2.val));
        minHeap.offer(start);
        
        Set<Pair> visited = new HashSet<>();
        visited.add(start);
        
        int rank = 0;
        while (!minHeap.isEmpty()) {
            rank++;
            Pair cur = minHeap.poll();
            
            if (rank == k) {
                return cur.val;
            }
    
            for (Pair next : getNexts(cur, matrix, visited)) {
                minHeap.offer(next);
                visited.add(next);
            }
        }
        
        return 0;
    }
    
    private List<Pair> getNexts(Pair cur, int[][] matrix, Set<Pair> visited) {
        List<Pair> nexts = new ArrayList<>();
        int[] dx = {1,0}, dy = {0,1};
        for (int i = 0; i < 2; i++) {
            int nextX = cur.x + dx[i], nextY = cur.y + dy[i];
            if (inBound(nextX, nextY, matrix)) {
                Pair next = new Pair(nextX, nextY, matrix[nextX][nextY]);
                if (!visited.contains(next)) {
                    nexts.add(next);
                }
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, int[][] matrix) {
        return 0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length;
    }
}
