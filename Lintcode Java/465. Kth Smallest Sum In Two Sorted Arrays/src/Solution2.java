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
    
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.val, p2.val));
        for (int i = 0; i < B.length; i++) {
            minHeap.offer(new Pair(i, 0, B[i] + A[0]));
        }
    
        for (int i = 1; i <= k - 1; i++) {
            Pair cur = minHeap.poll();
            if (cur.y < A.length - 1) {
                minHeap.offer(new Pair(cur.x, cur.y + 1, B[cur.x] + A[cur.y + 1]));
            }
        }
        
        return minHeap.peek().val;
    }
}
