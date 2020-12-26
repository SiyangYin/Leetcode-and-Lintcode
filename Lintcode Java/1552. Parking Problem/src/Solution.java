import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param a: the Parking Record
     * @return: The max number of cars
     */
    public int getMax(int[][] a) {
        // Write your code here
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((t1, t2) -> Integer.compare(t1[1], t2[1]));
        Arrays.sort(a, (t1, t2) -> Integer.compare(t1[0], t2[0]));
        
        for (int[] t : a) {
            if (t[0] >= t[1]) {
                continue;
            }
            
            if (!minHeap.isEmpty() && minHeap.peek()[1] <= t[0]) {
                minHeap.poll();
            }
            
            minHeap.offer(t);
        }
        
        return minHeap.size();
    }
    
    public static void main(String[] args) {
        // int[][] a = {{1, 9}, {2, 8}, {3, 7}, {4, 6}, {5, 5}};
        int[][] a = {{1, 4}, {2, 4}, {3, 4}, {4, 5}, {5, 5}};
        System.out.println(new Solution().getMax(a));
    }
}
