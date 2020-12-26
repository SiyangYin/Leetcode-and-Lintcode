import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(((o1, o2) ->
                            distanceSquared(o1) > distanceSquared(o2) ? -1 : 1));
        for (int i = 0; i < K; i++) {
            heap.offer(points[i]);
        }
    
        for (int i = K; i < points.length; i++) {
            if (distanceSquared(points[i]) < distanceSquared(heap.peek())) {
                heap.poll();
                heap.offer(points[i]);
            }
        }
        
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] cur = heap.poll();
            res[i][0] = cur[0];
            res[i][1] = cur[1];
        }
        
        return res;
    }
    
    private int distanceSquared(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
    
        System.out.println(Arrays.deepToString(new Solution().kClosest(points, 1)));
    }
}
