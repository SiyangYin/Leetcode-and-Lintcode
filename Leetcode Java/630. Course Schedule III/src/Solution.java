import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c1, c2) -> Integer.compare(c1[1], c2[1]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((c1, c2) -> -Integer.compare(c1[0], c2[0]));
    
        int total = 0;
        for (int[] course : courses) {
            total += course[0];
            maxHeap.offer(course);
            if (total > course[1]) {
                total -= maxHeap.poll()[0];
            }
        }
        
        return maxHeap.size();
    }
}
