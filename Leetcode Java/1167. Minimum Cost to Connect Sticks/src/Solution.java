import java.util.PriorityQueue;

public class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) {
            minHeap.offer(stick);
        }
        
        int res = 0;
        while (minHeap.size() >= 2) {
            int x = minHeap.poll(), y = minHeap.poll();
            res += x + y;
            
            minHeap.offer(x + y);
        }
        
        return res;
    }
}
