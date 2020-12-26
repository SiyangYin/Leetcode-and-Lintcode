import java.util.PriorityQueue;

public class Solution2 {
    
    class Pair {
        int x, y, val;
        
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.val, p2.val));
        for (int i = 0; i < matrix.length; i++) {
            minHeap.offer(new Pair(i, 0, matrix[i][0]));
        }
        
        for (int i = 1; i <= k - 1; i++) {
            Pair cur = minHeap.poll();
            if (cur.y + 1 < matrix[0].length) {
                minHeap.offer(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
            }
        }
        
        return minHeap.peek().val;
    }
    
    public static void main(String[] args) {
        int[][] mat = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(new Solution2().kthSmallest(mat, 8));
    }
}
