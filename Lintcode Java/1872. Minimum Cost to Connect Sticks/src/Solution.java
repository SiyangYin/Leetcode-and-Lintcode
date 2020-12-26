import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param sticks: the length of sticks
     * @return: Minimum Cost to Connect Sticks
     */
    public int MinimumCost(List<Integer> sticks) {
        // write your code here
        int res = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(sticks);
        
        while (minHeap.size() >= 2) {
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();
            
            res += min1 + min2;
            minHeap.offer(min1 + min2);
        }
        
        return res;
    }
}
