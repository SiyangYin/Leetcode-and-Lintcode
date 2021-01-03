import java.util.PriorityQueue;

public class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : A) {
            minHeap.offer(i);
        }
        
        while (K > 0) {
            K--;
            minHeap.offer(-minHeap.poll());
        }
        
        int res = 0;
        
        while (!minHeap.isEmpty()) {
            res += minHeap.poll();
        }
        
        return res;
    }
}
