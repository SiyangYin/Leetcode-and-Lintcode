import java.util.PriorityQueue;

public class Solution2 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> -Integer.compare(p1[1]-p1[0], p2[1]-p2[0]));
        for (int[] point : points) {
            while (!maxHeap.isEmpty() && maxHeap.peek()[0] < point[0] - k) {
                maxHeap.poll();
            }
            
            if (!maxHeap.isEmpty()) {
                res = Math.max(res, point[0] + point[1] + maxHeap.peek()[1] - maxHeap.peek()[0]);
            }
            
            maxHeap.offer(point);
        }
        
        return res;
    }
}
