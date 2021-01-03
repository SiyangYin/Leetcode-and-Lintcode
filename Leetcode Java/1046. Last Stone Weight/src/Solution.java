import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> -Integer.compare(x, y));
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        while (maxHeap.size() > 1) {
            int x = maxHeap.poll(), y = maxHeap.poll();
            if (x != y) {
                maxHeap.offer(Math.abs(x - y));
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
