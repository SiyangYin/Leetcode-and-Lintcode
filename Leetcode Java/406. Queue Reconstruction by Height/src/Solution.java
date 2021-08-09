import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
        
        for (int[] cur : people) {
            queue.offer(cur);
        }
        
        List<int[]> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] person = queue.poll();
            res.add(person[1], person);
        }
        
        return res.toArray(new int[people.length][2]);
    }
    
    public static void main(String[] args) {
        int[][] p = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(new Solution().reconstructQueue(p)));
    }
}
