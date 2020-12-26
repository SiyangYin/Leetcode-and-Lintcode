import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
        
        int res = 0, last = -1, idx = 0;
        while (idx < events.length || !minHeap.isEmpty()) {
            if (minHeap.isEmpty()) {
                last = events[idx][0];
                while (idx < events.length && events[idx][0] == last) {
                    minHeap.offer(events[idx]);
                    idx++;
                }
            }
            
            minHeap.poll();
            last++;
            res++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // int[][] eve = {{1, 2}, {1, 2}, {1, 6}, {1, 2}, {1, 2}};
        // int[][] eve = {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}};
        int[][] eve = {{1, 5}, {1, 5}, {1, 5}, {2, 3}, {2, 3}};
        System.out.println(new Solution().maxEvents(eve));
    }
}
