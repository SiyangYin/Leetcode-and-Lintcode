import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c1, c2) -> Integer.compare(c1[1], c2[1]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((c1, c2) -> -Integer.compare(c1, c2));
    
        int total = 0;
        for (int[] course : courses) {
            total += course[0];
            maxHeap.offer(course[0]);
            if (total > course[1]) {
                total -= maxHeap.poll();
            }
        }
        
        return maxHeap.size();
    }
}
