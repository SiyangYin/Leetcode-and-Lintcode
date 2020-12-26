import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1], i2[1]));
    
        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek()[1] <= interval[0]) {
                minHeap.poll();
            }
            minHeap.offer(interval);
        }
        
        return minHeap.size();
    }
}
